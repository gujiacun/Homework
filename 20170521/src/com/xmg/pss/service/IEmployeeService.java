package com.xmg.pss.service;

import java.util.List;

import com.xmg.pss.dao.IEmployeeDAO;
import com.xmg.pss.dao.impl.EmployeeDAOImpl;
import com.xmg.pss.domain.Employee;
import com.xmg.pss.page.PageResult;
import com.xmg.pss.query.EmployeeQueryOnject;
import com.xmg.pss.service.impl.EmployeeServiceImpl;

//模拟业务层
//（1）建service包，建IEmployeeService接口，把IEmployeeDAO里面的方法复制过来
//（2）建子包，里面建实现类EmployeeServiceImpl，重写方法，在save方法里把用户密码加密的操作放进去
//（3）在EmployeeAction中用IEmployeeService service = new EmployeeServiceImpl();代替IEmployeeDAO dao = new EmployeeDAOImpl();
//（4）用shift+alt+r，把Action中的dao替换为service
public interface IEmployeeService {
    public void save(Employee employee) throws Exception;

    public void delete(Employee employee) throws Exception;

    public void update(Employee employee) throws Exception;

    public Employee get(Long id) throws Exception;

    public List<Employee> list() throws Exception;
    
    //高级+分页
    public PageResult pageQuery(EmployeeQueryOnject qo) throws Exception;
/**
 * 小结：因为MD5加密这是一项操作，以后把操作放在业务层里
 */
}
