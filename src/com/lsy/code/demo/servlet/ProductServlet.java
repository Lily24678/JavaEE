package com.lsy.code.demo.servlet;

import com.lsy.code.demo.dao.ProductDao;
import com.lsy.code.demo.domain.Product;
import com.lsy.code.demo.utils.MessageHandler;
import com.lsy.code.demo.utils.ServletUtils;
import com.lsy.code.servlet.BaseServlet;
import net.sf.json.JSONObject;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

/**
 * 商品相关
 */
public class ProductServlet extends BaseServlet {

    /**
     * 添加商品浏览记录
     * javax.servlet.http.Cookie;
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
     * 将商品添加到购物车
     * javax.servlet.http.HttpSession;
     * @param request
     * @param response
     */
    public void shoppingCart(HttpServletRequest request,HttpServletResponse response){
        String pid = request.getParameter("pid");
        String count = request.getParameter("productCount");
        HttpSession session = request.getSession();
        Map<String,Integer> map_cart = (Map<String, Integer>) session.getAttribute("shoppingCart");

        //未登陆状态
        if (null==map_cart)//购物车没有任何东西
            map_cart=new HashMap<>();
        if (!map_cart.containsKey(pid)){//购物车中没有该商品信息
            map_cart.put(pid,Integer.parseInt(count));
        }else {//购物车有该商品信息
            map_cart.put(pid,map_cart.get(pid)+Integer.parseInt(count));
        }
        session.setAttribute("shoppingCart",map_cart);

        //登陆状态下，用户与商品信息关联
    }

    /**
     * 显示购物车信息
     * @param request
     * @param response
     */
    public void showCart(HttpServletRequest request,HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        Map<String,Integer> map_cart = (Map<String, Integer>) session.getAttribute("shoppingCart");
        response.getWriter().print(JSONObject.fromObject(MessageHandler.createMsgSuccess("查询成功",map_cart)).toString());
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
