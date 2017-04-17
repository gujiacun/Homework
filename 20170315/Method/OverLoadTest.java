//需求：了解方法重载的原因，如何进行方法重载
//定义一个类，叫OverLoadTest
class OverLoadTest {
	//定义主方法
	public static void main(String[] args) {
		//定义两个int类型的变量
		int x = 20;
		int y = 36;
		//调用getIntSum方法，求得x加y的和
		//在主方法中创建一个新变量，接受从getIntSum方法返回的结果
		//方法调用格式：方法所在类名.方法名(参数);
		int result1 = OverLoadTest.getIntSum(x,y);
		//输出结果
		System.out.println(result1);
		double x1 = 20.1;
		double y1 = 36.1;
		//调用getDoubleSum方法，求得x1加y1的和
		//在主方法中创建一个新变量，接受从getDoubleSum方法返回的结果
		//方法调用格式：方法所在类名.方法名(参数);
		double result2 = OverLoadTest.getDoubleSum(x1,y1);
		//输出结果
		System.out.println(result2);
		//调用经过方法重载后的getSum方法
		System.out.println(OverLoadTest.getSum(26,3));
		//此时java会根据输入的参数的类型自动判断该调用哪个方法
		System.out.println(OverLoadTest.getSum(20.5,36.5));
	}
	//先在同一个类中创建两个名称不同的方法，分别实现对两个整数和小数的求和操作
	//创建方法，叫getIntSum，接受两个int类型的值，计算它们的和，返回结果
	static int getIntSum(int a,int b){
		return a + b;
	}
	//创建方法，叫getDoubleSum，接受两个double类型的值，计算它们的和，返回结果
	static double getDoubleSum(double a,double b){
		return a + b;
	}
	//从以上步骤可以看出，两个方法的功能一样，但方法名称不同，运用重载可以避免此问题。
	//方法重载，在同一个类中，方法名相同，参数列表不同
	static int getSum(int a,int b){
		return a + b;
	}
	static double getSum(double a,double b){
		return a + b;
	}
}
/*
小结：重载在方法和构造器中都有应用，方法是为了实现某个功能的代码集合，记住两同一不同
记住在主方法中创建一个新变量，接受从方法返回的结果
*/