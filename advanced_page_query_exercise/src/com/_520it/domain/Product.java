package com._520it.domain;

import java.math.BigDecimal;

public class Product {
    public Product() {

    }

    
    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + ", stockNum=" + stockNum + "]";
    }


    private Long id;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    private String name;
    private BigDecimal price;
    private BigDecimal stockNum;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public BigDecimal getStockNum() {
        return stockNum;
    }
    public void setStockNum(BigDecimal stockNum) {
        this.stockNum = stockNum;
    }
}
