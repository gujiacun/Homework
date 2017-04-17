//需求：验证数据类型中的大小类型互相转换
//定义一个类，叫TypeConvert
class TypeConvert 
{
	//定义一个主方法
	public static void main(String[] args) 
	{
		//先从小类型一级一级转换为大类型，取值范围不断扩大
		//127为byte类型最大值，如果字面量比127大，就会发生错误
		byte b = 127;
		//从byte转换为short
		short s = b;
		//从short转换为int
		int i = s;
		//从int转换为long
		long l = i;
		//此时输出的字面量为127，为long类型
		System.out.println(l);
		//由整数类型转换为小数类型
		float f = l;
		//由于变成了小数，输出为127.0
		System.out.println(f);
		//从float转换为double
		double d = f;
		System.out.println(d);
		//现在从大类型强制转换为小类型
		double d1 = 3.1415926;
		//强制类型转换，格式为（转换后的type）转换前的变量名
		float f1 = (float)d1;
		//由于float类型的取值范围和精度都比double类型小，从double转为float时可能会精度丢失
		//输出结果为3.1415925，发生精度丢失
		System.out.println(f1);
		//从float类型转换为long类型，小数部分的位数丢失，只取整数部分
		long tall = (long)f1;
		//输出3.1415925的整数部分3
		System.out.println(tall);
		//输出int类型最大值为2147483647
		System.out.println(Integer.MAX_VALUE);
		//注意：java默认整数类型都是int类型，若需要用一个数比int类型最大值还大，要在它后面加l或L
		double num = 369 + 23.8F + 69.658 + 2147483648L;
		//当一个算术表达式中包含多个基本数据类型时，byte,short,char类型会被自动提升到int，整个表达式的最终结果类型被提升到表达式中最高的类型
		System.out.println(num);
		//int类型与char类型在赋值时可以自动转换
		char c1 = 66;
		//输出66在ASCII表中所对应的字符
		System.out.println(c1);
		int i1 = 'B';
		//输出B在ASCII表中所对应的数字
		System.out.println(i1);
	}
}
/*
小结：在强制类型转换时，注意边界数风险问题。否则会发生溢出。
int类型与char类型在赋值时自动转换。
记住基本数据类型中，取值范围从小到大的顺序：byte，char,short,int,long,float,double
*/