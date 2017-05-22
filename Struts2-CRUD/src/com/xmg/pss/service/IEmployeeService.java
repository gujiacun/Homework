package com.xmg.pss.service;

import java.util.List;

import com.xmg.pss.domain.Employee;
import com.xmg.pss.page.PageResult;
import com.xmg.pss.query.EmployeeQueryObject;

public interface IEmployeeService {
	/**
	 * 保存员工信息
	 * @param e 需要保存的员工的对象
	 * @throws Exception 
	 */
	void save(Employee e) throws Exception;

	void delete(Employee e) throws Exception;

	void update(Employee e) throws Exception;

	Employee get(Long id) throws Exception;

	List<Employee> list() throws Exception;

	PageResult pageQuery(EmployeeQueryObject qo) throws Exception;
}
