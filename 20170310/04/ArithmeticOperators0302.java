//需求：总结自增运算符的几种常见情形
//声明一个类，名为ArithmeticOperators0302
class ArithmeticOperators0302 
{
	//声明主方法
	public static void main(String[] args) 
	{
		//声明及初始化i1
		int i1 = 5;
		//注意：变量 ++;和++ 变量;可以独立存在于一行语句中
		i1 ++;
		//打印，此时i1已经增加了1
		System.out.println("i1= " + i1);
		//声明及初始化i2
		int i2 = 5;
		//注意：变量 ++;和++ 变量;可以独立存在于一行语句中
		++ i2;
		//打印，此时i2已经增加了1
		System.out.println("i2= " + i2);
		int i3 = 5;
		//自增前置，++ i3 表示i3变量自身先加1，再把加1后得到的值拿出去运算
		int a = ++ i3;
		//所以i3的值增加了1，a的值为i3增加后的值
		System.out.println("a= " + a);
		System.out.println("i3= " + i3);
		int i4 = 5;
		//自增后置，i4 ++表示i4变量自身先加1，把i4变量加1之前的原始值拿出去运算
		int b = i4 ++;
		//所以i4的值增加了1，b的值为i4增加前的原始值
		System.out.println("b= " + b);
		System.out.println("i4= " + i4);
	}
}
