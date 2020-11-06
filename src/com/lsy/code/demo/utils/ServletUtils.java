package com.lsy.code.demo.utils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletUtils {
	/**
	 *  创建cookie，并将cookie添加到项目里
	 */
	public static void addCookie(String name,String value,ServletRequest servletRequest,ServletResponse servletResponse) {
		HttpServletRequest request=(HttpServletRequest)servletRequest;
		HttpServletResponse response =(HttpServletResponse) servletResponse;
		
		Cookie cookie = new Cookie(name, value);
		
		// 为 Cookie 设置有效期，不会受到浏览器关闭的影响
		cookie.setMaxAge(60*60*24);
		//cookie保存在浏览器内存，关闭移除
		//cookie.setMaxAge(-1);//默认值-1
		
		//设置cookie的有效访问路径
		cookie.setPath(request.getContextPath());//request.getContextPath()->/JavaEE 
		//设置cookie的有效访问路径,只有在当前项目下login.html中才能访问到cookie
		//cookie.setPath("/JavaEE/login.html"); 
		
		response.addCookie(cookie);;
	}
	
	/**
	 * 通过cookie名获取cookie
	 */
	public static Cookie getCookie(String name,ServletRequest servletRequest) {
		HttpServletRequest request=(HttpServletRequest)servletRequest;
		Cookie cookie2=null;
		Cookie[] cookies = request.getCookies(); 
		if (null!=cookies) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(name)) {
					cookie2=cookie;
					break;
				}
			}
		}
		return cookie2;
	}
	
	public static void removeCookie(Cookie cookie,ServletRequest servletRequest,ServletResponse servletResponse) {
		HttpServletRequest request=(HttpServletRequest)servletRequest;
		HttpServletResponse response =(HttpServletResponse) servletResponse;
		if(null!=cookie) {
			cookie.setMaxAge(0);
			cookie.setPath(request.getContextPath());
			response.addCookie(cookie);
		}
	}

}
