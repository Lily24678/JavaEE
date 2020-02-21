package com.lsy.code.demo.utils;

public class StringUtils {
	/**
	 * 判断字符串为空
	 * @param str
	 * @return
	 */
	public static Boolean isBlank(String str) {
		if(null==str)return true;
		if(str.trim().length()==0)return true;
		return false;
	}
	
	/**
	 * 判断字符串不为空
	 * @param str
	 * @return
	 */
	public static Boolean isNotBlank(String str) {
		if(null!=str&&str.trim().length()>0)return true;
		return false;
	}
}
