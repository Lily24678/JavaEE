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

public class GenericEncodingFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		 MyGenericEncoding myGenericEncoding = new MyGenericEncoding((HttpServletRequest) request);
		 chain.doFilter(myGenericEncoding, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
