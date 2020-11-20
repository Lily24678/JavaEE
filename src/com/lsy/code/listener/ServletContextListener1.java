package com.lsy.code.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.logging.Logger;
@WebListener
public class ServletContextListener1 implements ServletContextListener {
	private static Logger logger = Logger.getLogger("com.lsy.code.listener.ServletContextListener1");

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		logger.info("ServletContext域对象 创建：:服务器启动的时候,服务器为每个web项目创建一个单独的ServletContext对象（WEB项目目添加到Tomcat中的时候就开始创建）.");
		//ServletContext作为域对象存储数据
		sce.getServletContext().setAttribute("count",0);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		logger.info("ServletContext域对象  销毁：在服务器关闭或者项目从服务器中移除的时候。");
	}

}
