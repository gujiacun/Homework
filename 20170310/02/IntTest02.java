//需求：int类型的字面量可用二/八/十/十六进制的整数，int与char互换
//定义一个类，叫IntTest02
class IntTest02 
{
	//定义一个主方法
	public static void main(String[] args) 
	{
		//字面量为二进制整数：0B或0b开头
		int num1 = 0B1111;
		//打印该二进制数所对应的十进制整数
		System.out.println(num1);
		//字面量为八进制整数：要求以0开头
		int num2 = 077;
		//打印该八进制数所对应的十进制整数
		System.out.println(num2);
		//字面量为十进制整数，直接输入数字即可
		int num3 = 698;
		//定义该十进制数
		System.out.println(num3);
		//字面量为十六进制整数：要求0X或0x开头
		int num4 = 0XAF;
		//打印该十六进制数所对应的十进制整数
		System.out.println(num4);
		//int类型与char类型在赋值时自动转换
		char c = 65;
		//打印65对应的字符
		System.out.println(c);
		//int类型与char类型在赋值时自动转换
		int i = 'B';
		//打印字符B所对应的十进制数字
		System.out.println(i);
		//c为char类型，c + 3为int类型，要强制转换类型
		c = (char)(c + 3);
		//打印变量c所对应的字符
		System.out.println(c);
	}
}
