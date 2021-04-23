package com.lsy.code.web.filter.management;

import com.lsy.code.utils.CookieUtils;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        if (req.getRequestURI().endsWith("/admin/index.jsp")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        Cookie[] cookies = req.getCookies();
        Cookie cookie = CookieUtils.getCookie(cookies, "username");
        if (null != cookie) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        resp.sendRedirect(req.getContextPath() + "/admin/index.jsp");
    }

    @Override
    public void destroy() {

    }
}
