//需求：操作包装类的装箱，拆箱及其自动化，使用switch语句，包装类的常量和常用方法
//创建类，叫classTest
public class classTest {
	//创建主方法
	public static void main(String[] args) {
		//装箱，即把基本数据类型变量转换为包装类的对象
		byte b = 15;
		Byte num02 = b;
		//也可写为
		Byte num020 = new Byte((byte)15);
		Byte num021 = Byte.valueOf((byte)15);
		System.out.println(num02);
		//拆箱，即把包装类的对象转换为基本数据类型变量
		int num01 = num02.intValue();
		System.out.println(num01);
		//自动装箱和拆箱
		//注意下行代码在数字后要加L或l
		Long num03 = 32L;
		//下行错误，因为自动拆箱只允许把包装类对象直接赋给对应的基本数据类型变量
		//int num04 = num03;
		long num04 = num03;
		Integer num05 = Integer.valueOf(100);
		//swytch支持Byte，Short，Integer，Character四个包装类，因为底层自动拆箱
		switch (num05){
		case 50:
			System.out.println(num05);
			break;
		default :
			System.out.println("what the hell?");
		}
		//输出一些包装类的常量和方法
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Long.SIZE);
		System.out.println(Integer.toBinaryString(20));
		System.out.println(Integer.toHexString(20));
	}
}
/*
小结：包装类的对象，基本数据类型和String类型的转换，实质是调用类中的方法
*/