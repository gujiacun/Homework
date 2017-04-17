//需求：进行基本数据类型，包装类的对象和String类型的互相转换
//创建类，叫WrapperClassTest
public class WrapperClassTest {
	//创建主方法
	public static void main(String[] args) {
		//基本数据类型转换为包装类的对象
		//方法一：基本数据类型包装类.valueOf(参数)，表示调用包装类中的方法
		Character c = Character.valueOf('B');
		System.out.println(c);
		//方法二：new 基本数据类型包装类(参数)，表示新建一个包装类的对象
		Character c02 = new Character('9');
		System.out.println(c02);

		//包装类的对象转换为基本数据类型
		//格式：对象名.基本数据类型Value();通过对象调用其对应的包装类中的方法
		char i = c.charValue();
		System.out.println(i);

		//基本数据类型转换为String类型
		//方法一：String.valueOf(参数);表示调用String类中的方法
		String str01 = String.valueOf(15);
		System.out.println(str01);
		//方法二：基本数据类型包装类.toString(参数);表示调用包装类中的方法
		String str02 = Integer.toString(365);
		System.out.println(str02);

		//String类型转换为基本数据类型
		//格式：基本数据类型包装类.parse基本数据类型(参数)
		int num = Integer.parseInt("123");
		System.out.println(num);

		//String类型转换为包装类的对象
		//方法一：基本数据类型包装类.valueOf(参数);表示调用包装类中的方法
		int num02 = Integer.valueOf("987");
		System.out.println(num02);
		//错误: 不兼容的类型: String无法转换为char
		//Character ch = Character.valueOf("a");
		//方法二：new 基本数据类型包装类(参数);表示新建一个包装类的对象
		//错误: 不兼容的类型: String无法转换为char
		//Character ch = new Character("a"); 
		Integer num03 = new Integer("3695");
		System.out.println(num03);

		//包装类的对象转换为String类型
		//格式：对象.toString();调用包装类中的方法
		Character charTest = '3';
		//String str03 = charTest.toString();或写成下面的形式
		String str03 = Character.toString(charTest);
		System.out.println(str03);
	}
}
/*
小结：核心是调用方法（包括构造方法），在IDE中可以慢慢查找
*/