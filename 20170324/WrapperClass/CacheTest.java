//需求：通过比较两个数的大小，记住包装类中设计有享元模式
//创建类，CacheTest
public class CacheTest {
	//创建主方法
	public static void main(String[] args) {
		//通过三种方式创建包装类的对象,并比较他们大小
		//方法一：新建包装类的对象
		Integer num01 = new Integer(60);
		Integer num02 = new Integer(60);
		//创建新对象，引用两个不同的内存地址，==在比较引用类型时比较内存地址
		System.out.println(num01 == num02);
		//方法二：调用包装类中的方法
		Integer num03 = Integer.valueOf(30);
		Integer num04 = Integer.valueOf(30);
		//输出true，因为输入的数据在Integer的缓存区[-128，127]里,直接获得数据
		System.out.println(num03 == num04);
		//方法三：自动装箱
		Integer num05 = 15;
		Integer num06 = 15;
		//此情况的底层为方法二的手动实现
		System.out.println(num05 == num06);
		System.out.println("----------------");
		//换一个超出缓存区的数字
		Integer num07 = Integer.valueOf(300);
		Integer num08 = Integer.valueOf(300);
		//输出false，因为输入的数据超出Integer的缓存区，在底层创建两个新对象
		//而==在比较引用类型时比较内存地址，所以不同
		System.out.println(num07 == num08);
		System.out.println("----------------");
		//所以要想比较两个引用类型的内容，用equals方法
		System.out.println(num07.equals(num08));
		System.out.println(num03.equals(num04));
	}
}
/*
小结：包装类型对象之间的比较操作:统统使用equals方法来做比较,比较的是包装的数据
*/