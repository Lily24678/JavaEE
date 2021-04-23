package com.lsy.code.web.servlet.fore;

import com.lsy.code.dao.OrderDao;
import com.lsy.code.domain.*;
import com.lsy.code.utils.BaseServlet;
import com.lsy.code.utils.BeanFactory;
import com.lsy.code.utils.StringUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class OrderServlet extends BaseServlet {
    /**
     * 查询所有订单
     */
    public String orderlistpage(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        User user = (User) request.getSession().getAttribute("user");
        Integer currentPage = Integer.parseInt(request.getParameter("currentPage"));//start with 1
        BeanPage<Order> beanPage = new BeanPage<>();
        OrderDao orderDao = (OrderDao) BeanFactory.getInstance("orderDao");
        beanPage.setList(orderDao.findByUid((currentPage-1)*beanPage.getSize(),beanPage.getSize(),user.getUid()));
        beanPage.setCurrentPage(currentPage);
        int totalCount = orderDao.countByUid(user.getUid()).intValue();
        beanPage.setTotalCount(totalCount);
        beanPage.setTotalPage(totalCount % beanPage.getSize() == 0 ? totalCount / beanPage.getSize() : totalCount / beanPage.getSize() + 1);
        request.setAttribute("beanPage",beanPage);
        request.setAttribute("pageurl","order");
        return "/fore/order_list.jsp";
    }

    /**
     * 查找指定的订单详情
     * @param request
     * @param response
     * @return
     */
    public String ordeinforpage(HttpServletRequest request, HttpServletResponse response) throws IllegalAccessException, SQLException, InvocationTargetException {
        OrderDao orderDao = (OrderDao) BeanFactory.getInstance("orderDao");
        List<OrderItem> list = orderDao.showDetail(request.getParameter("oid"));
        Order order = orderDao.findByOid(request.getParameter("oid"));
        request.setAttribute("list",list);
        request.setAttribute("order",order);
        return "/fore/order_info.jsp";
    }

    /**
     * 保存订单到数据库
     */
    public String add(HttpServletRequest request, HttpServletResponse response) throws SQLException, InvocationTargetException, IllegalAccessException {
        User user = (User) request.getSession().getAttribute("user");
        OrderDao orderDao = (OrderDao) BeanFactory.getInstance("orderDao");
        Order order = new Order();
        Map<String, String[]> map = request.getParameterMap();
        BeanUtils.populate(order,map);
        order.setOid(StringUtils.createStrByUUID());
        order.setUser(user);
        order.setState(0);
        order.setOrdertime(new Date());

        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (null==cart||cart.getCartItems().isEmpty())return "/fore/cart?method=cartpage";
        order.setTotal(cart.getTolalPrice());
        orderDao.add(order);
        for (CartItem cartitem:cart.getCartItems().values()
             ) {
            OrderItem orderItem = new OrderItem();
            orderItem.setItemid(StringUtils.createStrByUUID());
            orderItem.setOrder(order);
            orderItem.setProduct(cartitem.getProduct());
            orderItem.setSubcount(cartitem.getCount());
            orderItem.setSubtotal(cartitem.getSubPrice());
            orderDao.addCartItem(orderItem);
        }

        cart.clearCart();
        return "/fore/order?method=ordeinforpage&oid="+order.getOid();
    }
}
