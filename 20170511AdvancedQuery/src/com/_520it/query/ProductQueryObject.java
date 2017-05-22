package com._520it.query;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com._520it.utils.StringUtils;


//由于可能有多个参数类，而每个参数类的条件都是不同的，只有通过循环添加WHERE和AND到sql语句里是共同的，把这部分抽取到此类的父类里面

// 把查询方法中的参数都封装到此类，这是参数类
public class ProductQueryObject extends QueryObject{
    public ProductQueryObject() {
    }

    private String name;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private Integer type;
    private String keywords;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
    public String getKeywords() {
        return keywords;
    }
    
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    //调用父类方法，把条件和属性都传入父类中的条件集和属性集
    public void customizedQuery(){
        if (StringUtils.hasLength(name)) {
            // 用模糊查询，LIKE
            // 注意空格在sql语句中也表示一个字符
            super.addQuery(" name LIKE ? ","%" + name + "%");
        }
        if (minPrice != null) {
            // 用模糊查询，LIKE
            // 注意空格在sql语句中也表示一个字符
            super.addQuery(" price >= ? ", minPrice);
        }
        if (maxPrice != null) {
            // 用模糊查询，LIKE
            //conditions.add(" price <= ? ");
            // 注意空格在sql语句中也表示一个字符
            super.addQuery(" price <= ? ", maxPrice);
        }
        if (type != null && type != -1) {
            // 用模糊查询，LIKE
            //conditions.add(" price <= ? ");
            // 注意空格在sql语句中也表示一个字符
            super.addQuery(" type = ? ", type);
        }
        if (StringUtils.hasLength(keywords)) {
            // 用模糊查询，LIKE
            //conditions.add(" price <= ? ");
            // 注意空格在sql语句中也表示一个字符
            super.addQuery(" ( name LIKE ? OR brand LIKE ? )", "%"+keywords+"%","%"+keywords+"%");
        }
    }



}
