package com.xmg.pss.query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class QueryObject {
    //集合，存sql需要的条件
    List<String> conditions = new ArrayList<>();
    //集合，存需要的参数
    List<Object> params = new ArrayList<>();
//分页的两个参数
    private Integer pageSize =3;
    private Integer currentPage=1 ;
    //返回条件的方法
    public String getConditions(){
        conditions.clear();
        params.clear();
        StringBuilder sb = new StringBuilder(1024);
        //方法，让子类重写
        customizedQuery();
        if (conditions.size()>0) {
            sb.append("WHERE");
            String join = StringUtils.join(conditions, "AND");
            sb.append(join);
        }
        return sb.toString();
    }
    protected void customizedQuery() {
      //方法，让子类重写
        
    }
    //返回参数的方法
    public List<Object> getParams(){
        return params;
    }
    //由于此时的conditions和params是空的，要在父类建方法让子类调用，让子类传入conditions和params
    public void addQuery(String sql,Object...param){
        conditions.add(sql);
        params.addAll(Arrays.asList(param));
    }
/**
 * 小结：注意，由于param是数组，只用add方法会把数组直接作为整体加进参数集合中，所以转为list，用addAll
 */
}
