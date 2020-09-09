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
    private static final Map<String, OnlineUser> connections = new HashMap<>();
    private static int onlineCount;

    @OnOpen
    public void opOpen(@PathParam("useId") String useId, Session session) {
        logger.info("新连接：{" + session.getId() + "}，目前在线人数是：{" + session.getId() + "}");
        String[] split = useId.split("-");
        String from = split[0];//客户端A
        String to = split[1];//客户端B
        connections.put(to, new OnlineUser(session, from));//与客户端B建立通信
        //登录的时候查看是否有客户端B是否发送信息给客户端A
        OnlineUser onlineUser = connections.get(from);
        if (null!=onlineUser&&to.equals(onlineUser.getUserId())){//说明客户端B已与客户端A建立通信连接
            if (null!=onlineUser&&onlineUser.getOldMessage().size()>0){
                session.getAsyncRemote().sendText(onlineUser.getOldMessage().get(0));
//                session.getAsyncRemote().sendObject(onlineUser.getOldMessage());
//                session.getAsyncRemote().sendObject("jjkkikikk");
            }
        }

    }

    @OnMessage
    public void onMessage(@PathParam("useId") String useId, String message, Session session) throws IOException {
        logger.info("收到用户{" + useId + "}的消息{" + message + "}.");
        String[] split = useId.split("-");
        String from = split[0];//客户端A
        String to = split[1];//客户端B
        OnlineUser onlineUser = connections.get(from);
        if (null!=onlineUser&&to.equals(onlineUser.getUserId())) {//
            onlineUser.getSession().getAsyncRemote().sendText(message);
        }else {//若信息接收者的连接已不存在
            OnlineUser user = connections.get(to);
            user.ssetOldMessage(message);
            connections.put(to,user);
            System.out.println();
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

