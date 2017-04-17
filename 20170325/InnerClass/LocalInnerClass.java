//需求：操作局部内部类
//新建类
class Outter{
	//新建外部类的所有成员
	//int age = 10;
	static String name = "123";
	//新建方法
	public void method(){
		//新建局部变量，部内部类访问的局部变量必须使用final修饰
		//但在java8中底层自动添加final
		int age = 10;
		//新建内部类，经实验不能使用public,private,protected,static修饰
		class Inner{
			//尝试在局部内部类中建静态成员,报错
			//static int age = 20;
			//局部内部类可以直接访问外部类的成员
			void test(){
				System.out.println(age);
				System.out.println(name);
			}
		}
		//局部内部类只能在当前方法中使用,在外部类的方法中创建内部类的对象，调用方法
		new Inner().test();
	}
}
//创建测试类
public class LocalInnerClass {
	//创建主方法
	public static void main(String[] args) {
		//新建内部类的对象,尝试使用其方法，失败，因局部内部类只能在当前方法中使用
		//new Inner().test();
		Outter out = new Outter();
		//创建外部类的对象，调用方法，方法内部会创建局部内部类对象并调用局部内部类的方法
		out.method();
		System.out.println(Math.E);
	}
}
/*
小结：局部内部类和匿名内部类都要创建在一个类内部，一个方法内部
局部内部类只能在当前方法中使用，要通过外部类在方法内部新建内部类的对象，在通过内部类的对象访问里面的方法
*/