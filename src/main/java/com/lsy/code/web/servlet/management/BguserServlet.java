package com.lsy.code.web.servlet.management;

import com.lsy.code.dao.BguserDao;
import com.lsy.code.domain.BeanPage;
import com.lsy.code.domain.Bguser;
import com.lsy.code.utils.BaseServlet;
import com.lsy.code.utils.BeanFactory;
import com.lsy.code.utils.StringUtils;
import com.lsy.code.utils.vo.MessageHandler;
import net.sf.json.JSONObject;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 后台管理用户
 */
public class BguserServlet extends BaseServlet {
    public void checklogin(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkcode = request.getParameter("checkcode");
        String autologin = request.getParameter("autologin");
        String remenberpassword = request.getParameter("remenberpassword");
        HttpSession session =request.getSession();
        if (StringUtils.isBlank(checkcode)||!checkcode.equalsIgnoreCase((String) session.getAttribute("code"))){//校验验证码
            response.getWriter().println(JSONObject.fromObject(MessageHandler.createMsgFailure("验证码错误")).toString());
            return;
        }
        BguserDao bguserDao = (BguserDao) BeanFactory.getInstance("bguserDao");
        Bguser bguser = bguserDao.findByUsernameAndPassword(username, password);
        if (null==bguser){//校验用户名及密码
            response.getWriter().println(JSONObject.fromObject(MessageHandler.createMsgFailure("用户名和密码错误")).toString());
            return;
        }
        if (StringUtils.isNotBlank(autologin)&&"1".equals(autologin)){//勾选自动登陆
            Cookie cookie = new Cookie("username", username);
            cookie.setPath(request.getContextPath()+"/mg");
            cookie.setMaxAge(60*60*24);
            response.addCookie(cookie);
        }else {
            Cookie cookie = new Cookie("username", username);
            cookie.setPath(request.getContextPath()+"/mg");
            response.addCookie(cookie);
        }
        if (StringUtils.isNotBlank(remenberpassword)&&"1".equals(remenberpassword)){//勾选记住密码
            Cookie cookie = new Cookie(username+"-password", password);
            cookie.setPath(request.getContextPath()+"/admin/index.jsp");
            cookie.setMaxAge(60*60*24);
            response.addCookie(cookie);
        }
        response.getWriter().println(JSONObject.fromObject(MessageHandler.createMsgSuccess("success")).toString());
    }

    public String add(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, SQLException, IOException {
        Map<String, String[]> map = request.getParameterMap();
        Bguser bguser = new Bguser();
        bguser.setIsdel(0);
        bguser.setState(0);
        bguser.setUpdatetime(new Date());
        BeanUtils.populate(bguser, map);
        BguserDao bguserDao = (BguserDao) BeanFactory.getInstance("bguserDao");
        bguserDao.add(bguser);
        return "/mg/bguser?method=listpage&currentPage=1";
    }

    public String del(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String bguid = request.getParameter("bguid");
        BguserDao bguserDao = (BguserDao) BeanFactory.getInstance("bguserDao");
        bguserDao.updateIsdelByBguid(1, bguid);
        return "/mg/bguser?method=listpage&currentPage=1";
    }

    public String edit(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, SQLException, IOException {
        Map<String, String[]> map = request.getParameterMap();
        Bguser bguser = new Bguser();
        bguser.setUpdatetime(new Date());
        BeanUtils.populate(bguser, map);
        BguserDao bguserDao = (BguserDao) BeanFactory.getInstance("bguserDao");
        bguserDao.update(bguser);
        return "/mg/bguser?method=listpage&currentPage=1";
    }

    public String listpage(HttpServletRequest request, HttpServletResponse response) throws SQLException {
       Integer currentPage = Integer.parseInt(request.getParameter("currentPage"));//start with 1
        BguserDao bguserDao = (BguserDao) BeanFactory.getInstance("bguserDao");
        BeanPage<Bguser> beanPage = new BeanPage<Bguser>();
        beanPage.setCurrentPage(currentPage);
        int totalCount = bguserDao.countByIsdel(0).intValue();
        beanPage.setTotalCount(totalCount);
        beanPage.setTotalPage(totalCount%beanPage.getSize()==0?totalCount/beanPage.getSize():totalCount/beanPage.getSize()+1);
        beanPage.setList(bguserDao.findByIsDel(0,(currentPage-1)*beanPage.getSize(),beanPage.getSize()));
        request.setAttribute("beanPage", beanPage);
        request.setAttribute("pageurl", "bguser");
        return "/admin/bguser/list.jsp";
    }

    public String addpage(HttpServletRequest request, HttpServletResponse response) {
        return "/admin/bguser/add.jsp";
    }

    public String editpage(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        BguserDao bguserDao = (BguserDao) BeanFactory.getInstance("bguserDao");
        Bguser bguser = bguserDao.findByBguid(request.getParameter("bguid"));
        request.setAttribute("bean", bguser);
        return "/admin/bguser/edit.jsp";
    }

    public void checkpassword(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        BguserDao bguserDao = (BguserDao) BeanFactory.getInstance("bguserDao");
        String password = request.getParameter("password");
        Bguser bguser = bguserDao.findByBguid(request.getParameter("bguid"));
        if (!bguser.getPassword().equals(password)){
            response.getWriter().println(JSONObject.fromObject(MessageHandler.createMsgFailure("密码不正确")).toString());
            return;
        }
        response.getWriter().println(JSONObject.fromObject(MessageHandler.createMsgSuccess("success")).toString());
    }

    public void checkusername(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String username = request.getParameter("username");
        String bguid = request.getParameter("bguid");
        String type = request.getParameter("type");
        BguserDao bguserDao = (BguserDao) BeanFactory.getInstance("bguserDao");
        if ("edit".equals(type)) {
            List<Bguser> list = bguserDao.findByUsernameAndIsdelAndBguidNot(username, 0, bguid);
            if (0 < list.size()) {
                response.getWriter().println(JSONObject.fromObject(MessageHandler.createMsgFailure("用户名重复")).toString());
                return;
            }
        }
        if ("add".equals(type)) {
            List<Bguser> list = bguserDao.findByUsernameAndIsdel(username, 0);
            if (0 < list.size()) {
                response.getWriter().println(JSONObject.fromObject(MessageHandler.createMsgFailure("用户名重复")).toString());
                return;
            }
        }
        response.getWriter().println(JSONObject.fromObject(MessageHandler.createMsgSuccess("success")).toString());
    }

    public String homepage(HttpServletRequest request, HttpServletResponse response){
        return "/admin/home.jsp";
    }
}
