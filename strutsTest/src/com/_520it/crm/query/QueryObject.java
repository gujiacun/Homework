package com._520it.crm.query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import lombok.Getter;
import lombok.Setter;

public abstract class QueryObject {
    // 参数/条件集合
    List<String> conditions = new ArrayList<>();
    @Getter
    List<Object> params = new ArrayList<>();
    
    // 用户穿的分页参数
    @Getter@Setter
    private Integer pageSize=10;
    @Getter@Setter
    private Integer currentPage=1;
    public List<Object> getParams(){
        return params;
    }
    public String getConditions(){
        StringBuilder sb = new StringBuilder(1024);
        customizedQuery();
        if (conditions.size()>0) {
            sb.append(" WHERE ");
            String join = StringUtils.join(conditions, " AND ");
            sb.append(join);
        }
        return sb.toString();
    }
    protected void customizedQuery() {
        // TODO Auto-generated method stub
    }
    public void addQuery(String sql,Object...param){
        conditions.add(sql);
        params.addAll(Arrays.asList(param));
    }
}
