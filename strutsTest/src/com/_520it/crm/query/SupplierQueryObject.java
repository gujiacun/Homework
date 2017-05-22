package com._520it.crm.query;

import java.util.List;

import com._520it.crm.util.StringUtils;

import lombok.Getter;
import lombok.Setter;
@Setter @Getter
public class SupplierQueryObject extends QueryObject {
    //高查参数
    private Integer minCredit;
    private Integer maxCredit;
    private String keyword;
    @Override
    protected void customizedQuery() {
        // TODO Auto-generated method stub
        if (minCredit != null) {
            super.addQuery(" credit >= ?", minCredit);
        }
        if (maxCredit != null) {
            super.addQuery(" credit <= ?", maxCredit);
        }
        if (StringUtils.isHasLength(keyword)) {
            super.addQuery(" (name LIKE ? OR number LIKE ?)", "%"+keyword+"%","%"+keyword+"%");
        }
        
        
        
        
        //super.customizedQuery();
    }
}
