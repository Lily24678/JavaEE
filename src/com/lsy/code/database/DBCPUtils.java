package com.lsy.code.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

/**
 * 连接池：DBCP
 */
public class DBCPUtils {
	private static DataSource dataSource;
	static {
		Properties properties = new Properties();
		try {
			properties.load(DBCPUtils.class.getClassLoader().getResourceAsStream("database.properties"));
			dataSource = BasicDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	/**
	 * @return 获取java.sql.Connection;
	 */
	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * 释放与数据库相关资源
	 * 
	 * @param connection {@link}java.sql.Connection;
	 * @param statement  {@link}java.sql.ResultSet;
	 * @param resultSet  {@link}java.sql.Statement;
	 */
	public static void release(Connection connection, Statement statement, ResultSet resultSet) {
		if (null != resultSet) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (null != statement) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (null != connection) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
