package com._520it.dao.impl;

import java.util.List;

import com._520it.dao.IStudentDAO;
import com._520it.domain.Student;
import com._520it.handler.BeanHandler;
import com._520it.handler.BeanListHandler;
import com._520it.util.JdbcTemplate;

//学生dao接口实现类
public class StudentDAOImpl implements IStudentDAO {

	// ----------------------------------------DQL操作--------------------------------------
	public Student get(Long id) {
		String sql = "SELECT id, name, age FROM t_student WHERE id =  ? ";
		return JdbcTemplate.query(sql, new BeanHandler<Student>(Student.class),
				new Object[] { id });
	}

	// 查询所有
	public List<Student> listAll() {
		String sql = "SELECT id, name, age FROM t_student ";
		return JdbcTemplate.query(sql, new BeanListHandler<Student>(
				Student.class));
	}

	public void save(Student student) {
		String sql = "INSERT INTO t_student(name, age) VALUES(?, ?)";
		Object[] params = { student.getName(), student.getAge() };
		JdbcTemplate.update(sql, params);
	}

	public void delete(Long id) {
		String sql = "DELETE FROM t_student WHERE id = ? ";
		Object[] params = { id };
		JdbcTemplate.update(sql, params);
	}

	public void update(Student student) {
		String sql = "UPDATE t_student SET name = ?, age = ? WHERE id = ? ";
		Object[] params = { student.getName(), student.getAge(),
				student.getId() };
		JdbcTemplate.update(sql, params);
	}

	@Override
	public void saveOrUpdate(Student student) {
		if (student.getId() != null) {
			this.save(student);
		} else {
			this.update(student);
		}
	}
}
