package com.lsy.code.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import java.util.logging.Logger;

//@WebListener
public class ServletContextAttributeListener1 implements ServletContextAttributeListener {
	private static Logger logger = Logger.getLogger("com.lsy.code.listener.ServletContextAttributeListener1");

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		logger.info("HttpSessionAttributeListener 监听 ServletContext域对象的属性变更：添加");
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		logger.info("HttpSessionAttributeListener 监听 ServletContext域对象的属性变更：删除");
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		logger.info("HttpSessionAttributeListener 监听 ServletContext域对象的属性变更：替换");
	}

}
