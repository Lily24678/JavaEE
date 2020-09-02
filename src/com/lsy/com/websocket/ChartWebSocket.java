package com.lsy.com.websocket;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.logging.Logger;

@ServerEndpoint("/chart")
public class ChartWebSocket {
    private static final Logger logger = Logger.getLogger("com.lsy.com.websocket.ChartWebSocket");

    @OnOpen
    public  void opopen( Session session) {
        logger.info("新连接：{}");
    }
    @OnMessage
    public void onmessage(String message, Session session) throws IOException {
        logger.info("收到用户{}的消息{}："+message);
        session.getBasicRemote().sendText("消息已接收");
    }
     @OnError
    public void onerror(Session session,Throwable throwable){
        logger.info("用户id为：{}的连接发送错误");
    }
    @OnClose
    public void onclose(Session session, CloseReason reason){
        logger.info("连接：{} 关闭");
        System.out.println(reason.getCloseCode().getCode());
    }
}
