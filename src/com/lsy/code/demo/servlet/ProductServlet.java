package com.lsy.code.demo.servlet;

import com.lsy.code.demo.dao.ProductDao;
import com.lsy.code.demo.domain.Product;
import com.lsy.code.demo.utils.DBCPUtils;
import com.lsy.code.demo.utils.MessageHandler;
import com.lsy.code.demo.utils.ServletUtils;
import com.lsy.code.servlet.BaseServlet;
import com.sun.xml.internal.ws.resources.HandlerMessages;
import net.sf.json.JSONObject;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

/**
 * 商品相关
 */
public class ProductServlet extends BaseServlet {

    /**
     * 添加商品浏览记录
     * @param request
     * @param response
     */
    public void addBrowsingHistory(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String pid = request.getParameter("pid");
        Product product = new ProductDao().findById(pid);
        response.getWriter().print(JSONObject.fromObject(MessageHandler.createMsgSuccess("查询成功",product)).toString());

        //添加商品浏览记录
        Cookie pidHistory = ServletUtils.getCookie("pidHistory", request);
        if (null==pidHistory){//第一次浏览商品
            ServletUtils.addCookie("pidHistory",pid,request,response);
        }else {//不是第一次浏览商品
            List<String> pidList =  new ArrayList<>(Arrays.asList(pidHistory.getValue().split("-")));
            if (pidList.contains(pid)){//该商品已被浏览过
                pidList.remove(pid);
            }
            pidList.add(0,pid);
            ServletUtils.addCookie("pidHistory",String.join("-", pidList),request,response);
        }
    }

    /**
     * 清空商品浏览记录
     * @param request
     * @param response
     */
    public String removeBrowsingHistory(HttpServletRequest request,HttpServletResponse response){
        ServletUtils.removeCookie(ServletUtils.getCookie("pidHistory",request),request,response);
        return request.getContextPath();
    }

    /**
     * 根据主键查找商品信息
     * @param request
     * @param response
     */
    public void findById(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException {
        String pid = request.getParameter("pid");
        Product product = new ProductDao().findById(pid);
        response.getWriter().print(JSONObject.fromObject(MessageHandler.createMsgSuccess("查询成功",product)).toString());
    }

}
