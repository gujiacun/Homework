package com._520it.dao;

import java.util.List;

import com._520it.domain.Student;

//dao 接口, 操作学生类
public interface IStudentDAO {
	/**
	 * 保存学生
	 * @param student   待保存的学生
	 */
	void save(Student student);
	/**
	 * 删除指定id的学生
	 * @param id   待删除学生id
	 */
	void  delete(Long id);

	/**
	 * 修改指定id的学生信息
	 * @param student  修改的学生最新信息
	 */
	void update(Student student);
	
	/**
	 * 添加获取修改学生数据: 判断依据: 是否有id
	 *  有: update
	 *  无: save
	 * @param student
	 */
	void saveOrUpdate(Student student);
	
	/**
	 * 获取指定id的学生信息
	 * @param id  指定学生ID
	 * @return
	 */
	Student get(Long id);
	/**
	 * 获取所有的学生信息
	 * @return
	 */
	List<Student> listAll();
}
