package com.lsy.code.demo.dao;

import com.lsy.code.demo.domain.Product;
import com.lsy.code.demo.utils.DBCPUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ProductDao {
    /**
     * 根据主键查找商品信息
     * @param pid
     * @return
     * @throws SQLException
     */
    public Product findById(String pid) throws SQLException {
        QueryRunner q = new QueryRunner(DBCPUtils.getDataSource());
        Product product = q.query("select  * from product where pid=?",new BeanHandler<>(Product.class), pid);
        return product;
    }

    /**
     * 查找所有商品信息
     * @return
     * @throws SQLException
     */
    public List<Product> findAll() throws SQLException {
        QueryRunner q = new QueryRunner(DBCPUtils.getDataSource());
        List<Product> list = q.query("select  * from product", new BeanListHandler<Product>(Product.class));
        return list;
    }
}
