package com.lsy.code.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletContextListener1 implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("ServletContext域对象 创建：在服务器启动的时候 。");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("ServletContext域对象  销毁：在服务器关闭或者项目从服务器中移除的时候。");
	}

}
