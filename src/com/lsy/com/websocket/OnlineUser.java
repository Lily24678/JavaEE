package com.lsy.com.websocket;

import javax.websocket.Session;
import java.util.ArrayList;
import java.util.List;

public class OnlineUser {
    private Session session;
    private String userId;//用户标识
    private String socketId;//会话标识
    private List<String> oldMessage = new ArrayList<>();//接收者未在线，未发送成功的信息

    public OnlineUser(Session session, String userId) {
        this.session = session;
        this.userId = userId;
    }

    public OnlineUser(Session session, String userId, String socketId) {
        this.session = session;
        this.userId = userId;
        this.socketId = socketId;
    }



    public String getSocketId() {
        return socketId;
    }

    public void setSocketId(String socketId) {
        this.socketId = socketId;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getOldMessage() {
        return oldMessage;
    }

    public void ssetOldMessage(String message) {
        oldMessage.add(message);
    }
}
