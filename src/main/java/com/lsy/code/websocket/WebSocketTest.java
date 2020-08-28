package com.lsy.code.websocket;


import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.logging.Logger;

@ServerEndpoint("/chart")
@Component
public class WebSocketTest {
    private static final Logger logger = Logger.getLogger("com.lsy.code.websocket.WebSocketTest");
    @OnOpen
    public  void opopen( Session session) {
        logger.info("");
    }
    @OnMessage
    public void onmessage(String message, Session session){
        logger.info("");

    }
    @OnError
    public void onerror(Session session,Throwable throwable){
        logger.info("");
    }
    @OnClose
    public void onclose(Session session,CloseReason reason){
        logger.info("");
        System.out.println(reason.getCloseCode().getCode());
    }

}
