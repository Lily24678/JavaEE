package com.lsy.code.demo.dao;

import com.lsy.code.demo.domain.Product;
import com.lsy.code.demo.utils.DBCPUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class ProductDao {
    /**
     * 根据主键查找商品信息
     * @param pid
     * @return
     * @throws SQLException
     */
    public Product findById(String pid) throws SQLException {
        QueryRunner q = new QueryRunner(DBCPUtils.getDataSource());
        Product product = q.query("select  * from product where pid=?",new BeanHandler<Product>(Product.class), pid);
        return product;
    }

}
