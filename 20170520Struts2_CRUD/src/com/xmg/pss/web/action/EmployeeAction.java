package com.xmg.pss.web.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xmg.pss.dao.IEmployeeDAO;
import com.xmg.pss.dao.impl.EmployeeDAOImpl;
//用框架写前端页面，先实现CRUD
//（1）在web.xml中建filter过滤器，记住写StrutsPrepareAndExecuteFilter的全限定名
//（2）拷贝struts.xml到resources中，删剩根元素和开发者选项
//（3）建web包，建action包和filter包，在action包里建action类（继承ActionSupport），建实体类和dao两个的对象重写execute方法，
//在这方法里用list方法，把数据加到值栈中,返回list，在struts.xml中配置相应的result
import com.xmg.pss.domain.Employee;
import com.xmg.pss.page.PageResult;
import com.xmg.pss.page.PageResult02;
import com.xmg.pss.query.EmployeeQueryObject02;
import com.xmg.pss.query.EmployeeQueryOnject;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    Employee e = new Employee();
    IEmployeeDAO dao = new EmployeeDAOImpl();

    // 给高级查询+分页查询用
    EmployeeQueryObject02 qo = new EmployeeQueryObject02();

    @Override
    public String execute() throws Exception {
        // TODO Auto-generated method stub
        // List<Employee> list = dao.list();
        // ActionContext.getContext().put("list", list);
        PageResult02 result = dao.pageQuery(qo);
        ActionContext.getContext().put("result", result);
        return "list";
    }

    // 删除方法
    public String delete() throws Exception {
        if (e.getId() != null) {
            dao.delete(e);
        }
        return SUCCESS;
    }

    public String input() throws Exception {
        if (e.getId() != null) {
            e = dao.get(e.getId());
        }
        return INPUT;
    }

    // 编辑/保存方法
    public String saveOrUpdate() throws Exception {
        if (e.getId() != null) {
            dao.update(e);
        } else {
            dao.save(e);
        }
        return SUCCESS;
    }
}
