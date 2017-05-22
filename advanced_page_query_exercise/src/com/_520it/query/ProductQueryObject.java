package com._520it.query;

import java.math.BigDecimal;

import com._520it.utils.StringUtils;

public class ProductQueryObject extends QueryObject{
//高级查询参数，名字，类型，最高价，最低价，关键字
    String name;
    String type;
    String keywords;
    BigDecimal maxPrice;
    BigDecimal minPrice;
    
    public void customizedQuery(){
        if (StringUtils.hasLength(name)) {
            super.addQuery("", name);
        }
    }
    
    
    
    
    
    
    
    
}
