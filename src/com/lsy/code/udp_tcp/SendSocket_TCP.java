package com.lsy.code.udp_tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class SendSocket_TCP {
	public static void main(String[] args) throws IOException, IOException {
		//1. 创建Socket连接服务端(指定ip地址,端口号)通过ip地址找对应的服务器
		Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9998);
		//2. 调用Socket的getInputStream()和getOutputStream()方法获取和服务端相连的IO流
		OutputStream os = socket.getOutputStream();//输出流可以写出数据到服务端的输入流
		os.write("Hello World".getBytes());
		//3.关闭socket
		socket.close();
	}
}
