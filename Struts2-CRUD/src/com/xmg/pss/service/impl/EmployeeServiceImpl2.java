package com.xmg.pss.service.impl;

import java.util.List;

import com.xmg.pss.dao.IEmployeeDAO;
import com.xmg.pss.dao.impl.EmployeeDAOImpl;
import com.xmg.pss.domain.Employee;
import com.xmg.pss.page.PageResult;
import com.xmg.pss.query.EmployeeQueryObject;
import com.xmg.pss.service.IEmployeeService;
import com.xmg.pss.util.MD5;

public class EmployeeServiceImpl2 implements IEmployeeService {

	private IEmployeeDAO dao = new EmployeeDAOImpl();
	@Override
	public void save(Employee e) throws Exception {
		String password = e.getPassword();
		e.setPassword(MD5.encode(password + "你大爷"));
		dao.save(e);
	}

	@Override
	public void delete(Employee e) throws Exception {
		dao.delete(e);
	}

	@Override
	public void update(Employee e) throws Exception {
		dao.update(e);
	}

	@Override
	public Employee get(Long id) throws Exception {
		return dao.get(id);
	}

	@Override
	public List<Employee> list() throws Exception {
		return dao.list();
	}

	@Override
	public PageResult pageQuery(EmployeeQueryObject qo) throws Exception {
		// TODO Auto-generated method stub
		return dao.pageQuery(qo);
	}

}
