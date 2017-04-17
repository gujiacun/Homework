//需求：操作代码块不同情况，并记住其特点
//创建测试类，CodeBlockTest
//定义一个类，操作初始化代码块(构造代码块)
class CodeBlock{
	{
		System.out.println("我是初始化代码块");
	}
	//操作静态代码块，可以看到它的执行顺序比构造方法更早
	static{
		System.out.println("我是静态代码块");
	}
}
public class CodeBlockTest {
	//创建主方法
	public static void main(String[] args) {
		System.out.println("我是主方法代码块");
		//创建对象,可以看到类中的初始化代码块被输出，因为它被编译器放进构造方法的第一句
		CodeBlock c = new CodeBlock();
		//调用method方法
		CodeBlockTest.method();
		
	}
	//定义一个新方法。操作局部代码块,留意输出顺序
	public static void method(){
		//操作局部代码块
		{
			System.out.println("我是在method方法中的前面的代码块");
		}
		System.out.println("我是在method方法中的小透明");
		{
			System.out.println("我是在method方法中的后面的代码块");
		}
	}
}
/*
小结：静态成员随着字节码的加载也加载进JVM,此时构造方法还没执行,因为方法需要JVM调用
*/