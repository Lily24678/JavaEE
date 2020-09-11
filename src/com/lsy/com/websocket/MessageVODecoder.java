package com.lsy.com.websocket;


import com.alibaba.fastjson.JSON;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class MessageVODecoder implements Decoder.Text<Object> {
    @Override
    public Object decode(String s) throws DecodeException {
        return JSON.parseObject(s, Object.class);
    }

    @Override
    public boolean willDecode(String s) {
        return true;
    }

    @Override
    public void init(EndpointConfig endpointConfig) {

    }

    @Override
    public void destroy() {

    }
}
