package com._520it.query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueryObject {
    //高级查询条件
    List conditions = new ArrayList<>();
    //高级查询参数
    List params = new ArrayList<>();
    
    //分页查询参数,用户传入当前页和页面大小
    private Integer currentPage ;
    private Integer pageSize;
    
    //返回高级查询条件的方法
    public List getConditions(){
        //让子类实现
        customizedQuery();
        return conditions;
    }
    //返回高级查询参数的方法
    
    public List getParams(){
        return params;
    }
    public void customizedQuery(){
    }
    //子类调用，把子类中的高级查询的参数送至两个list集合里
    public void addQuery(String condition,Object...param) {
        conditions.add(condition);
        params.addAll(Arrays.asList(param));
    }
}
