package com.lsy.com.websocket;

import com.alibaba.fastjson.JSON;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class MessageVOEncoder implements Encoder.Text<Object> {
    @Override
    public String encode(Object onlineUser) throws EncodeException {
        return JSON.toJSONString(onlineUser);
    }

    @Override
    public void init(EndpointConfig endpointConfig) {

    }

    @Override
    public void destroy() {

    }
}
