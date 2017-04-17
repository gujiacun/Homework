//需求：在类文件中操作static修饰符，验证被static修饰的成员为类成员，属于类本身
//没被static修饰的成员为实例成员，属于对象
//创建一个封装类，叫Static
class Static{
	//创建字段age和方法method，均用static修饰，表示这两成员属于类本身
	static int age;
	//在方法中创建变量a接受传入的值
	static void method(int a){
		//把输入的a的值传给字段age
		age = a;
		//输出字段age的值
		System.out.println(age);
	}
	//在方法中创建实例成员,不用static修饰，表示属于对象
	int age1;
	void method01(int b){
		//把b的值赋给字段age1
		age1 = b;
		System.out.println(age1);
	}
}
//创建一个测试类，叫StaticTest
public class StaticTest {
	//创建主方法
	public static void main(String[] args) {
		//访问类成员，格式为类名.类成员;给类成员age赋值30
		Static.age = 30;
		//打印字段age的值
		System.out.println(Static.age);
		//创建类StaticTest的对象
		Static s = new Static();
		//通过对象s访问类Static中的属于它的实例变量
		int num = s.age1;
		//由于在类Static中还没有给字段age1赋值，所以输出的是默认值0
		System.out.println(num);
		//通过对象s调用类中的实例方法method01，传值给它，输出
		s.method01(63);
		//由于在类中把b的值63传给age1，所以现在输出s1的值为63
		System.out.println(s.age1);
		//通过对象s调用类成员method,输出3，但在底层依然是通过类名访问类成员
		s.method(3);
	}
}
/*
小结：类成员只能访问类成员，实例成员只能访问实例成员，对象在底层通过类名来访问类成员。
*/