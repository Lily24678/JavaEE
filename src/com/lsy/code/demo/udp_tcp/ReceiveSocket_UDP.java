package com.lsy.code.demo.udp_tcp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceiveSocket_UDP {
	public static void main(String[] args) throws IOException {
		//1. 创建DatagramSocket, 指定端口号（接收端）
		DatagramSocket socket = new DatagramSocket(9999);
		//2. 创建DatagramPacket, 指定数组, 长度
		byte[] buf=new byte[1024];
		int length = buf.length;
		DatagramPacket packet = new DatagramPacket(buf, length);
		//3.使用DatagramSocket接收DatagramPacket
		socket.receive(packet);//阻塞
		//4.关闭DatagramSocket
		socket.close();
		//5.从DatagramPacket中获取数据,并解析数据
		byte[] data = packet.getData();
		int length2 = packet.getLength();
		System.out.println(new String(data, 0, length2));
	}
}
