package com.lsy.code.domain;

/**
 * create table `store_v1.0`.orderitem
 * (
 * itemid   varchar(32)    not null comment '订单项的编号'
 * primary key,
 * subcount int            not null comment '一个订单单项的总数',
 * subtotal decimal(10, 2) not null comment ' 一个订单单项的小计',
 * pid      varchar(32)    not null comment '一个商品对应多个订单项，一个订单项对应一个商品',
 * oid      varchar(32)    not null comment '一个订单项属于一个订单'
 * )
 * comment '订单项';
 */
public class OrderItem {
    private String itemid;// 订单项的编号
    private Integer subcount;// 一个订单单项的总数
    private Double subtotal;//一个订单单项的小计
    private Product product;//一个商品对应多个订单项，一个订单项对应一个商品
    private Order order;//一个订单项属于一个订单

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public Integer getSubcount() {
        return subcount;
    }

    public void setSubcount(Integer subcount) {
        this.subcount = subcount;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}