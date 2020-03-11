package com.lsy.code.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lsy.code.demo.utils.CreateDataUtils;
import com.lsy.code.demo.utils.ServletUtils;
/**
 * 自动登录的功能实现
 */
public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Filter实例 创建 ：服务器启动时创建。---LoginFilter");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		Cookie cookie = ServletUtils.getCookie("username", request);
		if (null != cookie) {
			String value = cookie.getValue();
			String[] split = value.split("-");
			if (split.length == 3 && "1".equals(split[2]) && CreateDataUtils.isExist(split[0], split[1]) == 1) {
				chain.doFilter(request, response);
			}
		}
		//req.getRequestDispatcher("/login.html").forward(request, response);;
		resp.sendRedirect(req.getContextPath()+"/login.html");
	}

	@Override
	public void destroy() {
		System.out.println("Filter实例 销毁：服务器关闭时销毁。---LoginFilter");
	}

}
