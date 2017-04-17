//需求：进行自增，自减运算符的操作
//定义一个类，叫ArithmeticOperators0202
class ArithmeticOperators0202 
{
	//定义一个主方法
	public static void main(String[] args) 
	{
		//自增的前置
		int num1 = 5;
		//自增前置，++ a 表示a变量自身先加1，再把加1后得到的值拿出去运算
		int num2 = ++ num1; 
		//两个变量的值都增加
		System.out.println("num1= " + num1 +",num2= " + num2);
		//自增的后置
		int num3 = 5;
		//自增后置，a ++表示a变量自身先加1，把a变量加1之前的原始值拿出去运算
		int num4 = num3 ++;
		//所以num3的值增加了1，num4的值为num3增加前的原始值
		System.out.println("num3= " + num3 +",num4= " + num4);
		//自减的前置
		int num5 = 5;
		//自减前置，-- a 表示a变量自身先减1，再把减1后得到的值拿出去运算
		int num6 = -- num5; 
		//两个变量的值都减少
		System.out.println("num5= " + num5 +",num6= " + num6);
		//自减的后置
		int num7 = 5;
		//自减后置，a --表示a变量自身先加1，把a变量减1之前的原始值拿出去运算
		int num8 = num7 --;
		//所以num7的值减少了1，num8的值为num7减少前的原始值
		System.out.println("num7= " + num7 +",num8= " + num8);
	}
}
