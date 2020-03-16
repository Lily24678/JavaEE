package com.lsy.code.java.c;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Test;

import com.lsy.code.database.JDBCUtils;

public class CPerperties {
	@Test
	public void test_properties() throws Exception {
		InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("database.properties");
		Properties properties = new Properties();
		properties.load(is);
		String url = properties.getProperty("url","defa");
		System.out.println(url);
		properties.list(System.out);
		properties.storeToXML(System.out, "测试");
	}

}
