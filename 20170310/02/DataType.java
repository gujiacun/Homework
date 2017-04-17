//需求：基本数据类型与引用数据类型的运用
//声明一个类，叫DataType 
class DataType 
{
	//声明一个主方法
	public static void main(String[] args) 
	{
		//定义变量b1，类型为byte，赋值15
		byte b1 = 15;
		//b1 + 10为byte类型数据加上int类型数据，其结果会被自动提升为int类型
		//但b2类型为byte，与表达式的结果发生类型冲突，需要把其中一个的数据类型转换为另一个，保持统一
		byte b2 = (byte)(b1 + 10);
		//打印b2的值
		System.out.println(b2);
		/*
		char的字面量有3种类型：
		一。一个英文字母，字符，数字或汉字（其他语言文字也可以），要用单括号包围
		二。一个数字，但是打印出来的值依然是ASCII码表对于的符号，此时不用单括号包围
		三。表示16进制的数值，格式如'\u0041',要用单括号包围，在u后面跟一个16进制整数
	    */
		//给变量c1赋值a
		char c1 = 'a';
		//打印c1
		System.out.println(c1);
		//给变量c2赋值65，65只是ASCII码表中的数字
		char c2 = 65;
		//打印c2，在ASCII码表中，65对应的字符是A
		System.out.println(c2);
		//使用16进制的数字
		char c3 = '\u0042';
		//打印c3，即'\u0041'对应的字符B
		System.out.println(c3);
		char c4 = 49;
		//打印c4，在ASCII码表中，65对应的字符是1
		System.out.println(c4);
		char c5 = 97;
		//打印c5，在ASCII码表中，97对应的字符是a
		System.out.println(c5);
		//String类型的字面量相加，仍为字符串
		String str = "一緒に過ごした季節よ " + " 後悔はしてないか？";
		//打印字符串
		System.out.println(str);
		//String类型的字面量相加，仍为字符串,但由于括号的存在，根据运算符的优先级，先计算括号内的算术运算，再与前面的字符串连接
		String str2 = "秋冬で去ってゆく " + (8 + 87);
		//打印字符串
		System.out.println(str2);
		//注意运算顺序，下句代码中，先算18 + 89，为算术运算，后与"Hello"这一字符串连接
		System.out.println(18 + 89 + "Hello");
	}
}
/*
小结："+"在只含基本数据类型的表达式中表示加号。但在String的表达式中表连接拼接，
若想进行算术运算，请用括号包围。
*/