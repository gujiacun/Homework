//需求：操作Object类中的几种方法，记住使用格式
//创建类，叫ObjectTest
class Test{
	int a = 10;
}
public class ObjectTest {
	//创建主方法
	public static void main(String[] args) {
		//创建Test类的对象
		Test t = new Test();
		//使用equals方法，先创建两个String类型变量
		String str1 = "abc";
		String str2 = "abc";
		//在根类（Object）中的equals方法，本身和"=="相同，都是比较对象的内存地址。
		//但在String类中，equals方法已经重写了Object类中的equals方法，已经变为比较对象的内容。格式为str1.equals(str2)
		boolean whether = str1.equals(str2);
		//输出结果
		System.out.println(whether);
		//下面比较Arrays中的toString方法与Object中的toString方法
		//建数组
		int[] arr = {1,2,30};
		//用toString把数组转换为String类型并输出
		String array = java.util.Arrays.toString(arr);
		System.out.println(array);
		//用Object中的toString方法，默认情况下打印对象,打印的是对象的十六进制的hashCode值
		System.out.println(arr.toString());
		System.out.println(t.toString());
		//用hashCode方法，输出对象的哈希值,hashCode值决定了对象在哈希表中的存储位置
		System.out.println(t.hashCode());
		//操作getClass方法，得到对象的真实类型，而不是编译类型
		System.out.println(t.getClass());
	}
}
/*
小结：Obiect类的方法有9种，现在先记住最常用的几个，要注意与其他类的同名方法的使用场景和使用格式做区分。
*/