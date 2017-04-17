//需求：验证成员变量在定义时需要注意的地方
//定义一个类，名叫Variable
class Variable 
{
	//成员变量,也叫字段(Field)，是直接定义在类的{}中的变量(方法外)
	static int age = 84;
	//定义一个主方法
	public static void main(String[] args) 
	{
		//成员变量定义在类文件中，方法外，可以在方法内被调用
		System.out.println(age);
		//定义一个局部变量number，该变量的作用域在主方法内部
		long number = 360;
		//在方法内输出局部变量
		System.out.println(number);
		//在同一个方法内部，两个变量名不能重复，即使这两个变量属于不同类型，仍不能重名
		int num = 360;
		System.out.println(num);
	}
}
/*
小结：永远注意一个变量的作用域范围。区分成员变量和局部变量。
在同一个方法内部，两个变量名不能重复，即使这两个变量属于不同类型，仍不能重名。
*/