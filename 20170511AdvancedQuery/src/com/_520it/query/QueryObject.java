package com._520it.query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;


//由于可能有多个参数类，而每个参数类的条件都是不同的，只有通过循环添加WHERE和AND到sql语句里是共同的，把这部分抽取到此类的父类里面
//把缺失的条件集合和sql语句补到父类，还有参数集合也是各个参数集都有的，要放在父类里
public class QueryObject {
    // 定义一个集合来存放sql需要的参数
    // 定义一个集合存放sql条件
    List<Object> conditions = new ArrayList<>();
    List<Object> params = new ArrayList<>();
    StringBuilder sql = new StringBuilder(1024);

    public String getCondition() {
        // 定义sql语句(里面装条件)
        StringBuilder sql = new StringBuilder(1024);
        customizedQuery();
        // 如果这些参数有值，拼接sql语句，同时把惨折放进集合里
        // 上面的循环添加可以用第三方包解决，如下
        if (conditions.size() > 0) {
            // 当条件集合有值时，先添加第一个的WHERE
            sql.append("WHERE");
            // 拿条件集合里的条件用AND分割开
            String join = StringUtils.join(conditions, " AND ");
            sql.append(join);
        }
        return sql.toString();
        
    }
    //留给子类实现
    protected void customizedQuery(){};
    
    //由于此时的conditions和params是空的，要在父类建方法让子类调用，让子类传入conditions和params
    public void addQuery(String conditon,Object...param){
        conditions.add(conditon);
        params.addAll(Arrays.asList(param));
    }
    
    public List<Object> getParams(){
        return params;
    }
}
