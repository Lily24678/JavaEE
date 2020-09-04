package com.lsy.com.websocket;

import javax.websocket.Session;

public class UserInfo {
    private Session session;
    private String userId;//用户标识

    public UserInfo(Session session, String userId) {
        this.session = session;
        this.userId = userId;
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
}
