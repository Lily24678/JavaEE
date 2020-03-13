package com.lsy.code.udp_tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ReceiveSocket_TCP {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {

		//1. 创建ServerSocket(需要指定端口号)
		ServerSocket serverSocket = new ServerSocket(9998);
		//2. 调用ServerSocket的accept()方法接收一个客户端请求，得到一个Socket
		Socket socket = serverSocket.accept();
		//3. 调用Socket的getInputStream()和getOutputStream()方法获取和客户端相连的IO流
		InputStream is = socket.getInputStream();//输入流可以读取客户端输出流写出的数据
		//数据处理
		byte[] bytes = new byte[1024];
		int read = is.read(bytes);
		System.out.println(new String(bytes, 0, read));
		//4、关闭socket
		socket.close();
	}
}
