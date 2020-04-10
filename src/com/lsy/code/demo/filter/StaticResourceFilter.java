package com.lsy.code.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 阻止通过Url直接访问服务器上的静态文件
 */
public class StaticResourceFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		// 从 HTTP 头中取得 Referer 值
		String referer = req.getHeader("Referer");
		if (req.getRequestURL().toString().endsWith("JavaEE/")) {
			chain.doFilter(request, response);
		} else if (referer != null) {
			chain.doFilter(request, response);
		} else {
			req.getRequestDispatcher("error.html").forward(request, response);
		}
	}

	@Override
	public void destroy() {
	}

}
