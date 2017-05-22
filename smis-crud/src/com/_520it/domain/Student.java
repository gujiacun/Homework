package com._520it.domain;

import lombok.Getter;
import lombok.Setter;

//domain  学生对象
@Setter
@Getter
public class Student {
	private Long id; // 主键: id
	private String name; // 学生名字
	private Integer age; // 学生年龄

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

	public Student() {
		super();
	}

	public Student(Long id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
