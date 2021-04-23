package com.lsy.code.dao;

import com.lsy.code.domain.Order;
import com.lsy.code.domain.OrderItem;
import com.lsy.code.domain.Product;
import com.lsy.code.utils.JDBCUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class OrderDao {
    /**
     * find Orders
     *
     * @param pageStart
     * @param pageSize
     * @return
     * @throws SQLException
     */
    public List<Order> find(Integer pageStart, Integer pageSize) throws SQLException {
        QueryRunner q = new QueryRunner(JDBCUtils.getDataSource());
        List<Order> list = q.query("select * from `orders` limit ?,?", new BeanListHandler<>(Order.class), pageStart, pageSize);
        return list;
    }

    /**
     * find Orders by column of uid
     *
     * @param pageStart
     * @param pageSize
     * @param uid
     * @return
     * @throws SQLException
     */
    public List<Order> findByUid(Integer pageStart, Integer pageSize, String uid) throws SQLException {
        QueryRunner q = new QueryRunner(JDBCUtils.getDataSource());
        List<Order> list = q.query("select * from `orders` where uid=? limit ?,?", new BeanListHandler<>(Order.class), uid, pageStart, pageSize);
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
        Long count = (Long) q.query("select count(*) from `orders`", new ScalarHandler());
        return count;
    }

    /**
     * statistics count by column of uid
     *
     * @param uid
     * @return
     * @throws SQLException
     */
    public Long countByUid(String uid) throws SQLException {
        QueryRunner q = new QueryRunner(JDBCUtils.getDataSource());
        Long count = (Long) q.query("select count(*) from `orders` where uid=?", new ScalarHandler(), uid);
        return count;
    }

    /**
     * find Order by colimn of oid
     *
     * @param oid
     * @return
     * @throws SQLException
     */
    public Order findByOid(String oid) throws SQLException {
        QueryRunner q = new QueryRunner(JDBCUtils.getDataSource());
        Order order = q.query("select * from orders where oid=?", new BeanHandler<>(Order.class), oid);
        return order;
    }

    /**
     * find orderitems by oid
     *
     * @param oid
     * @return
     */
    public List<OrderItem> showDetail(String oid) throws SQLException, InvocationTargetException, IllegalAccessException {
        QueryRunner q = new QueryRunner(JDBCUtils.getDataSource());
        List<Map<String, Object>> list = q.query("select * from orderitem o,product p where o.pid=p.pid and o.oid=?;", new MapListHandler(), oid);
        List<OrderItem> orderItemList = new ArrayList<>();
        for (Map<String, Object> map : list
        ) {
            OrderItem orderItem = new OrderItem();
            ConvertUtils.deregister(Date.class);
            BeanUtils.populate(orderItem, map);
            Product product = new Product();
            BeanUtils.populate(product, map);
            orderItem.setProduct(product);
            orderItemList.add(orderItem);
        }
        return orderItemList;
    }

    /**
     * insert into orders
     *
     * @param order
     * @throws SQLException
     */
    public void add(Order order) throws SQLException {
        QueryRunner q = new QueryRunner(JDBCUtils.getDataSource());
        q.update("insert into orders value (?,?,?,?,?,?,?,?);", order.getOid(), order.getOrdertime(), order.getTotal(), order.getState(), order.getAddress(), order.getName(), order.getTelephone(), order.getUser().getUid());
    }

    /**
     * insert into orderitem
     *
     * @param orderItem
     * @throws SQLException
     */
    public void addCartItem(OrderItem orderItem) throws SQLException {
        QueryRunner q = new QueryRunner(JDBCUtils.getDataSource());
        q.update("insert into orderitem value (?,?,?,?,?)", orderItem.getItemid(), orderItem.getSubcount(), orderItem.getSubtotal(), orderItem.getProduct().getPid(), orderItem.getOrder().getOid());
    }

    /**
     * update state by column of oid
     *
     * @param state
     * @param oid
     * @throws SQLException
     */
    public void updateState(Integer state, String oid) throws SQLException {
        QueryRunner q = new QueryRunner(JDBCUtils.getDataSource());
        q.update("update orders set state=? where oid=?", state, oid);
    }
}
