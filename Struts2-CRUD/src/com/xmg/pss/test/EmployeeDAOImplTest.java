package com.xmg.pss.test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.xmg.pss.dao.IEmployeeDAO;
import com.xmg.pss.dao.impl.EmployeeDAOImpl;
import com.xmg.pss.domain.Employee;
import com.xmg.pss.page.PageResult;
import com.xmg.pss.query.EmployeeQueryObject;

public class EmployeeDAOImplTest {

    private IEmployeeDAO dao = new EmployeeDAOImpl();

    @Test
    public void testSave() throws Exception {
        Employee e = new Employee(null, "admin", "1234", "admin@qq.com", new BigDecimal(1000.0), new Date(), null);
        dao.save(e);
    }

    @Test
    public void testDelete() throws Exception {
        Employee e = new Employee();
        e.setId(15L);
        dao.delete(e);
    }

    @Test
    public void testUpdate() throws Exception {
        Employee e = new Employee(16L, "will", "1234", "will@qq.com", new BigDecimal(1000.0), new Date(), null);
        dao.update(e);
    }

    @Test
    public void testGet() throws Exception {
        Employee e = dao.get(1L);
        System.out.println(e);
    }

    @Test
    public void testList() throws Exception {
        List<Employee> list = dao.list();
        for (Employee e : list) {
            System.out.println(e);
        }
    }

    @Test
    public void testPageQuery() throws Exception {
        EmployeeQueryObject qo = new EmployeeQueryObject();
        qo.setUsername("a");
        //
        PageResult result = dao.pageQuery(qo);
        System.out.println(result);
    }

}
