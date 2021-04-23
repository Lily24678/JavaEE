package com.lsy.code.dao;

import com.lsy.code.domain.Category;
import com.lsy.code.domain.Order;
import com.lsy.code.domain.Product;
import com.lsy.code.utils.JDBCUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ProductDao {

    /**
     * find Products
     *
     * @param pageStart
     * @param pageSize
     * @return
     * @throws SQLException
     */
    public List<Product> find(Integer pageStart, Integer pageSize) throws SQLException, InvocationTargetException, IllegalAccessException {
        QueryRunner q = new QueryRunner(JDBCUtils.getDataSource());
        List<Product> list1 = new ArrayList<>();
        List<Map<String, Object>> list = q.query("select  * from  product p,category c where p.cid=c.cid limit ?,?", new MapListHandler(), pageStart, pageSize);
        for (Map<String, Object> map : list
        ) {
            Product product = new Product();
            ConvertUtils.deregister(Date.class);
            BeanUtils.populate(product, map);
            Category category = new Category();
            BeanUtils.populate(category, map);
            product.setCategory(category);
            list1.add(product);
        }
        return list1;
    }

    /**
     * find Products by column of cid
     *
     * @param cid
     * @param pageStart
     * @param pageSize
     * @return
     * @throws SQLException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public List<Product> findByCid(String cid, Integer pageStart, Integer pageSize) throws SQLException, InvocationTargetException, IllegalAccessException {
        QueryRunner q = new QueryRunner(JDBCUtils.getDataSource());
        List<Product> list1 = new ArrayList<>();
        List<Map<String, Object>> list = q.query("select  * from  product p,category c where p.cid=c.cid and p.cid=? limit ?,?", new MapListHandler(), cid, pageStart, pageSize);
        for (Map<String, Object> map : list
        ) {
            Product product = new Product();
            ConvertUtils.deregister(Date.class);
            BeanUtils.populate(product, map);
            Category category = new Category();
            BeanUtils.populate(category, map);
            product.setCategory(category);
            list1.add(product);
        }
        return list1;
    }

    /**
     * statistics count
     *
     * @return
     * @throws SQLException
     */
    public Long count() throws SQLException {
        QueryRunner q = new QueryRunner(JDBCUtils.getDataSource());
        Long count = (Long) q.query("select count(*) from product", new ScalarHandler());
        return count;
    }

    /**
     * statistics count by column of cid
     * @param cid
     * @return
     * @throws SQLException
     */
    public Long countByCid(String cid) throws SQLException {
        QueryRunner q = new QueryRunner(JDBCUtils.getDataSource());
        Long count = (Long) q.query("select count(*) from product where cid=?", new ScalarHandler(),cid);
        return count;
    }

    /**
     * insert into product
     *
     * @param product
     */
    public void add(Product product) throws SQLException {
        QueryRunner q = new QueryRunner(JDBCUtils.getDataSource());
        q.update("insert into product value(?,?,?,?,?,?,?,?,?,?)", product.getPid(), product.getPname(), product.getMarket_price(), product.getShop_price(), product.getPimage(), product.getPdate(), product.getIs_hot(), product.getPdesc(), product.getPflag(), product.getCategory().getCid());
    }

    /**
     * update product by column of pid
     *
     * @param product
     */
    public void update(Product product) throws SQLException {
        QueryRunner q = new QueryRunner(JDBCUtils.getDataSource());
        q.update("update product set pname=?,market_price=?,shop_price=?,pimage=?,pdesc=?,pdate=?,pflag=?,is_hot=?,cid=? where pid=?", product.getPname(), product.getMarket_price(), product.getShop_price(), product.getPimage(), product.getPdesc(), product.getPdate(), product.getPflag(), product.getIs_hot(), product.getCategory().getCid(), product.getPid());
    }

    /**
     * find product by column of pid
     *
     * @param pid
     * @return
     * @throws SQLException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public Product findByPid(String pid) throws SQLException, InvocationTargetException, IllegalAccessException {
        QueryRunner q = new QueryRunner(JDBCUtils.getDataSource());
        Map<String, Object> map = q.query("select * from product p,category c where p.cid=c.cid and p.pid=?", new MapHandler(), pid);
        Product product = new Product();
        ConvertUtils.deregister(Date.class);
        BeanUtils.populate(product, map);
        Category category = new Category();
        BeanUtils.populate(category, map);
        product.setCategory(category);
        return product;
    }

    /**
     * delete product by column of pid
     *
     * @param pid
     * @throws SQLException
     */
    public void delByPid(String pid) throws SQLException {
        QueryRunner q = new QueryRunner(JDBCUtils.getDataSource());
        q.update("delete from product where pid=?", pid);
    }

    /**
     * find product by column of cid
     *
     * @param cid
     * @return
     * @throws SQLException
     */
    public List<Product> findByCid(String cid) throws SQLException {
        QueryRunner q = new QueryRunner(JDBCUtils.getDataSource());
        List<Product> list = q.query("select * from product where cid=?", new BeanListHandler<>(Product.class), cid);
        return list;
    }
}
