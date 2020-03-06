package com.lsy.code.demo.utils;

public class MessageHandler {
	@SuppressWarnings("rawtypes")
	public static BaseMessage<?> createMsgSuccess(String msg) {
		return new BaseMessage(CodeEnum.status_200.getCode(), msg);
	}

	@SuppressWarnings("rawtypes")
	public static BaseMessage<?> createMsgSuccess(String msg, Object data) {
		return new BaseMessage(CodeEnum.status_200.getCode(), msg, data);
	}

	@SuppressWarnings("rawtypes")
	public static BaseMessage<?> createMsgFailure(String msg) {
		return new BaseMessage(CodeEnum.status_400.getCode(), msg);
	}

	@SuppressWarnings("rawtypes")
	public static BaseMessage<?> createMsgFailure(String msg, Object data) {
		return new BaseMessage(CodeEnum.status_400.getCode(), msg, data);
	}
}
