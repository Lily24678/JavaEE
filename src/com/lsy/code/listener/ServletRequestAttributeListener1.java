package com.lsy.code.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import java.util.logging.Logger;

public class ServletRequestAttributeListener1 implements ServletRequestAttributeListener {
	private static Logger logger = Logger.getLogger("com.lsy.code.listener.ServletRequestAttributeListener1");

	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		logger.info("ServletRequestAttributeListener 监听 ServletRequest域对象的属性变更：添加");
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		logger.info("ServletRequestAttributeListener 监听 ServletRequest域对象的属性变更：删除");
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		logger.info("ServletRequestAttributeListener 监听 ServletRequest域对象的属性变更：替换");
	}

}
