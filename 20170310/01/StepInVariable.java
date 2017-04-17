//需求：了解什么是变量，为什么要用变量，声明变量及给变量初始化的格式是什么。
//定义一个类，叫StepInVariable
class StepInVariable 
{
	//定义一个主方法
	public static void main(String[] args) 
	{
		//声明变量格式  type variableName;
		int num;
		//给变量赋予初始值  variableName = constant
		num = 16;
		//打印该变量
		System.out.println(num);
		//分别求16，289的平方根。注意：Math.sqrt()的结果为double类型
		//定义所要进行操作的数，字面量可以修改
		//不推荐同时在一行里定义多个变量，因为会影响可读性
		double num1;
		double num2;
		//初始化，输入字面量16
		num1 = 16;
		//初始化，输入字面量289
		num2 = 289;
		//分别定义结果
		double result1 = Math.sqrt(num1);
		double result2 = Math.sqrt(num2);
		//输出16的平方根
		System.out.println(result1);
		//输出289的平方根
		System.out.println(result2);
		//求16的平方根加上289的平方根的和
		System.out.println(result1 + result2);
		//求16的平方根减去289的平方根的差
		System.out.println(result1 - result2);
		//求16的平方根乘以289的平方根的积
		System.out.println(result1 * result2);
		//求16的平方根除以289的平方根的商
		System.out.println(result1 / result2);
		//String作为数据类型时首字母大写，字面量要用双括号包围
		String str = "too young,too simple";
		//打印字符串
		System.out.println(str);
		//char类型变量初始值化时，字面量要用单引号包围
		char alphabet = '欅';
		//打印该字符
		System.out.println(alphabet);
		//boolean的值只有true和false，判断三乘于四的三次方是否大于8乘16的平方根
		boolean whether = 3*Math.pow(4, 3) >= 8 / Math.sqrt(16);
		//输出判断语句
		System.out.println(whether);
	}
}
/*
小结：表白连一定要先声明，再初始化，最后才能进行操作。
char类型和String的字面量要分别用单括号和双括号包围。
Math.sqrt(16)的结果是4.0，是double类型
*/
