package com.lsy.com.websocket;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@ServerEndpoint("/chart/{useId}")
public class ChartWebSocket {
    private static final Logger logger = Logger.getLogger("com.lsy.com.websocket.ChartWebSocket");
    private static final Map<String, UserInfo> connections = new HashMap<>();
    private static final Map<String, Session> conn = new HashMap<>();
    private static int onlineCount;

    @OnOpen
    public void opOpen(@PathParam("useId") String useId, Session session) {
        logger.info("新连接：{" + session.getId() + "}，目前在线人数是：{" + session.getId() + "}");
        conn.put(useId, session);
        String[] split = useId.split("-");
        String from = split[0];
        String to = split[1];
        connections.put(to, new UserInfo(session, from));
    }

    @OnMessage
    public void onMessage(@PathParam("useId") String useId, String message, Session session) throws IOException {
        logger.info("收到用户{" + useId + "}的消息{" + message + "}.");
        String[] split = useId.split("-");
        String from = split[0];
        String to = split[1];
        UserInfo userInfo = connections.get(from);
        if (null != userInfo && to.equals(userInfo.getUserId())) {
            userInfo.getSession().getBasicRemote().sendText(message);
        }

    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        logger.info("用户id为：{}的连接发送错误");
        throwable.printStackTrace();
    }

    @OnClose
    public void onClose(Session session, CloseReason reason) {
        logger.info("连接：{" + session.getId() + "} 关闭，目前在线人数是" + session.getId() + "");
    }
}

