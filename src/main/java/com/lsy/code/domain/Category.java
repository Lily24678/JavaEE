package com.lsy.code.domain;

import java.io.Serializable;

/**
 * create table `store_v1.0`.category
 * (
 * cid   varchar(32) not null comment '主键'
 * primary key,
 * cname varchar(50) null comment '类目名称'
 * )
 * comment '商品类目表';
 */
public class Category implements Serializable {
    private String cid;//主键
    private String cname;//类目名称

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
