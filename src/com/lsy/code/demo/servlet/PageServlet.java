package com.lsy.code.demo.servlet;

import com.lsy.code.servlet.BaseServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 页面跳转
 */
@SuppressWarnings("serial")
public class PageServlet extends BaseServlet {

      /**
     * 重定向到登陆页面
     */
    public void login(HttpServletRequest request, HttpServletResponse response) {
        //response.sendRedirect(request.getContextPath()+"/demo/login.html");
        response.setStatus(302);
        response.setHeader("Location", request.getContextPath() + "/demo/login.html");

    }
}
