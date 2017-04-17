//需求：交换两个变量值
//声明一个类，叫SwapVar
class SwapVar {
	//声明主方法
	public static void main(String[] args) {
		//方法一：定义一个新变量。通过它交换两个变量值
		int a = 13;
		int b = 31;
		//定义一个临时变量temp，用于临时存储a的值
		int temp = a;
		//把b的值赋给a
		a = b;
		//把temp的值赋给b
		b = temp;
		//打印交换后的a与b的值
		System.out.println(a);
		System.out.println(b);
		//方法二：使用位运算符^
		int c = 13;
		int d = 31;
		c = c ^ d;
		d = c ^ d;
		c = c ^ d;
		//注意：一个数被同一个数连续异或两次，与它本身相等
		System.out.println(c);
		System.out.println(d);
	}
}
/*
小结：同一个问题往往有几种解决方案，我们有时要选择易读的，有时要选择性能最好的
*/