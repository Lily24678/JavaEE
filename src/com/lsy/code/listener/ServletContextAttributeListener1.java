package com.lsy.code.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class ServletContextAttributeListener1 implements ServletContextAttributeListener {

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		System.out.println("HttpSessionAttributeListener 监听 ServletContext域对象的属性变更：添加");
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		System.out.println("HttpSessionAttributeListener 监听 ServletContext域对象的属性变更：删除");
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		System.out.println("HttpSessionAttributeListener 监听 ServletContext域对象的属性变更：替换");
	}

}
