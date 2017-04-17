//需求：在前面的作业中，可以看到重写的作用。若在子类中的某一个方法中,怎样去调用父类被重写的方法？
//创建父类
class Son extends Father{
	//创建子类构造器，字段，方法
	Son(){
	}
	int lossInUfc = 1;
	//子类Son中的shout方法与父类Father中的shout方法签名相同，返回值类型相同，访问权限相同，是重写
	public void shout(){
		//想要访问父类中被重写的方法，要用super.方法名(实参);  实参视情况省略
		super.shout();
		System.out.println("I wanna revenge.");
		//想调用父类被隐藏的字段，用super.字段名
		System.out.println(super.lossInUfc + "是conor 的败绩");
	}
}
//创建子类
class Father{
	//创建父类构造器，字段，方法
	Father(){
	}
	int lossInUfc = 0;
	public void shout(){
		System.out.println("Timing beats speed,accuracy beats power.");
	}
}
//创建测试类，叫SuperTest
public class SuperTest {
	//创建主方法，程序入口
	public static void main(String[] args) {
		//创建对象，调用Son中的成员
		Son s = new Son();
		//输出Son类的字段lossInUfc的值
		System.out.println(s.lossInUfc);
		//调用Son中的shout方法
		s.shout();
		//System.out.println(s.lossInUfc);
	}
}
/*
小结：记住super表示当前对象的父类对象，用于访问被子类重写的父类中的方法，访问被子类隐藏的父类的字段
*/