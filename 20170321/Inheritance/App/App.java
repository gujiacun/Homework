//需求：操作隐藏，隐藏父类静态方法，隐藏父类字段，隐藏本类字段并输出以验证
//创建父类
class Father{
	//创建父类字段
	protected int age = 0;
	//创建父类静态方法
	static void kill(){
		System.out.println("我是爸爸");
	}
}
//创建子类
class Son extends Father{
	//创建子类字段
	int age = 1;
	//创建子类静态方法，隐藏父类相同方法
	static void kill(){
		//此时父类方法被子类同名方法隐藏
		System.out.println("我是儿子");
	}
	void kill02(){
		//此时父类字段被子类字段隐藏,如果子类中没有age字段或不符合继承访问权限，会输出父类age值
		//若要输出父类中被隐藏的字段，super.字段名
		System.out.println(super.age);
	}
	public void kill03(int age){
		//隐藏了本类中的字段，此时输出的是在主方法中输入的值，假如要输出字段值，要在变量名前加上this.
		//System.out.println(age);
		//输出的是字段的值
		System.out.println(this.age);
	}
}
//创建一个类，叫App
public class App {
	//创建主方法
	public static void main(String[] args) {
		//通过类名调用Son类中的kill静态方法调用
		Son.kill();
		System.out.println("Hello World!");
		Son s = new Son();
		//调用kill02方法
		s.kill02();
		//调用kill03方法
		s.kill03(15);
	}
}
/*
小结：static不能和super以及this共存.前一个修饰的是类级别的，后两个修饰的是对象级别的
隐藏的前提是符合继承访问权限
*/