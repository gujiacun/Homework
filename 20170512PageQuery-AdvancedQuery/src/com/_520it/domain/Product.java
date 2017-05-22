package com._520it.domain;

import java.math.BigDecimal;

public class Product {
    public Product() {
    }

    private Long id;
    private String name;
    private BigDecimal price;
    private BigDecimal stockNum;
    // 1：有线鼠标；2：无线鼠标；3：苹果鼠标
    private Integer type;
    private String brand;
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + ", stockNum=" + stockNum + "]";
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
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
