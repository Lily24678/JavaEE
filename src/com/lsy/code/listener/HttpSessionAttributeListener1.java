package com.lsy.code.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.logging.Logger;
@WebListener
public class HttpSessionAttributeListener1 implements HttpSessionAttributeListener {
	private static Logger logger = Logger.getLogger("com.lsy.code.listener.HttpSessionAttributeListener1");

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		logger.info("HttpSessionAttributeListener 监听 HttpSession域对象的属性变更：添加");
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		logger.info("HttpSessionAttributeListener 监听 HttpSession域对象的属性变更：删除");
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		logger.info("监听 HttpSession域对象的属性变更：替换");
	}

}
