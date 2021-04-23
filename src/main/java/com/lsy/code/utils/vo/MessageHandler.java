package com.lsy.code.utils.vo;

public class MessageHandler {
    public static BaseMessage<?> createMsgSuccess(String msg) {
        return new BaseMessage(CodeEnum.status_200.getCode(), msg);
    }

    public static BaseMessage<?> createMsgSuccess(String msg, Object data) {
        return new BaseMessage(CodeEnum.status_200.getCode(), msg, data);
    }

    public static BaseMessage<?> createMsgFailure(String msg) {
        return new BaseMessage(CodeEnum.status_400.getCode(), msg);
    }

    public static BaseMessage<?> createMsgFailure(String msg, Object data) {
        return new BaseMessage(CodeEnum.status_400.getCode(), msg, data);
    }
}
