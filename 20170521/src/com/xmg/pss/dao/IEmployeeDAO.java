package com.xmg.pss.dao;

import java.util.List;

import com.xmg.pss.domain.Employee;
import com.xmg.pss.page.PageResult;
import com.xmg.pss.query.EmployeeQueryOnject;

public interface IEmployeeDAO {
    public void save(Employee employee) throws Exception;

    public void delete(Employee employee) throws Exception;

    public void update(Employee employee) throws Exception;

    public Employee get(Long id) throws Exception;

    public List<Employee> list() throws Exception;
    
    //高级+分页
    public PageResult pageQuery(EmployeeQueryOnject qo) throws Exception;
}
