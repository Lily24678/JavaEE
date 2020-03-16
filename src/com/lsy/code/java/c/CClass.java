package com.lsy.code.java.c;

import org.junit.Test;

import com.lsy.code.database.JDBCUtils;

public class CClass {
 @Test
 public void test_class() {
	 Class clazz = JDBCUtils.class;
//	 Class clazz = Object.class;
	 
//	 Object cast = clazz.cast(new String());
	 
	 System.out.println(clazz.desiredAssertionStatus());//???
 }
}
