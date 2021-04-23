package com.lsy.code.domain;

public class CartItem {
    private Product product;//购物项中的商品
    private Integer count;//购物项中加入购物车中的数量
    private Double subPrice;//一种商品的小计,

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getSubPrice() {
        return product.getShop_price()*count;
    }
}
