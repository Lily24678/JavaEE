package com.lsy.code.demo.utils;

public enum CodeEnum {
	// 枚举的属性字段正例
	status_200(200, "成功"), status_400(400, "失败");
	
	// final 修饰
	private final Integer code;
	private final String state;

	private CodeEnum(Integer code, String state) {
		this.code = code;
		this.state = state;
	}

	// 没有Setter 方法
	public Integer getCode() {
		return code;
	}

	public String getState() {
		return state;
	}

}
