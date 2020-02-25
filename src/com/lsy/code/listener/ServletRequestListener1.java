package com.lsy.code.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class ServletRequestListener1 implements ServletRequestListener {

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("ServletRequest域对象 创建：客户端向服务器每发送一次请求,服务器就会创建.");
	}
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("ServletRequest域对象 销毁：服务器对这次请求作出响应后.");
	}


}
