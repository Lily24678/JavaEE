package com.lsy.code.domain;

import java.util.Date;

/**
 * create table `store_v1.0`.user
 * (
 * uid       varchar(32) not null comment '主键'
 * primary key,
 * username  varchar(20) null comment '用户名',
 * password  varchar(20) null comment '密码',
 * name      varchar(20) null comment '姓名',
 * email     varchar(30) null comment '邮箱',
 * telephone varchar(20) null comment '电话',
 * birthday  date        null comment '出生日期',
 * sex       varchar(10) null comment '性别：男，女',
 * state     int         null comment '0代表没激活，1代表激活',
 * code      varchar(64) null comment '激活码'
 * )
 * comment '用户信息表';
 */
public class User {
    private String uid;//主键'
    private String username;//用户名
    private String password;//密码
    private String name;//姓名
    private String email;//邮箱
    private String telephone;//电话
    private Date birthday;//出生日期
    private String sex;//性别：男，女
    private Integer state;//0代表没激活，1代表激活
    private String code;//激活码
    private String headimg;//用户头像

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
