package com.lsy.code.demo.utils;

public class MassageHandler {
	@SuppressWarnings("rawtypes")
	public static BaseMassage<?> createMsgSuccess(String msg) {
		return new BaseMassage(CodeEnum.status_200.getCode(), msg);
	}

	@SuppressWarnings("rawtypes")
	public static BaseMassage<?> createMsgSuccess(String msg, Object data) {
		return new BaseMassage(CodeEnum.status_200.getCode(), msg, data);
	}

	@SuppressWarnings("rawtypes")
	public static BaseMassage<?> createMsgFailure(String msg) {
		return new BaseMassage(CodeEnum.status_400.getCode(), msg);
	}

	@SuppressWarnings("rawtypes")
	public static BaseMassage<?> createMsgFailure(String msg, Object data) {
		return new BaseMassage(CodeEnum.status_400.getCode(), msg, data);
	}
}
