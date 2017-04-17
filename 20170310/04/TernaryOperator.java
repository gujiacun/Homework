//需求：操作三元运算符算两个例子。
//声明一个类，叫TernaryOperator
class TernaryOperator 
{
	//声明主方法
	public static void main(String[] args) 
	{
		//例子一：需求:现在给一个小数3.14，需要求出其四舍五入之后的结果，怎么完成该功能？
		//解法一：Math.round()
		System.out.println(Math.round(3.14));
		//解法二：把3.14的小数部分和整数部分分离，用小数部分与0.5比较，大于等于则进1，小于则忽略
		double num = 3.14;
		//强制类型转换，可只保留3.14的整数部分
		int num1= (int)num;
		//把3.14与其整数部分相减，得到其小数部分
		double num2 = num - num1 ;
		//用小数部分与0.5比较，大于等于则进1，小于则忽略
		int result = num2 >= 0.5 ? num1 + 1 : num1;
		System.out.println(result);
		//例子二：需求：判断一个数的是奇数还是偶数？
		//给出一个数来判断
		int num3 = 65;
		//能被2整除的整数是偶数，否则为奇数。
		String answer = num3 / 2 == 0 ? "偶数" : "奇数";
		//输出答案
		System.out.println(answer);
	}
}
/*
小结：X ? Y : Z  ,X为boolean类型表达式，若为true，返回Y，为false，返回Z。Y和Z和赋值符号左边的变量要保持类型一致
语义与if-else if-else 相同。
*/