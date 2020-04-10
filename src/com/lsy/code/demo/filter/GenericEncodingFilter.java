package com.lsy.code.demo.filter;

import java.io.IOException;

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

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Filter实例 创建 ：服务器启动时创建。---GenericEncodingFilter");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		response.setContentType("text/html;charset=UTF-8");//响应字符流乱码
		System.out.println("filter+装饰者模式，对请求中中文乱码进行处理。");
		MyGenericEncoding myGenericEncoding = new MyGenericEncoding((HttpServletRequest) request);
		 chain.doFilter(myGenericEncoding, response);
	}

	@Override
	public void destroy() {
		System.out.println("Filter实例 销毁：服务器关闭时销毁。---GenericEncodingFilter");
	}

}
