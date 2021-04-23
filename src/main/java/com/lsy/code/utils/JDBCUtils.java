package com.lsy.code.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

/**
 * 配置文件方式  c3p0-config.xml
 */
public class JDBCUtils {
    private static final ComboPooledDataSource cpds = new ComboPooledDataSource();
    public static DataSource getDataSource(){
        return  cpds;
    }
}
