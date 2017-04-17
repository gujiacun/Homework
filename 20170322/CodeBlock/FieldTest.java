//需求：验证字段是否存在多态特征
//创建父类
class Father {
	//创建父类字段
	public int age = 54;
	//创建父类方法
	public void life(){
		System.out.println("我老了");
	}
}
//创建子类
class Son extends Father {
	//创建子类字段，与父类字段同名，隐藏
	public int age = 23;
	//创建子类方法，与父类方法同名，由于都是实例方法，重写
	public void life(){
		System.out.println("我还年轻");
	}
}
//创建测试类，FieldTest
public class FieldTest {
	//创建主方法
	public static void main(String[] args) {
		//以多态方式把子类对象赋给父类变量
		Father f = new Son();
		//通过对象调用子类对象和方法
		//该对象编译类型为父类，在编译时期决定了调用父类内存空间的数据，显示父类字段
		System.out.println(f.age);
		//在运行时体现出多态特征，执行子类的life方法
		f.life();
	}
}
/*
小结：注意多态时方法调用的显示问题，和多态时字段不显示多态特征，按编译类型（父类）来显示
*/