package com.lsy.code.web.servlet.management;

import com.lsy.code.dao.UserDao;
import com.lsy.code.domain.BeanPage;
import com.lsy.code.domain.User;
import com.lsy.code.utils.BaseServlet;
import com.lsy.code.utils.BeanFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class UserServlet extends BaseServlet {

    public String listpage(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        Integer currentPage = Integer.parseInt(request.getParameter("currentPage"));//start with 1
        UserDao userDao = (UserDao) BeanFactory.getInstance("userDao");
        BeanPage<User> beanPage = new BeanPage<User>();
        beanPage.setCurrentPage(currentPage);
        int totalCount = userDao.count().intValue();
        beanPage.setTotalCount(totalCount);
        beanPage.setTotalPage(totalCount % beanPage.getSize() == 0 ? totalCount / beanPage.getSize() : totalCount / beanPage.getSize() + 1);
        beanPage.setList(userDao.find((currentPage - 1) * beanPage.getSize(), beanPage.getSize()));
        request.setAttribute("beanPage", beanPage);
        request.setAttribute("pageurl", "user");
        return "/admin/user/list.jsp";
    }
}
