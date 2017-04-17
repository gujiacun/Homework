//需求：用方法构建递归算法
//定义一个类，叫RecursionTest
class RecursionTest {
	//定义主方法
	public static void main(String[] args) {
		//调用recursion方法，并输入值，同时接受返回结果
		int result = RecursionTest.recursion(10);
		System.out.println(result);
	}
	/*定义一个方法，叫recursion，用于展示斐波那契数列
	由于方法定义在类里，用static修饰，此处要返回一个int类型的值，也要接受一个int类型的值
	*/
	static int recursion(int x){
		//判断输入的值是什么情况，根据情况做选择
		switch (x)
		{
		//假如x等于0，输出0
		case 0:
			return 0;
		//假如x等于1，输出1
		case 1:
			return 1;
		//以上两条不符合，执行此项
		default :
			//由于递归算法涉及自身调用自身，所以要用调用方法的格式
			return recursion(x - 1) + recursion(x - 2);
		}
	}
}
/*
小结：递归算法中，自身调用自身，高阶调用低阶，构造无限的计算步骤。但递归基础会直接给出直接的值
同时注意自身调用自身的格式为：方法名(变量名)，中间不加点
*/