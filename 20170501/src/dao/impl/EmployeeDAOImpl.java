package dao.impl;

import java.util.List;

import dao.IEmployeeDAO;
import domain.Employee;
import handler.BeanHandler;
import handler.BeanListHandler;
import util.JdbcTemplate;

public class EmployeeDAOImpl implements IEmployeeDAO{

    @Override
    public void save(Employee employee) {
        // 把sql语句和参数输入并调用JdbcTemplate的方法
        // 建sql语句
        String sql = "INSERT INTO t_employee(id,name,email,salary) VALUES(?,?,?,?)";
        // 建object的数组
        Object[] array = new Object[]{employee.getId(),employee.getName(),employee.getEmail(),employee.getSalary()};
        // 调用JdbcTemplate方法
        JdbcTemplate.update(sql,array);
    }

    @Override
    public void delete(Long id) {
     // 把sql语句和参数输入并调用JdbcTemplate的方法
        // 建sql语句
        String sql = "DELETE FROM t_employee WHERE id=?";
        // 建object的数组
        Object[] array = new Object[]{id};
        // 调用JdbcTemplate方法
        JdbcTemplate.update(sql,array);
        
    }

    @Override
    public void update(Employee employee) {
     // 把sql语句和参数输入并调用JdbcTemplate的方法
        // 建sql语句
        String sql = "UPDATE t_employee SET name=?,email=?,salary=? WHERE id=?";
        // 建object的数组
        Object[] array = new Object[]{employee.getName(),employee.getEmail(),employee.getSalary(),employee.getId()};
        // 调用JdbcTemplate方法
        JdbcTemplate.update(sql,array);
        
    }
    
    @Override
    public Employee get(Long id) {
        // TODO Auto-generated method stub
     // 把sql语句和参数输入并调用JdbcTemplate的方法
        // 建sql语句
        String sql = "SELECT id,name,email,salary FROM t_employee WHERE id=?";
        // 建object的数组
        Object[] array = new Object[]{id};
        // 调用JdbcTemplate方法
        return JdbcTemplate.query(sql,new BeanHandler<Employee>(Employee.class),array);
    }

    @Override
    public List<Employee> listAll() {
     // 把sql语句和参数输入并调用JdbcTemplate的方法
        // 建sql语句
        String sql = "SELECT id,name,email,salary FROM t_employee";
        // 建object的数组
        //Object[] array = new Object[]{id};
        // 调用JdbcTemplate方法
        return JdbcTemplate.query(sql,new BeanListHandler<Employee>(Employee.class));
    }
}
/**
 * 小结：熟记利用JDBC操作数据库的语句，在拼接字符串时小心单引号,空格等符号的缺失 老他妈打错字，在写sql语句，注册驱动，创建连接对象时要小心
 */
 
    


