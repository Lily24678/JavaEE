package com.lsy.code.demo.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 用于测试：session依赖cookie，如果浏览器禁用了cookie的解决办法
 */
public class DisableCookieServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        String msg;
        if (session.isNew()) {
            System.out.println("session创建成功，session的id是：" + session.getId());
            msg = "session创建成功，session的id是：" + session.getId();
        } else {
            System.out.println("服务器已经存在该session了，session的id是：" + session.getId());
            msg = "服务器已经存在该session了，session的id是：" + session.getId();
        }
        session.setAttribute("data", "session依赖cookie，如果浏览器禁用了cookie。" + msg);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        HttpSession session = req.getSession();
        if (session.isNew()) {
            System.out.println("session创建成功，session的id是：" + session.getId());
        } else {
            System.out.println("服务器已经存在该session了，session的id是：" + session.getId());
        }
        System.out.println(session.getAttribute("data"));
        resp.getWriter().println(session.getAttribute("data"));
    }
}
