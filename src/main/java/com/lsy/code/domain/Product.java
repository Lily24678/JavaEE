package com.lsy.code.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * create table `store_v1.0`.product
 * (
 * pid          varchar(32)  not null comment '主键'
 * primary key,
 * pname        varchar(50)  null comment '商品名称',
 * market_price double       null comment '商城价',
 * shop_price   double       null comment '售价',
 * pimage       varchar(200) null comment '商品图片',
 * pdate        date         null comment '更新日期',
 * is_hot       int          null comment '是否热门：1是 0否',
 * pdesc        varchar(255) null comment '商品描述',
 * pflag        int          null comment '是否下架：1是0否',
 * cid          varchar(32)  null comment '商品类目主键'
 * )
 * comment '商品表';
 */
public class Product implements Serializable {
    private String pid;//主键
    private String pname;//商品名称
    private Double market_price;//商城价
    private Double shop_price;//售价
    private String pimage;//商品图片
    private Date pdate;//更新日期
    private Integer is_hot;//是否热门：1是 0否
    private String pdesc;//商品描述
    private Integer pflag;//是否下架：1是0否
    // 一对多的关系在表中是通过外键的方式描述,开发语言是Java面向对象.
    // Hibernate框架：ORM的DAO层框架 .ORM:Object-Relational Mapping  session.save(product);
    private Category category;//商品类目主键

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Double getMarket_price() {
        return market_price;
    }

    public void setMarket_price(Double market_price) {
        this.market_price = market_price;
    }

    public Double getShop_price() {
        return shop_price;
    }

    public void setShop_price(Double shop_price) {
        this.shop_price = shop_price;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }

    public Date getPdate() {
        return pdate;
    }

    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

    public Integer getIs_hot() {
        return is_hot;
    }

    public void setIs_hot(Integer is_hot) {
        this.is_hot = is_hot;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public Integer getPflag() {
        return pflag;
    }

    public void setPflag(Integer pflag) {
        this.pflag = pflag;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
