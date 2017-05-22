package com.xmg.pss.query;

import java.util.Date;
import com.alibaba.druid.util.StringUtils;
import lombok.Getter;
import lombok.Setter;
@Setter @Getter
public class EmployeeQueryOnject extends QueryObject{
//本例子中，高级查询需要的参数
    private String username;
    private String email;
    private Date beginDate;
    private Date endDate;
    //条件和参数
  //调用父类方法，把条件和属性都传入父类中的条件集和属性集
    public void customizedQuery(){
        if (!StringUtils.isEmpty(username)) {
            super.addQuery(" username LIKE ? ", "%"+username+"%");
        }
        if (!StringUtils.isEmpty(email)) {
            super.addQuery(" email LIKE ? ", "%"+email+"%");
        }
        if (beginDate != null) {
            super.addQuery(" hiredate >= ? ", beginDate);
        }
        if (endDate != null) {
            super.addQuery(" hiredate <= ? ", endDate);
        }
    }
}
