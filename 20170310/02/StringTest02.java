//需求：操作String，记住其声明格式，初始化格式，不可变的特点。
//声明一个类StringTest02
class StringTest02 
{
	//声明一个主方法
	public static void main(String[] args) 
	{
		//直接赋值  String 变量名 = "常量";
		String str = "Hello";
		//输出Hello
		System.out.println(str);
		//中间的"+"表连接
		str = str + ",Mike";
		//输出Hello,Mike
		System.out.println(str);
		//在括号里，从左往右运算，先算8 + 7得到15，15再与字符串变量str连接，得到15Hello,Mike
		System.out.println(8 + 7 + str);
		//在括号里，从左往右运算，字符串变量str先后与7和8连接
		System.out.println(str + 7 + 8);
		//在括号里，从左往右运算，7和字符串变量str连接。再和8连接
		System.out.println(7 + str + 8);
	}
}
