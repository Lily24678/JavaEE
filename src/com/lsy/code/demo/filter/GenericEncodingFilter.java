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

import com.lsy.code.demo.wrapper.MyGenericEncoding;
/**
 * 中文乱码处理
 */
public class GenericEncodingFilter implements Filter {
	private static Logger logger = Logger.getLogger("com.lsy.code.demo.filter.GenericEncodingFilter");

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("Filter实例 创建 ：服务器启动时创建。---GenericEncodingFilter");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		logger.info("过滤器GenericEncodingFilter功能---防止中文乱码");
		response.setContentType("text/html;charset=UTF-8");//响应字符流乱码
		logger.info("filter+装饰者模式，对请求中中文乱码进行处理。");
		//tomcat8.8.59不需要做中文乱码处理，tomcat7需要做中文乱码处理
//		MyGenericEncoding myGenericEncoding = new MyGenericEncoding((HttpServletRequest) request);
//		chain.doFilter(myGenericEncoding, response);
		chain.doFilter(request,response);
	}

	@Override
	public void destroy() {
		logger.info("Filter实例 销毁：服务器关闭时销毁。---GenericEncodingFilter");
	}

}
