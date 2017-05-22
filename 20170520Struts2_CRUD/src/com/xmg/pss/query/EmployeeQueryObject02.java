package com.xmg.pss.query;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import lombok.Getter;
import lombok.Setter;
@Setter @Getter
public class EmployeeQueryObject02 extends QueryObject02{
//高级查询所有参数
    private String username;
    private String email;
    private Date beginDate;
    private Date endDate;
    @Override
        protected void customizedQuery() {
            if (!StringUtils.isEmpty(username)) {
                super.addQuery(" name LIKE ? ", "%"+username+"%");
            }
            
            if (!StringUtils.isEmpty(email)) {
                super.addQuery(" email LIKE ? ", "%"+email+"%");
            }
            
            if (beginDate != null) {
                super.addQuery(" beginDate >= ? ", beginDate);
            }
            
            if (endDate != null) {
                super.addQuery(" endDate <= ? ", endDate);
            }
            
        }
}
