package com.lsy.code.domain;

import java.util.Date;

/**
 * create table `store_v1.0`.bg_user
 * (
 * bguid    varchar(32) not null comment '主键'
 * primary key,
 * username varchar(20) not null comment '登陆名',
 * password varchar(20) not null comment '密码',
 * state    tinyint(1)  not null comment '是否禁用：1是0否',
 * isdel    tinyint(1)  not null comment '是否删除：1是0否',
 * updatetime datetime    not null
 * )
 * comment '后台管理用户';
 */
public class Bguser{
    private String bguid;//'主键
    private String username;//登陆名
    private String password;//密码
    private Integer state;//是否禁用：1是0否
    private Integer isdel;//是否删除：1是0否
    private Date updatetime;

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getBguid() {
        return bguid;
    }

    public void setBguid(String bguid) {
        this.bguid = bguid;
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }
}
