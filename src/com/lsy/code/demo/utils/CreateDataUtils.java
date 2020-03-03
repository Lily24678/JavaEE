package com.lsy.code.demo.utils;

import java.util.ArrayList;
import java.util.List;

import com.lsy.code.demo.domain.User;

public class CreateDataUtils {
	private static List<User> list=new ArrayList<User>();
	static {
		list.add(new User("青丘女帝白浅", "123"));
		list.add(new User("青丘帝姬白凤九", "123"));
		list.add(new User("水稻之父袁隆平", "123"));
		list.add(new User("原子弹钱学森", "123"));
		list.add(new User("admin", "123"));
	}
	
	public static List<User> getRegistedUsers() {
		return list;
	}
	
	public static int isExist(String username) {
		int flag = 0;
		for (User user : list) {
			if (user.getUsername().equals(username)) {
				flag=1;
				break;
			}
		}
		return flag;
	}
}
