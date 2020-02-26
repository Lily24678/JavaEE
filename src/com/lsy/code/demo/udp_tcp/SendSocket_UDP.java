package com.lsy.code.demo.udp_tcp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SendSocket_UDP {
	public static void main(String[] args) throws IOException {
		// 创建DatagramSocket, 随机端口号。（发送端的Socket）
		DatagramSocket socket = new DatagramSocket();
		// 2，创建DatagramPacket, 指定传送的数据, 数据的长度, IP地址, 进程的端口号(将数据打包)。
		byte[] buf = "Hello World".getBytes();
		int length = buf.length;
		DatagramPacket packet = new DatagramPacket(buf, length, InetAddress.getByName("127.0.0.1"), 9999);
		// 3，使用DatagramSocket发送DatagramPacket
		socket.send(packet);
		// 4，关闭DatagramSocket
		socket.close();
	}
}
