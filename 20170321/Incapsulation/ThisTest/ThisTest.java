//需求：操作this关键字，掌握this的作用，在构造方法中表示当前创建的对象，在方法中表示调用this所在的方法的对象
//解决在同一类中，成员变量和局部变量的二义性
//同类中，实例方法互掉
//构造方法重载的互掉
//创建封装类Person
class Person{
	//创建实例变量,用private修饰
	private int age;
	private String name;
	//由于被private修饰，所以访问只能通过setter/getter
	public int getAge(){
		return age;
	}
	public void setAge(int age){
		//由于实例变量与局部变量重名，与我们需求不符，要用this修饰实例变量
		//this在方法setAge中，表示的是调用此方法的对象,把传入的数据赋值给字段age
		this.age = age;
	}
	//创建一个实例方法
	public void shout(){
		System.out.println("我是美国华莱士，不知道比你们高到哪里去了");
	}
	//在同一类中创建另一个实例方法，再用this调用上一个方法
	public void say(){
		//同类中实例方法间互调,格式：this.方法名(参数列表);
		this.shout();
		System.out.println("我是香港记者，跑得快");
	}
}
//创建封装类People
class People{
	//手写三个重载的构造方法
	//记住要写一个空参数的构造方法
	public People(){
		System.out.println("辣妹子辣");
	}
	//写一个有一个参数的构造方法
	public People(int age){
		//用this语句调用前一个构造方法，注意参数列表一致
		//由于前一个构造方法无参数，所以参数为空
		//构造器重载的互调，this([参数])必须写在构造方法第一行;
		this();
		System.out.println("辣妹子辣辣");
	}
	//写一个有两个参数的构造方法
	public People(int age,String name){
		//用this语句调用前一个构造方法，注意参数列表一致
		//由于前一个构造方法有一个参数，所以参数为空
		//构造器重载的互调，this([参数])必须写在构造方法第一行;
		this(age);
		System.out.println("辣妹子辣辣辣");
	}
}
//创建测试类，叫ThisTest
public class ThisTest {
	//定义主方法
	public static void main(String[] args) {
		//创建对象
		Person p = new Person();
		//为Person类中的字段age输入数据,调用set方法时参数列表要与set方法的参数列表一致
		p.setAge(28);
		//通过对象调用Person类中的方法，输出字段age的数据
		System.out.println(p.getAge());
		//通过对象p调用say方法
		p.say();
		//创建People的对象，但创建对象同时也是调用构造方法，所以这里我们直接传入参数
		People man = new People(28,"为红颜强行闯入春晚直播现场");
		//方式2: new  Xxx(String str):
         Integer i2= new Integer("123");
     //把包装类对象转换为String.
        String  str =  i2.toString();
System.out.println(str);
	}
}
/*
小结：以后整理笔记时注意整理关键字或知识点使用时的格式，把格式死记硬背下来
构造器只能调用一个重载的构造器
*/