package com.lsy.code.domain;

import java.util.Date;

/**
 * create table `store_v1.0`.`orders`
 * (
 * oid       varchar(32)    not null comment '主键'
 * primary key,
 * ordertime datetime       not null comment '订单产生的时间',
 * total     decimal(10, 2) not null comment '订单的总计',
 * state     tinyint(1)     not null comment '订单的状态。 0：未付款 1：付款，没发货 2：付款，发货3：收货',
 * address   varchar(255)    null comment '用户的地址',
 * name      varchar(255)    null comment '收货人名',
 * telephone varchar(11)     null comment '用户的电话',
 * uid       varchar(32)    not null comment '订单所属用户'
 * )
 * comment '订单表';
 */
public class Order {
    private String oid;//主键'
    private Date ordertime;//订单产生的时间
    private Double total;//订单的总计
    private Integer state;//订单的状态。 0：未付款 1：付款，没发货 2：付款，发货3：收货
    private String address;//用户的地址
    private String name;//收货人名
    private String telephone;//用户的电话
    private User user;//订单所属用户

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
