package com.lsy.code.web.servlet.management;

import com.lsy.code.dao.OrderDao;
import com.lsy.code.dao.UserDao;
import com.lsy.code.domain.BeanPage;
import com.lsy.code.domain.Order;
import com.lsy.code.domain.OrderItem;
import com.lsy.code.domain.User;
import com.lsy.code.utils.BaseServlet;
import com.lsy.code.utils.BeanFactory;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class OrderServlet extends BaseServlet {

    public String listpage(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        Integer currentPage = Integer.parseInt(request.getParameter("currentPage"));//start with 1
        OrderDao orderDao = (OrderDao) BeanFactory.getInstance("orderDao");
        BeanPage<Order> beanPage = new BeanPage<Order>();
        beanPage.setCurrentPage(currentPage);
        int totalCount = orderDao.count().intValue();
        beanPage.setTotalCount(totalCount);
        beanPage.setTotalPage(totalCount % beanPage.getSize() == 0 ? totalCount / beanPage.getSize() : totalCount / beanPage.getSize() + 1);
        beanPage.setList(orderDao.find((currentPage - 1) * beanPage.getSize(), beanPage.getSize()));
        request.setAttribute("beanPage", beanPage);
        request.setAttribute("pageurl", "order");
        return "/admin/order/list.jsp";
    }

    public void showDetail(HttpServletRequest request,HttpServletResponse response) throws IOException, IllegalAccessException, SQLException, InvocationTargetException {
        OrderDao orderDao = (OrderDao) BeanFactory.getInstance("orderDao");
        List<OrderItem> list = orderDao.showDetail(request.getParameter("oid"));
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonValueProcessor() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");

            @Override
            public Object processArrayValue(Object o, JsonConfig jsonConfig) {
                return simpleDateFormat.format(o);
            }

            @Override
            public Object processObjectValue(String s, Object o, JsonConfig jsonConfig) {
                if (o != null) {
                    return simpleDateFormat.format(o);
                } else {
                    return null;
                }
            }
        });
        response.getWriter().println(JSONArray.fromObject(list,jsonConfig));
    }

    public String deliver(HttpServletRequest request,HttpServletResponse response) throws SQLException {
        OrderDao orderDao = (OrderDao) BeanFactory.getInstance("orderDao");
        orderDao.updateState(2,request.getParameter("oid"));
        return "/mg/order?method=listpage&currentPage=1";
    }
}
