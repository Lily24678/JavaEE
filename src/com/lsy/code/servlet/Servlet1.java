package com.lsy.code.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Servlet1 implements Servlet{

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("Servlet实例 创建：默认，用户第一次访问Servlet时。");
		System.out.println("Servlet实例 创建：在服务器中配置load-on-startup，让Servlet在服务器启动的时候创建。");
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=UTF-8");//响应字符流乱码
		res.getWriter().write("你的请求已由运行在WEB服务器上的 小型 Java程序Servlet处理完成");
	}
	
	@Override
	public void destroy() {
		System.out.println("Servlet实例 销毁：当项目从服务器中移除的时候，或者关闭服务器的时候。");
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}
}
