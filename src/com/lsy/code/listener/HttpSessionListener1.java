package com.lsy.code.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.logging.Logger;

public class HttpSessionListener1 implements HttpSessionListener {
	private static Logger logger = Logger.getLogger("com.lsy.code.listener.HttpSessionListener1");

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		logger.info("HttpSession域对象 创建：服务器端第一次调用getSession()，");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		logger.info("HttpSession域对象 销毁：非正常关闭服务器(正常关闭session会序列化)。");
		logger.info("HttpSession域对象 销毁：session过期了(默认30分钟)。");
		logger.info("HttpSession域对象 销毁：手动调用session.invalidate()，");
	}

}
