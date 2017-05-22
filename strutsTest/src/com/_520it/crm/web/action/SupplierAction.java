package com._520it.crm.web.action;

import com._520it.crm.dao.ISupplierDAO;
import com._520it.crm.dao.impl.SupplierDAOImpl;
import com._520it.crm.domain.Supplier;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.SupplierQueryObject;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import lombok.Getter;

public class SupplierAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    @Getter
    Supplier s = new Supplier();
    ISupplierDAO dao = new SupplierDAOImpl();
    @Getter
    SupplierQueryObject qo = new SupplierQueryObject();

    @Override
    public String execute() throws Exception {
        // TODO Auto-generated method stub
        PageResult result = dao.queryByCondition(qo);
        //System.out.println(result);
        ActionContext.getContext().put("result", result);
        return "list";
    }
    public String delete() throws Exception {
        // TODO Auto-generated method stub
        if (s.getId() != null) {
            dao.delete(s.getId());
        }
        return SUCCESS;
    }
    public String input() throws Exception {
        // TODO Auto-generated method stub
        if (s.getId() != null) {
            s = dao.get(s.getId());
        }
        return INPUT;
    }
    public String saveOrUpdate() throws Exception {
        // TODO Auto-generated method stub
        if (s.getId() != null) {
            dao.update(s);
        } else {
            dao.save(s);
        }
        return SUCCESS;
    }
}
