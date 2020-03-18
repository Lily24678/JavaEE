package com.lsy.code.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class TestDemo {
	@Test
	public void test2() {
		Date date = new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		System.out.println(sdf.format(date));
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH)+1);
		Date date2 = calendar.getTime();
		System.out.println(sdf.format(date2));

	}
	@Test
	public void test1() {
		
		try {
			Connection connection = C3P0Utils.getConnection();
			String sql = "SELECT * FROM STORE LIMIT ?,?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, 0);//parameterIndex 从1开始
			statement.setLong(2, 1);//parameterIndex 从1开始
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				System.out.println(resultSet.getString("ID")+"\t"+resultSet.getString("STATION_ID")+"\t"+resultSet.getString("LICENSE_NO")+"\t"+resultSet.getString("CREATION_TIME")+"\t"+resultSet.getString("READER_ID"));
			}
			C3P0Utils.release(connection, statement, resultSet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
