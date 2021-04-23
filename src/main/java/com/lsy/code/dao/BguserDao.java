package com.lsy.code.dao;

import com.lsy.code.domain.Bguser;
import com.lsy.code.utils.JDBCUtils;
import com.lsy.code.utils.StringUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class BguserDao {
    /**
     * find Bguser by column of isdel
     * @param isDel <text>是否删除：1是0否</text>
     * @return
     * @throws SQLException
     */
    public List<Bguser> findByIsDel(Integer isDel,Integer startPage,Integer pageSize) throws SQLException {//是否删除：1是0否
        QueryRunner q = new QueryRunner(JDBCUtils.getDataSource());
        List<Bguser> list = q.query("select * from bguser where isdel=? limit ?,?", new BeanListHandler<Bguser>(Bguser.class), isDel,startPage,pageSize);
        return list;
    }

    /**
     * inset into bguser
     * @param bguser
     * @throws SQLException
     */
    public void add(Bguser bguser) throws SQLException {
        QueryRunner q = new QueryRunner(JDBCUtils.getDataSource());
        q.update("insert into bguser value(?,?,?,?,?,?);", StringUtils.createStrByUUID(),bguser.getUsername(),bguser.getPassword(),bguser.getState(),bguser.getIsdel(),bguser.getUpdatetime());
    }

    /**
     * @param isdel  <text>是否删除：1是0否</text>
     * @param bguid <text>primary key</text>
     * @throws SQLException
     */
    public void updateIsdelByBguid(Integer isdel,String bguid) throws SQLException {
        QueryRunner q = new QueryRunner(JDBCUtils.getDataSource());
        q.update("update bguser set isdel=? where bguid=?",isdel,bguid);
    }

    /**
     * update bguser by primary key
     * @param bguser
     * @throws SQLException
     */
    public void update(Bguser bguser) throws SQLException {
        QueryRunner q = new QueryRunner(JDBCUtils.getDataSource());
        q.update("update bguser set username=?,password=?,state=?,updatetime=? where bguid=?",bguser.getUsername(),bguser.getPassword(),bguser.getState(),bguser.getUpdatetime(),bguser.getBguid());
    }

    /**
     * find bguser by primary key
     * @param bguid
     * @return
     * @throws SQLException
     */
    public Bguser findByBguid(String bguid) throws SQLException {
        QueryRunner q = new QueryRunner(JDBCUtils.getDataSource());
        Bguser bguser = q.query("select  * from bguser where bguid=?", new BeanHandler<Bguser>(Bguser.class), bguid);
        return bguser;
    }

    /**
     * find bguser by column of username and column of isdel and column of bguid not
     * @param username
     * @param isdel
     * @param bguid
     * @return
     * @throws SQLException
     */
    public List<Bguser> findByUsernameAndIsdelAndBguidNot(String username,Integer isdel,String bguid) throws SQLException {
        QueryRunner q = new QueryRunner(JDBCUtils.getDataSource());
        List<Bguser> list = q.query("select * from bguser where username=? and isdel=? and bguid<>?", new BeanListHandler<Bguser>(Bguser.class), username,isdel,bguid);
        return list;
    }

    /**
     * find bguser by column of username and column of isdel
     * @param username
     * @param isdel
     * @return
     */
    public List<Bguser> findByUsernameAndIsdel(String username,Integer isdel) throws SQLException {
        QueryRunner q = new QueryRunner(JDBCUtils.getDataSource());
        List<Bguser> list = q.query("select * from bguser where username=? and isdel=?", new BeanListHandler<Bguser>(Bguser.class), username,isdel);
        return list;
    }

    /**
     * statistic count by column of isdel
     * @param isdel
     * @return
     * @throws SQLException
     */
    public Long countByIsdel(Integer isdel) throws SQLException {
        QueryRunner q = new QueryRunner(JDBCUtils.getDataSource());
        Long count = (Long) q.query("select  count(*) from  bguser where isdel=?", new ScalarHandler(),isdel);
        return count;
    }

    /**
     * find bguser by column of username and column of password and isdel=0
     * @param username
     * @param password
     * @return
     * @throws SQLException
     */
    public Bguser findByUsernameAndPassword(String username,String password) throws SQLException {
        QueryRunner q = new QueryRunner(JDBCUtils.getDataSource());
        Bguser bguser = q.query("select * from bguser where username=? and password=? and isdel=0;", new BeanHandler<Bguser>(Bguser.class), username, password);
        return bguser;
    }
}
