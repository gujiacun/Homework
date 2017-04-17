//需求：操作extend关键字，记住子类的定义格式
//创建父类，Father
class Father{
	//创建父类成员
	public int age = 1;
	String hobbit = "与美国记者谈笑风生，怒斥香港记者";
	protected void tell(){
		System.out.println("很惭愧，只做了一点微小的贡献");
	}
}
public class ExtendsTest {
	//创建主方法
	public static void main(String[] args) {
		//创建son类的对象，并调用其中的方法
		Son s = new Son();
		s.say();
		System.out.println("Hello World!");
	}
}
//创建子类son,格式为[修饰符] class Subclass extends SuperClass{} 
class Son extends Father{
	//由于子类继承了父类的成员（除私有和构造方法外），所以可以进行调用
	protected void say(){
		super.tell();
		System.out.println("续" + age + "秒," + hobbit);
	}	
}
/*
小结：在通过对象调用实例方法时，格式为对象.方法名(实参);实参可情况省略，括号不能省略
*/