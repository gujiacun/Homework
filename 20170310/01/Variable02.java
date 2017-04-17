//需求：验证成员变量在定义时需要注意的地方
//定义一个类，名叫Variable02
class Variable02 
{
	//全局变量,是直接定义在类的{}中，在方法外
	static int age = 84;
	//定义main主方法
	public static void main(String[] args) 
	{
		//成员变量定义在类文件中，方法外，可以在方法内被调用
		System.out.println(age);
		//定义一个局部变量number，该变量的作用域在主方法内部
		long number = 360;
		//在方法内输出局部变量
		System.out.println(number);
		//注意定义重复问题
		int num = 360;
		System.out.println(num);
	}
}
