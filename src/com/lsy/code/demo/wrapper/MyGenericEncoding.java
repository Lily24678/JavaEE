package com.lsy.code.demo.wrapper;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyGenericEncoding extends HttpServletRequestWrapper{
	private HttpServletRequest request;
	
	public MyGenericEncoding(HttpServletRequest request) {
		super(request);
		this.request=request;
	}

	@Override
	public String getParameter(String name) {
		String method = request.getMethod();
		if("get".equalsIgnoreCase(method)) {
			String value=null;
			try {
				value=new String(request.getParameter(name).getBytes("ISO-8859-1"), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return value;
		}else if ("post".equalsIgnoreCase(method)) {
			try {
				request.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
			
		return request.getParameter(name);
	}

}
