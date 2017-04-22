package javabeanDemo;
//测试javabean规范的类
public class App {
	public static void main(String[] args) {
		Person p = new Person();
		p.setName("Wonderful");
		p.setAge(20);
		p.setGender("男");
		//调用get方法获取字段的值
		System.out.println(p.getName());
		System.out.println(p.getAge());
		System.out.println(p.getGender());
		//toString方法覆盖
		System.out.println(p);
	}
}
/*
 * 小结:测试符合javabean规范的Person类
 */