package com.lsy.code.websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@SpringBootApplication
public class WebsocketApp {
    public static void main(String[] args) {
        SpringApplication.run(WebsocketApp.class,args);
    }
}
