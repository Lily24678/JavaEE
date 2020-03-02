package com.lsy.code.demo.utils;

public class BaseMassage<T> {
	private int code;
	private String msg;
	private Object data;

	public BaseMassage(int code, String msg, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public BaseMassage(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public Object getData() {
		return data;
	}

}
