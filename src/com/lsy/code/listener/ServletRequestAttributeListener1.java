package com.lsy.code.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

public class ServletRequestAttributeListener1 implements ServletRequestAttributeListener {

	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		System.out.println("ServletRequestAttributeListener 监听 ServletRequest域对象的属性变更：添加");
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		System.out.println("ServletRequestAttributeListener 监听 ServletRequest域对象的属性变更：删除");
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		System.out.println("ServletRequestAttributeListener 监听 ServletRequest域对象的属性变更：替换");
	}

}
