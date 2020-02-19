package com.lsy.code.listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Bean1 implements HttpSessionBindingListener {
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("HttpSessionBindingListener 监听HttpSession中的JavaBean的绑定和解除绑定:Bean1与Session绑定了...");
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("HttpSessionBindingListener 监听HttpSession中的JavaBean的绑定和解除绑定:Bean1与Session解除绑定了...");
	}

}
