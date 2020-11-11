package com.lsy.code.demo.utils;

import java.sql.Connection;
import java.sql.SQLException;
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
	 * 获取javax.sql.DataSource
	 * @return
	 */
	public static DataSource getDataSource() {
		return dataSource;
	}

	/**
	 * @return 获取java.sql.Connection;
	 */
	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);//设置事物手动提交
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * 手动提交并释放资源
	 * @param connection
	 */
	public static void close(Connection connection){
		try {
			connection.commit();
		} catch (SQLException throwables) {
			try {
				connection.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			throwables.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}

	}
}
