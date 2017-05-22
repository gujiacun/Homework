package com.xmg.pss.query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import lombok.Getter;
import lombok.Setter;
@Setter @Getter
public class QueryObject02 {
//高级查询参数和条件的集合
    List<String> conditions = new ArrayList<>();
    List<Object> params = new ArrayList<>();
    //分页的两个有用户传入的参数
    private Integer currentPage=1;
    private Integer pageSize=3; 
    //返回上两个的方法
    public List<Object> getParams(){
        return params;
    }
    public String getConditions(){
        //拼接字符串
        StringBuilder sb = new StringBuilder(1024);
        customizedQuery();
        if (conditions.size()>0) {
            sb.append(" WHERE ");
            String join = StringUtils.join(conditions, " AND ");
            sb.append(join);
        }
        return sb.toString();
    }
    //与子类有关的方法
    protected void customizedQuery() {
        // TODO Auto-generated method stub
    }
    public void addQuery(String sql,Object...param) {
        conditions.add(sql);
        params.addAll(Arrays.asList(param));
    }
}
