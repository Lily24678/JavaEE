package com.lsy.code.demo.servlet;

import com.lsy.code.servlet.BaseServlet;

/**
 * 需要登录校验的页面跳转
 */
@SuppressWarnings("serial")
public class PageServlet extends BaseServlet{

	public String file() {
		return "/demo/file.html";
	}
	
}
