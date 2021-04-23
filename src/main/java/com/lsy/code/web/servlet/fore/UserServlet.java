package com.lsy.code.web.servlet.fore;

import com.lsy.code.dao.UserDao;
import com.lsy.code.domain.User;
import com.lsy.code.utils.*;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

public class UserServlet extends BaseServlet {

    public String regist(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, SQLException {
        Map<String, String[]> map = request.getParameterMap();
        User user = new User();
        user.setUid(StringUtils.createStrByUUID());
        user.setState(0);
        ConvertUtils.register(new MyDataConverter(), Date.class);
        BeanUtils.populate(user, map);
        String code = StringUtils.createStrByUUID();
        user.setCode(code);
        UserDao userDao = (UserDao) BeanFactory.getInstance("userDao");
        userDao.add(user);

        //发送激活邮件
        MailUtils.sendMail(user.getEmail(), code);
        return "/fore/user?method=loginpage";
    }

    /**
     * 用户激活
     */
    public void active(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String code = request.getParameter("code");
        UserDao userDao = (UserDao) BeanFactory.getInstance("userDao");
        User user = userDao.findByCode(code);
        if (null == user) return;//如果对象不存在说明激活码有误
        userDao.updateCodeAndStateByUid(code,1,user.getUid());
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        UserDao userDao = (UserDao) BeanFactory.getInstance("userDao");
        User user = userDao.findByUsernameAndPassword(request.getParameter("username"), request.getParameter("password"));
        if (null == user) {
            response.getWriter().println("用户名或者密码错误");
            return;
        }
        if (0 == user.getState()) {
            response.getWriter().println("用户未激活");
            return;
        }
        request.getSession().setAttribute("user", user);
    }

    public String loginpage(HttpServletRequest request, HttpServletResponse response) {
        return "/fore/login.jsp";
    }

    public String registpage(HttpServletRequest request, HttpServletResponse response) {
        return "/fore/regist.jsp";
    }
}
