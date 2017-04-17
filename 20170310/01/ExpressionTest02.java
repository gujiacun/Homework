//需求：复习表达式的构成。
//声明一个类，名叫Expression02
class ExpressionTest02 
{
	//声明主方法
	public static void main(String[] args) 
	{
		//表达式是由常量、变量、运算符、括号组成的语句
		//一个表达式为三乘于四的三次方，并打印出来。
		System.out.println(3*Math.pow(4, 3));
		//求8乘16的平方根，把结果赋予变量result并打印出来。这里要强制类型转换。
		int result = (int)(8 / Math.sqrt(16));
		//打印结果
		System.out.println(result);
		//Math.sqrt(16)的结果是4.0 ，是小数而不是整数，是double类型。
		double result1 = 8 / Math.sqrt(16);
		System.out.println(result1);
	}
}

