package com.lsy.code.demo.filter;

import java.io.IOException;
import java.util.logging.Logger;

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
	private static Logger logger = Logger.getLogger("com.lsy.code.demo.filter.StaticResourceFilter");

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("Filter实例 创建 ：服务器启动时创建。---StaticResourceFilter");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		logger.info("过滤器StaticResourceFilter功能---防止盗链；阻止通过Url直接访问服务器上的静态文件。");
		HttpServletRequest req = (HttpServletRequest) request;
		// 从 HTTP 头中取得 Referer 值
		String referer = req.getHeader("Referer");
		System.out.println(referer);
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
		logger.info("Filter实例 销毁：服务器关闭时销毁。---StaticResourceFilter");
	}

}
