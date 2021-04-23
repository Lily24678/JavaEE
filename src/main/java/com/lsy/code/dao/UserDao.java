package com.lsy.code.dao;

import com.lsy.code.domain.User;
import com.lsy.code.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDao {
    /**
     * find Users
     *
     * @param startPage
     * @param pageSize
     * @return
     * @throws SQLException
     */
    public List<User> find(Integer startPage, Integer pageSize) throws SQLException {
        QueryRunner q = new QueryRunner(JDBCUtils.getDataSource());
        List<User> list = q.query("select * from user limit ?,?", new BeanListHandler<User>(User.class), startPage, pageSize);
        return list;
    }

    /**
     * statistics count
     *
     * @return
     * @throws SQLException
     */
    public Long count() throws SQLException {
        QueryRunner q = new QueryRunner(JDBCUtils.getDataSource());
        Long count = (Long) q.query("select count(*) from user;", new ScalarHandler());
        return count;
    }

    /**
     * insert into user
     *
     * @param user
     * @throws SQLException
     */
    public void add(User user) throws SQLException {
        QueryRunner q = new QueryRunner(JDBCUtils.getDataSource());
        q.update("INSERT INTO user (uid, username, password, name, email, telephone, birthday, sex, state, code, headimg) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);", user.getUid(), user.getUsername(), user.getPassword(), user.getName(), user.getEmail(), user.getTelephone(), user.getBirthday(), user.getSex(), user.getState(), user.getCode(), user.getHeadimg());
    }

    /**
     * find User by column of username and password
     *
     * @param username
     * @param password
     * @return
     * @throws SQLException
     */
    public User findByUsernameAndPassword(String username, String password) throws SQLException {
        QueryRunner q = new QueryRunner(JDBCUtils.getDataSource());
        User user = q.query("select * from user where username=? and password=?", new BeanHandler<>(User.class), username, password);
        return user;
    }

    /**
     * find User by column of code
     *
     * @param code
     * @return
     * @throws SQLException
     */
    public User findByCode(String code) throws SQLException {
        QueryRunner q = new QueryRunner(JDBCUtils.getDataSource());
        User user = q.query("select * from user where code=?", new BeanHandler<>(User.class), code);
        return user;
    }

    public void updateCodeAndStateByUid(String code, Integer state, String uid) throws SQLException {
        QueryRunner q = new QueryRunner(JDBCUtils.getDataSource());
        q.update("update user set code=?,state =? where uid=?", code, state, uid);
    }
}
