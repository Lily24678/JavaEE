package com.lsy.code.demo.dao;

import com.lsy.code.demo.domain.HeadImg;
import com.lsy.code.demo.utils.DBCPUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

public class HeadImgDao {

    public int addHeadImg(HeadImg headImg) throws SQLException {
        QueryRunner q = new QueryRunner(DBCPUtils.getDataSource());
        int row = q.update("insert into head_img(hid,uid,url) values(?,?,?)", headImg.getHid(), headImg.getUid(), headImg.getUrl());
        return row;
    }
}
