package com.lsy.code.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import java.util.logging.Logger;
@WebListener
public class ServletRequestListener1 implements ServletRequestListener {
	private static Logger logger = Logger.getLogger("com.lsy.code.listener.ServletRequestListener1");

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		logger.info("ServletRequest域对象 创建：客户端向服务器每发送一次请求,服务器就会创建.");
	}
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		logger.info("ServletRequest域对象 销毁：服务器对这次请求作出响应后.");
	}


}
