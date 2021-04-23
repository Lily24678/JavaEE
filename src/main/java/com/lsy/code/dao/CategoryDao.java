package com.lsy.code.dao;

import com.lsy.code.domain.Category;
import com.lsy.code.domain.Order;
import com.lsy.code.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class CategoryDao {
    /**
     * find Categorys
     *
     * @param startPage
     * @param pageSize
     * @return
     * @throws SQLException
     */
    public List<Category> find(Integer startPage, Integer pageSize) throws SQLException {
        QueryRunner q = new QueryRunner(JDBCUtils.getDataSource());
        List<Category> list = q.query("select * from category limit ?,?", new BeanListHandler<Category>(Category.class), startPage, pageSize);
        return list;
    }

    /**
     * find Categorys
     * @return
     */
    public List<Category> findAll() throws SQLException {
        QueryRunner q = new QueryRunner(JDBCUtils.getDataSource());
        List<Category> list = q.query("select * from category", new BeanListHandler<Category>(Category.class));
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
        Long count = (Long) q.query("select count(*) from category;", new ScalarHandler());
        return count;
    }

    /**
     * find Category by column of cid
     *
     * @param cid
     * @return
     * @throws SQLException
     */
    public Category findByCid(String cid) throws SQLException {
        QueryRunner q = new QueryRunner(JDBCUtils.getDataSource());
        Category category = q.query("select * from category where cid=?", new BeanHandler<>(Category.class), cid);
        return category;
    }

    /**
     * find Categorys by column of cname
     *
     * @param cname
     * @return
     * @throws SQLException
     */
    public List<Category> findByCname(String cname) throws SQLException {
        QueryRunner q = new QueryRunner(JDBCUtils.getDataSource());
        List<Category> list = q.query("select * from category where cname=?", new BeanListHandler<>(Category.class), cname);
        return list;
    }

    /**
     * find Categorys by column of cname and column of cid not
     *
     * @param cname
     * @param cid
     * @return
     * @throws SQLException
     */
    public List<Category> findByCnameAndCidNOt(String cname, String cid) throws SQLException {
        QueryRunner q = new QueryRunner(JDBCUtils.getDataSource());
        List<Category> list = q.query("select * from category where cname=? and cid<>?", new BeanListHandler<>(Category.class), cname, cid);
        return list;
    }

    /**
     * insert into category
     *
     * @param category
     * @throws SQLException
     */
    public void add(Category category) throws SQLException {
        QueryRunner q = new QueryRunner(JDBCUtils.getDataSource());
        q.update("insert into category value (?,?)", category.getCid(), category.getCname());
    }

    /**
     * update category by column of cid
     *
     * @param category
     * @throws SQLException
     */
    public void update(Category category) throws SQLException {
        QueryRunner q = new QueryRunner(JDBCUtils.getDataSource());
        q.update("update category set cname=? where cid=?", category.getCname(), category.getCid());
    }

    /**
     * @param cid
     * @throws SQLException
     */
    public void delByCid(String cid) throws SQLException {
        QueryRunner q = new QueryRunner(JDBCUtils.getDataSource());
        q.update("delete from category where cid=?",cid);
    }
}
