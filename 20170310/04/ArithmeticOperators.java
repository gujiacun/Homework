//需求：验证几个算术运算符的作用
//声明一个类，叫ArithmeticOperators
class ArithmeticOperators 
{
	//声明主方法
	public static void main(String[] args) 
	{
		//先进行加法操作。输出int类型最大值
		System.out.println(Integer.MAX_VALUE);
		//下行代码输出的结果-2147483639，错误，因为java的整数默认是int类型，现在的最终结果已越界，要进行下列操作，需强制转换为long
		System.out.println(Integer.MAX_VALUE + 10);
		//对(Integer.MAX_VALUE + 10)强制转换后，但下行输出的结果仍为-2147483639，错误
		System.out.println((long)(Integer.MAX_VALUE + 10));
		/*原因为Integer.MAX_VALUE已为最大值，在它上面再加10，(Integer.MAX_VALUE + 10)越界变为负数-2147483639，此时在进行类型转换，仍然为负数
		解决方法：提前把Integer.MAX_VALUE转换为long类型
		*/
		long result = ((long)Integer.MAX_VALUE + 10);
		//输出结果
		System.out.println(result);
		/*进行减法操作
		可以在换行打印语句中输入小数并进行运算
		*/
		System.out.println(10.32 - 2.98);
		//进行乘法操作
		System.out.println(10 * 2);
		//进行除法操作，由于都是整数，输出的商也是整数
		System.out.println(10 / 3);
		//进行除法操作，由于是一个小数除以整数，自动进行类型转换，由int转换为double，结果也是double类型
		System.out.println(10 / 3.0);
		//两个字符串可以进行算术运算
		System.out.println('A' * 'B');
		//字符串可和数字进行算术运算
		System.out.println('A' + 1);
		//进行取余操作，记住" % "符号早键盘5的上方
		System.out.println('A' % 'B');
		//在除法运算中，除数不能为0
	}
}
/*
小结：若要对某数据类型的边界值进行运算操作，请先把该边界值转换类型，在进行运算。
*/