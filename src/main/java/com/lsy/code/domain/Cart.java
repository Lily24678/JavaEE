package com.lsy.code.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
    private Map<String, CartItem> cartItems = new LinkedHashMap<>();// 购物车中购物项的集合。一个商品的pid对应一个购物项
    private Double tolalPrice = 0.0;// 购物车中所有购物项中的商品总计

    public Map<String, CartItem> getCartItems() {
        return cartItems;
    }

    public Double getTolalPrice() {
        return tolalPrice;
    }

    /**
     * 添加购物项到购物车
     */
    public void addCartItem(CartItem cartItem) {
        String pid = cartItem.getProduct().getPid();
        if (cartItems.containsKey(pid)) {
            CartItem _cartItem = cartItems.get(pid);
            _cartItem.setCount(_cartItem.getCount() + cartItem.getCount());
        } else {
            cartItems.put(pid, cartItem);
        }
        tolalPrice += cartItem.getSubPrice();
    }

    /**
     * 删除某个购物项
     */
    public void deleteCartItem(String pid) {
        CartItem cartItem = cartItems.remove(pid);
        tolalPrice -= cartItem.getSubPrice();
    }

    /**
     * 清空购物车
     */
    public void clearCart() {
        cartItems.clear();
        tolalPrice = 0d;
    }
}
