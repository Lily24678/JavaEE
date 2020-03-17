package com.lsy.code.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

public class TestDemo {
	@Test
	public void test1() {
		
		try {
			Connection connection = DBCPUtils.getConnection();
			String sql = "SELECT * FROM GGJ01_A_WASTE_ENTRY_TIME LIMIT ?,?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, 0);//parameterIndex 从1开始
			statement.setLong(2, 1);//parameterIndex 从1开始
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				System.out.println(resultSet.getString("ID")+"\t"+resultSet.getString("STATION_ID")+"\t"+resultSet.getString("LICENSE_NO")+"\t"+resultSet.getString("CREATION_TIME")+"\t"+resultSet.getString("READER_ID"));
			}
			DBCPUtils.release(connection, statement, resultSet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
