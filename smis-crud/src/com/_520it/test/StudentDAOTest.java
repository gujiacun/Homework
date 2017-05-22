package com._520it.test;

import java.util.List;

import org.junit.Test;

import com._520it.dao.IStudentDAO;
import com._520it.dao.impl.StudentDAOImpl;
import com._520it.domain.Student;

import lombok.Getter;
import lombok.Setter;

public class StudentDAOTest {
	private IStudentDAO studentDAO = new StudentDAOImpl();

	// 需求:添加陆小凤
	@Test
	public void testSave() {
		Student student = new Student();
		student.setName("陆小凤");
		student.setAge(26);
		studentDAO.save(student);
	}

	// 删除id为1的学生
	@Test
	public void testDelete() {
		studentDAO.delete(2L);
	}

	// 修改学生
	@Test
	public void testUpdate() {
		Student student = new Student();
		student.setName("大飞");
		student.setAge(25);
		student.setId(3L);
		studentDAO.update(student);
	}

	// 获取某个学生
	@Test
	public void testGet() {
		Student student = studentDAO.get(11L);
		System.out.println(student);
	}

	// 获取所有学生
	@Test
	public void testListAll() {
		List<Student> students = studentDAO.listAll();

		for (Student student : students) {
			System.out.println(student);
		}
	}

}
