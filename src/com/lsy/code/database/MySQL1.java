package com.lsy.code.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MySQL1 {
	public static void main(String[] args) throws Exception {

		//1. 	注册驱动。告知JVM使用的是哪一个数据库的驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2. 	获得连接。使用JDBC中的类,完成对MySQL数据库的连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
		//3.	获得语句执行平台：通过连接对象获取对SQL语句的执行者对象
		PreparedStatement statement = conn.prepareStatement("");
		//4.	执行sql语句。使用执行者对象,向数据库执行SQL语句，获取到数据库的执行后的结果
		//5.	处理结果。
		//6.	释放资源。释放与操作数据库相关的资源 一堆close()


	}

}
