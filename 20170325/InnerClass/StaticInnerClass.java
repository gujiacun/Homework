//需求：操作静态内部类，了解访问它的特点
//创建外部类
class Outter{
	//创建外部类的静态字段
	static int age = 20;
	//创建外部类的实例成员
	String name = "我是赵日天";
	//创建静态内部类，用static修饰
	static class Inner{
		//创建静态内部类的静态字段
		static int age03 = 30;
		//创建静态内部类的实例字段
		int age02 = 40;
		//创建方法test
		public void test(){
			//静态内部类可直接访问外部类的静态成员
			System.out.println(age);
			System.out.println(age02);
			System.out.println(age03);
			//静态内部类访问外部类的实例成员，通过新建外部类的对象访问
			System.out.println(new Outter().name);
		}
	}
}
//创建测试类
public class StaticInnerClass {
	//创建主方法
	public static void main(String[] args) {
		//创建静态内部类的实例
		Outter.Inner in = new Outter.Inner();
		in.test();
		//通过完整类名访问静态内部类的静态字段
		System.out.println(Outter.Inner.age03);
	}
}
/*
小结：创建静态内部类的对象，格式为 外部类名.内部类名 变量名 = new 外部类名.内部类名([参数]);
赋值符号右边为通过外部类名访问
*/