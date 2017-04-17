//需求：操作赋值运算符
//声明一个类，叫AssigningOperator02
class AssigningOperator02 
{
	//声明主方法
	public static void main(String[] args) 
	{
		//赋值符号"="。为维护代码的可读性，建议一行只定义一个变量
		byte b = 6;
		short s = 69;
		int i = 15;
		//注意：java默认整数为int类型，若要声明及定义一个long类型变量，在字面量后加L或l
		long l = 69999999999L;
		//注意：java默认小数为double类型，若要声明及定义一个float类型变量，在字面量后加F或f
		float f = 6.32F;
		double d = 6.3333;
		//char类型字面量可以是一个数字，英文字母，字符或其他语言文字。在初始化时要记得用单引号包围
		char c = 'A';
		//String类型在初始化时要用双引号包围
		String str = "今よりももっと輝いて";
		//操作+=
		short num = 6;
		//下行代码错误，因为num为short类型，num + 3 为int类型，需要进行类型转换
		//num = num + 3;
		//改正后，下行没有错误，因为自带隐式类型转换
		num += 3;
		System.out.println(num);
		//操作除等于/=
		int a1 = 98;
		int a2 = 63;
		//下行代码等价于a1 = a1 / a2
		a1 /= a2;
		System.out.println(a1);
		//操作取余等于/%=
		int a3 = 98;
		//下行代码等价于a3 = a3 / a2 ...35,输出结果为余数35
		a3 %= a2;
		System.out.println(a3);
		//下句中的"-"表示符号，把6取负
		System.out.println(5 * -6);
		//下句中的"+"表示正号
		System.out.println(5 * +6);
	}
}
