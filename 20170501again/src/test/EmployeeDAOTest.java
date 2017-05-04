package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import dao.IEmployeeDAO;
import dao.impl.EmployeeDAOImpl;
import domain.Employee;

public class EmployeeDAOTest {
    // 1,'jiang','136@136',3500.0
    IEmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @Test
    public void testSave() throws Exception {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("jiang");
        employee.setEmail("136@136");
        employee.setSalary(3500.0);
        employeeDAO.save(employee);
    }

    @Test
    public void testDelete() throws Exception {
        employeeDAO.delete(3L);
    }

    @Test
    public void testUpdate() throws Exception {
        Employee employee = new Employee();
        employee.setId(3);
        employee.setName("jj");
        employee.setEmail("631@631");
        employee.setSalary(9500.0);
        employeeDAO.update(employee);
    }

    @Test
    public void testGet() throws Exception {
        Employee employee = employeeDAO.get(4L);
        System.out.println(employee);
    }

    @Test
    public void testListAll() throws Exception {
        List<Employee> list = employeeDAO.listAll();
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }
}
