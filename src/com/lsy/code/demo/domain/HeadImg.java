package com.lsy.code.demo.domain;

import java.io.Serializable;

/**用户头像 */
public class HeadImg{
    private  String hid;//主键
    private  String uid;//关联的注册用户d
    private  String url;//头像的地址

    public HeadImg(String hid, String uid, String url) {
        this.hid = hid;
        this.uid = uid;
        this.url = url;
    }

    public HeadImg() {
    }

    public String getHid() {
        return hid;
    }

    public void setHid(String hid) {
        this.hid = hid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
