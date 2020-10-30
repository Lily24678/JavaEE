package com.lsy.code.filter;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Filter2 implements Filter {
	private static Logger logger = Logger.getLogger("com.lsy.code.filter.Filter2");

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("Filter实例 创建 ：服务器启动时创建。");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		logger.info("Filter对客户端请求过滤：Filter2");
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		logger.info("Filter实例 销毁：服务器关闭时销毁。");
	}

}
