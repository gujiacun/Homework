//需求：子类初始化，运用super在子类构造器中,去调用父类构造器

//创建父类
class Father{
	//创建父类无参构造器
	Father(){
		System.out.println("I am your father.");
	}
}
//创建子类,记住一定务必绝对必须要写extends Father，否则super();语句无法执行
class Son extends Father{
	//创建子类无参构造器
	Son(){
		//用super调用父类中的无参构造方法，但要注意，构造方法无需写它的方法名，但普通方法要
		super();
		System.out.println("You are not my father!");
	}
}
//创建测试类，SubClassInitTest
public class SubClassInitTest {
	//创建主方法
	public static void main(String[] args) {
		//调用Son的构造方法
		Son s = new Son();
	}
}
/*
小结：super后跟构造方法，无需写它的方法名，但后面跟普通方法，要写方法名
*/