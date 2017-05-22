package com.xmg.pss.web.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xmg.pss.dao.IEmployeeDAO;
import com.xmg.pss.dao.impl.EmployeeDAOImpl;
import com.xmg.pss.domain.Employee;
import com.xmg.pss.page.PageResult;
import com.xmg.pss.query.EmployeeQueryOnject;

public class EmployeeAction extends ActionSupport {
    private static final long serialVersionUID = 1L;

    IEmployeeDAO dao = new EmployeeDAOImpl();
    Employee e = new Employee();
    EmployeeQueryOnject qo = new EmployeeQueryOnject();
    //查询
    @Override
    public String execute() throws Exception {
        // TODO Auto-generated method stub
//        List<Employee> list = dao.list();
//        ActionContext.getContext().put("list", list);
        PageResult result = dao.pageQuery(qo);
        ActionContext.getContext().put("result", result);
        return "list";
    }
    //删除
    public String delete() throws Exception{
        dao.delete(e);
        return SUCCESS;
    }
    //注册（添加）+编辑，由list页面跳转过过来
    public String input() throws Exception{
        e = dao.get(e.getId());
        return INPUT;
    }
    
    //由edit页面跳转过来
    public String saveOrUpdate() throws Exception{
        if (e.getId() == null) {
            dao.save(e);
        } else {
            dao.update(e);
        }
        return SUCCESS;
    }
    
}
