package com.lsy.code.demo.dao;

import com.lsy.code.demo.domain.User;
import com.lsy.code.demo.utils.DBCPUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;

public class UserDao {

    /**
     *
     * @param username
     * @return
     * @throws SQLException
     */
    public String findUsernameByUsername(String username) throws SQLException {
        QueryRunner q = new QueryRunner(DBCPUtils.getDataSource());
        String qusrname = q.query("", new ScalarHandler<String>(), username);
        return qusrname;
    }

    public User findByUsernameAndPassword(String username,String password) throws SQLException {
        QueryRunner q = new QueryRunner(DBCPUtils.getDataSource());
        User user = q.query("SELECT * FROM user WHERE username=? and password=?", new BeanHandler<>(User.class), username, password);
        return user;
    }

    /**
     *
     * @param user
     * @return
     */
    public int  addUser(User user) throws SQLException {
        QueryRunner q = new QueryRunner(DBCPUtils.getDataSource());
        int row = q.update("insert into user(uid,username,password) values(?,?,?)", user.getUid(), user.getUsername(), user.getPassword());
        return row;
    }
}
