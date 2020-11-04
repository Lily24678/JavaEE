package com.lsy.code.demo.filter;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lsy.code.demo.utils.ServletUtils;
/**
 * 自动登录的功能实现
 */
public class LoginFilter implements Filter {
	private static Logger logger = Logger.getLogger("com.lsy.code.demo.filter.LoginFilter");

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("Filter实例 创建 ：服务器启动时创建。---LoginFilter");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		logger.info("过滤器LoginFilter功能---阻止未登录用户查看资源");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		Cookie cookie = ServletUtils.getCookie("username", request);
		if (null != cookie) {
			chain.doFilter(request, response);
			return;
		}
		req.getRequestDispatcher("/demo/login.html").forward(request, response);
//		resp.sendRedirect(req.getContextPath()+"/demo/login.html");
	}

	@Override
	public void destroy() {
		logger.info("Filter实例 销毁：服务器关闭时销毁。---LoginFilter");
	}

}
