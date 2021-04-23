package com.lsy.code.web.servlet.fore;

import com.lsy.code.dao.ProductDao;
import com.lsy.code.domain.Cart;
import com.lsy.code.domain.CartItem;
import com.lsy.code.utils.BaseServlet;
import com.lsy.code.utils.BeanFactory;
import com.lsy.code.utils.CookieUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class CartServlet extends BaseServlet {

    /**
     * 添加商品到购物车
     */
    public void add(HttpServletRequest request, HttpServletResponse response) throws IllegalAccessException, SQLException, InvocationTargetException {
        ProductDao productDao = (ProductDao) BeanFactory.getInstance("productDao");
        CartItem cartItem = new CartItem();
        cartItem.setProduct(productDao.findByPid(request.getParameter("pid")));
        cartItem.setCount(Integer.parseInt(request.getParameter("quantity")));

        Cart cart = getCart(request, response);
        cart.addCartItem(cartItem);
    }

    /**
     * 清空购物车
     */
    public String clear(HttpServletRequest request, HttpServletResponse response) {
        Cart cart = getCart(request, response);
        cart.clearCart();
        return "/fore/cart?method=cartpage";
    }

    public String cartpage(HttpServletRequest request, HttpServletResponse response) {
        return "/fore/cart.jsp";
    }

    /**
     * 获得购物车
     */
    private Cart getCart(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (null == cart) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

        //解决浏览器关闭，之前的JSESSIONID找不到的问题
        Cookie cookie = CookieUtils.getCookie(request.getCookies(), "JSESSIONID");
        if (null == cookie) cookie = new Cookie("JSESSIONID", session.getId());
        cookie.setMaxAge(24 * 60 * 60 * 1);
        cookie.setPath(request.getContextPath());
        response.addCookie(cookie);
        return cart;
    }
}
