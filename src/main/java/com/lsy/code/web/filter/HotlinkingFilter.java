package com.lsy.code.web.filter;

import com.lsy.code.utils.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 防盗链
 */
public class HotlinkingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String reqUrl = req.getRequestURL().toString();
        String domain = "http://localhost:8081" + req.getContextPath();
        if (reqUrl.equals(domain + "/admin/index.jsp") || reqUrl.equals(domain+"/")||reqUrl.startsWith(domain+"/fore/user?method=active")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        String referer = req.getHeader("Referer");
        if (StringUtils.isNotBlank(referer) && referer.startsWith("http://localhost:8081" + req.getContextPath())) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        servletResponse.setContentType("text/html;charset=UTF-8");
        servletResponse.getWriter().println("无法访问资源，请联系管理员");
    }

    @Override
    public void destroy() {

    }
}
