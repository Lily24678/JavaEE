package com.lsy.code.demo.domain;

import java.util.Date;

/**
 * 用户表
 */
public class User {

	private String uid;//主键				
	private String username;//用户名		
	private String password;//登录密码		
	private String name;//姓名			
	private String email;//邮件			
	private String telephone;//电话号码	
	private String code;//所在区域行政编码			
	private String sex;//性别				
	private Integer state;//具体地理位置			
	private Date birthday;//生日	


	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", name=" + name + ", email="
				+ email + ", telephone=" + telephone + ", code=" + code + ", sex=" + sex + ", state=" + state
				+ ", birthday=" + birthday + "]";
	}

	
	
}
