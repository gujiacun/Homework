package com.xmg.pss.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.xmg.pss.dao.IEmployeeDAO;
import com.xmg.pss.dao.impl.EmployeeDAOImpl;
import com.xmg.pss.domain.Employee;
import com.xmg.pss.page.PageResult;
import com.xmg.pss.query.EmployeeQueryOnject;

public class EmployeeDAOImplTest {
    IEmployeeDAO dao = new EmployeeDAOImpl();
    Employee employee = new Employee();
//  username
//  password
//  email
//  salary
//  hiredate
//  headImg
    @Test
    public void testSave() throws Exception {
        //fail("Not yet implemented");
        employee = new Employee(1L,"hirate","center","keyaki@tokyo",new BigDecimal(10000),new Date(),"yurina");
        
        dao.save(employee);
    }

    @Test
    public void testDelete() throws Exception {
        //fail("Not yet implemented");
        employee.setId(1L);
        dao.delete(employee);
    }

    @Test
    public void testUpdate() throws Exception {
        //fail("Not yet implemented");
        employee.setId(1L);
        employee.setUsername("hirate");
        employee.setPassword("onlyCenter");
        employee.setEmail("keyaki@tokyo");
        employee.setSalary(new BigDecimal(10000));
        employee.setHiredate(new Date());
        employee.setHeadImg("yurina");
        dao.update(employee);
    }

    @Test
    public void testGet() throws Exception {
        //fail("Not yet implemented");
        // /employee.setEmail("AAAAA");
        Employee employee2 = dao.get(3L);
        System.out.println(employee2);
    }

    @Test
    public void testList() throws Exception {
        //fail("Not yet implemented");
        List<Employee> list = dao.list();
        for (Employee employee : list) {
            System.out.println(employee);
        }
        
    }

    
    @Test
    public void testPageQuery() throws Exception {
        EmployeeQueryOnject qo = new EmployeeQueryOnject();
        PageResult pageQuery = dao.pageQuery(qo);
        System.out.println(pageQuery);
    }
    
}
