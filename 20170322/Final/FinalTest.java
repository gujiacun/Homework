//需求：记住final意思，分别修饰类，方法，静态变量，实例变量，局部变量
//创建类Eunuch，类名被final修饰，无法出现继承
final class Eunuch{
	int age = 23;
}
//尝试创建Eunuch的子类,出现错误: 无法从最终Eunuch进行继承
//class Son extends Eunuch{
//}
//创建父类，用final修饰其方法
class Father{
	//用final修饰，子类无法重写
	public final void tell(){
		System.out.println("Hello World!");
	}
}
//创建子类
class Son extends Father{
	//编译报错，错误: Son中的tell()无法覆盖Father中的tell()
	//public void tell(){
		//System.out.println("Hello World!");
	//}
}
class FinalTest {
	public static void main(String[] args) {
		//用final修饰变量
		final int age = 17;
		//尝试重新为age赋值，错误: 无法为最终变量age分配值
		//age = 18;
		System.out.println("Hello World!");
	}
}
//创建常量类，把在开发中不会改变的常量存储在这个类中
class Constant{
	//定义全局静态常量
	public static final int a = 73;
	//定义构造器，尝试用final修饰,错误: 此处不允许使用修饰符final
	//final Constant(){
	//}
}
/*
小结：构造方法不能使用final修饰，因为构造方法不能被继承，肯定是最终的。
多个修饰符之间是没有先后关系的.
*/