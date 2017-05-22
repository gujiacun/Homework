package com.xmg.pss.service.impl;

import java.util.List;

import com.xmg.pss.dao.IEmployeeDAO;
import com.xmg.pss.dao.impl.EmployeeDAOImpl;
import com.xmg.pss.domain.Employee;
import com.xmg.pss.factory.BeanFactory;
import com.xmg.pss.page.PageResult;
import com.xmg.pss.query.EmployeeQueryOnject;
import com.xmg.pss.service.IEmployeeService;
import com.xmg.pss.util.MD5;

public class EmployeeServiceImpl implements IEmployeeService {
    public EmployeeServiceImpl(){
        
    }
    // 建dao的对象
    //IEmployeeDAO dao = new EmployeeDAOImpl();
    private IEmployeeDAO dao = BeanFactory.getBean("employee",IEmployeeDAO.class);
    @Override
    public void save(Employee employee) throws Exception {
        // TODO Auto-generated method stub
        // 加密操作,取出用户输入的密码
        String password = employee.getPassword();
        // 用MD5.java里的encode方法加密生成密文，再加入随机字符串
        employee.setPassword(MD5.encode(password) + "随机字符串");
        // System.out.println();
        // 吧上一步结果设置给实体类对象，送进数据库（执行save方法）
        dao.save(employee);
    }

    @Override
    public void delete(Employee employee) throws Exception {
        // TODO Auto-generated method stub
        dao.delete(employee);
    }

    @Override
    public void update(Employee employee) throws Exception {
        // TODO Auto-generated method stub
        dao.update(employee);
    }

    @Override
    public Employee get(Long id) throws Exception {
        // TODO Auto-generated method stub
        return dao.get(id);
    }

    @Override
    public List<Employee> list() throws Exception {
        // TODO Auto-generated method stub
        return dao.list();
    }

    @Override
    public PageResult pageQuery(EmployeeQueryOnject qo) throws Exception {
        // TODO Auto-generated method stub
        return dao.pageQuery(qo);
    }

}
