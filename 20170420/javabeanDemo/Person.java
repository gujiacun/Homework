package javabeanDemo;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//javabean规范
//@Data
public class Person {
	private String name;
	private int age;
	private String gender;
	public Person() {
	}
	public Person(String name, int age, String gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
		
}
/*
 * 小结:javabean规范是public修饰的的类，所有字段都是必须私有化，提供一个public修饰的无参构造器，
 * 		然后每个字段必须提供一个getter/setter方法
 */