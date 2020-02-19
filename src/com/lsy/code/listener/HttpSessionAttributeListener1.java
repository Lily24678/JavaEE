package com.lsy.code.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class HttpSessionAttributeListener1 implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		System.out.println("HttpSessionAttributeListener 监听 HttpSession域对象的属性变更：添加");
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		System.out.println("HttpSessionAttributeListener 监听 HttpSession域对象的属性变更：删除");
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		System.out.println("监听 HttpSession域对象的属性变更：替换");
	}

}
