//需求：把代码按照JavaBean规范来编写，同时操作private，getter和setter
//创建封装类，叫Person，存储字段和方法
class Person{
	//必须有一个public修饰的无参构造器
	public Person(){

	}
	//所有的字段必须用private修饰
	private int age;
	//所有的字段都要向外提供一对getter/setter方法
	//get方法格式：public 数据类型 get字段(){
	//					return 字段名;
	//				}
	public int getAge(){
		return age;
	}
	//set方法格式：public void set字段名(数据类型 形参名){
	//					字段名 = 形参名;
	//				}
	public void setAge(int a){
		if(a < 0){
			System.out.println("请重新输入");
		}
		age = a;
	}
	private String name;
	public String getName(){
		return name;
	}
	public void setName(String n){
		name = n;
	}
	//创建方法，把输入的字段age输出
	public void tell() {
        System.out.println("年齡：" + getAge() + " 姓名：" + getName());
    }
}
//创建一个测试类，同时用public修饰类
public class Encapsulation {
	//定义主方法
	public static void main(String[] args) {
		//先创建一个对象
		Person p = new Person();
        // p.age = 30;//无法访问
        // 通过"对象.set字段名(实參)"來设置參数
        p.setAge(30);
		p.setName("香港记者张宝华");
		p.tell();
	}
}
/*
小结：private: 表示私有的, 表示类访问权限. 只能在本类中访问,离开本类之后,就不能直接访问.
记住setter和getter方法，本环节特别薄弱
*/