//需求：熟悉实例内部类的定义方法和特点
//创建一个类
class Father{
	//创建外部类的字段，方法和实例内部类
	int age = 23;
	void say(){
		System.out.println("啊？又在写bug了？");
	}
	//没有static修饰，属于外部类的实例，所以叫实例外部类
	class Son{
		//创建内部类字段，方法
		int age = 33;
		//在实例内部类中尝试定义静态成员,错误: 内部类Father.Son中的静态声明非法
		//static int age1 = 0;
		void say(){
			System.out.println("不，我在debug");
			//创建方法内的局部变量
			int age = 43;
			System.out.println(age);//输出方法内的局部变量
			System.out.println(this.age);//输出内部类字段
			System.out.println(Father.this.age);//输出外部类的字段
			//this.say();
		}
	}
}
//创建测试类,叫InstanceInnerClass
public class InstanceInnerClass {
	//创建主方法
	public static void main(String[] args) {
		//现在要访问实例内部类的字段,所以要创建它的对象
		//由于实例内部类在外部类中与实例字段，实例方法同样需要通过外部类的对象来访问
		//所以要先创外部类的对象
		Father f = new Father();
		//通过外部类对象调用内部类的构造方法，赋给左边的外部类.内部类 变量名
		Father.Son s = f.new Son();
		//System.out.println(s.age);
		//上述代码可简写为
		Father.Son s2 = new Father().new Son();
		//System.out.println(s2.age);
		//调用Son中的say方法,验证当外部类字段，内部类字段和内部类方法变量同名时的访问方式
		s2.say();
		//通过外部类的实例访问外部类的字段和方法
		f.say();
		System.out.println("Hello World!");
		//Random random = new Random();
		//int num09 = random.nextInt(10);
		//System.out.println(num09);
	}
}
/*
小结：实例内部类，不能用static修饰，可以在里面直接访问外部类成员，要访问外部类的字段，
用外部类名.this.外部类字段名
牢记创建实例外部类的对象格式  外部类名.内部类名 变量名 = new 外部类名().内部类名([参数列表]);
*/