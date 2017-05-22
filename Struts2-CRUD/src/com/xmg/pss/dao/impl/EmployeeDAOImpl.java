package com.xmg.pss.dao.impl;

import java.sql.ResultSet;
import java.util.Collections;
import java.util.List;

import com.xmg.pss.dao.IEmployeeDAO;
import com.xmg.pss.domain.Employee;
import com.xmg.pss.handler.IResultSetHandler;
import com.xmg.pss.handler.impl.BeanHandler;
import com.xmg.pss.handler.impl.BeanListHandler;
import com.xmg.pss.page.PageResult;
import com.xmg.pss.query.EmployeeQueryObject;
import com.xmg.pss.util.JDBCTemplate;

public class EmployeeDAOImpl implements IEmployeeDAO {

	@Override
	public void save(Employee e) throws Exception {
		String sql = "INSERT INTO table_employee VALUES(?,?,?,?,?,?,?)";
		JDBCTemplate.update(sql, null,e.getUsername(), e.getPassword(),
				e.getEmail(), e.getSalary(), e.getHiredate(), e.getHeadImg());
	}

	@Override
	public void delete(Employee e) throws Exception {
		String sql = "DELETE FROM table_employee WHERE id=?";
		JDBCTemplate.update(sql, e.getId());
	}

	@Override
	public void update(Employee e) throws Exception {
		String sql = "UPDATE table_employee SET username=?,password=?,email=?,salary=?,hiredate=?,headImg=? WHERE id=?";
		JDBCTemplate.update(sql, e.getUsername(), e.getPassword(),
				e.getEmail(), e.getSalary(), e.getHiredate(), e.getHeadImg(),
				e.getId());
	}

	@Override
	public Employee get(Long id) throws Exception {
		String sql = "SELECT * FROM table_employee WHERE id=?";
		//Object[] params = {id};
		return JDBCTemplate.query(sql, new BeanHandler<Employee>(Employee.class), id);
	}

	@Override
	public List<Employee> list() throws Exception {
		String sql = "SELECT * FROM table_employee";
		return JDBCTemplate.query(sql, new BeanListHandler<Employee>(Employee.class));
	}

	@Override
	public PageResult pageQuery(EmployeeQueryObject qo) throws Exception {
		String conditions = qo.getQueryConditions();
		String sql = "SELECT COUNT(*) FROM table_employee" + conditions;
		int totalCount = JDBCTemplate.query(sql, new IResultSetHandler<Long>() {

			@Override
			public Long handler(ResultSet rs) throws Exception {
				if (rs.next()) {
				    return rs.getLong(1);
				}
				return null;
			}
		}, qo.getParameters().toArray()).intValue();
		//如果总记录数为0,返回空的PageResult对象
		if(totalCount==0){
			return new PageResult(Collections.EMPTY_LIST,0,1,qo.getPageSize());
		}
		sql = "SELECT * FROM table_employee" + conditions + " LIMIT ?, ?";
		List<Object> parameters = qo.getParameters();
		parameters.add((qo.getCurrentPage() - 1) * qo.getPageSize());
		parameters.add(qo.getPageSize());
		List<Employee> listData = JDBCTemplate.query(sql, new BeanListHandler<>(Employee.class),
				parameters.toArray());
		return new PageResult(listData, totalCount, qo.getCurrentPage(), qo.getPageSize());
	}
}
