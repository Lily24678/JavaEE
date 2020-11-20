package com.lsy.code.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet(urlPatterns = {"/servlet1"},loadOnStartup = 1)
public class Servlet1 implements Servlet{
	private static Logger logger = Logger.getLogger("com.lsy.code.servlet.Servlet1");

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		logger.info("Servlet实例 创建：在服务器中配置load-on-startup，让Servlet在服务器启动的时候创建。");
		logger.info("Servlet实例 创建：默认，用户第一次访问Servlet时。");
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		logger.info("任何一次请求服务器都会创建一个新的线程访问Servlet中的service的方法。当前线程名称----"+Thread.currentThread().getName());
		res.setContentType("text/html;charset=UTF-8");//响应字符流乱码
		//res.getWriter().write("<!DOCTYPE html><html><head><title>jsp</title></head><body>jsp</body></html>");//响应一个html页面
		res.getWriter().write("你的请求已由运行在WEB服务器上的 小型 Java程序Servlet处理完成");

	}
	
	@Override
	public void destroy() {
		logger.info("Servlet实例 销毁：当项目从服务器中移除的时候，或者关闭服务器的时候。");
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
