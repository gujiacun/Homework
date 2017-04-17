//需求：存在子类和父类，有多态关系，方法doWork分别存在于子类，父类，同时存在，被static修饰时的现象
//创建父类
class Father{
	static public void doWork(){
		System.out.println("我是爸爸!");
	}
}
//创建子类
class Son extends Father{
	static public void doWork(){
		System.out.println("我是儿子!");
	}
}
class MethodCallTest {
	public static void main(String[] args) {
		//创建子类对象，调用子类方法，这里用多态创建，即编译类型是运行类型的父类
		Father f = new Son();
		f.doWork();
		System.out.println("Hello World!");
	}
}
/*
小结：父类的方法与子类的方法输出不同内容，方便比较。创建子类对象，调用子类方法。
（1）当方法doWork同时存在于父类和子类中，编译通过,在运行时会执行运行类型的方法，即子类方法
（2）当方法doWork只存在于父类中，编译通过,执行父类的doWork方法.
     应该先从子类中去找doWork方法,找不到,再去父类中找.
（3）当方法doWork只存在于子类中，编译错误.编译时期,会去编译类型(SuperClass)中找是否有doWork方法，
     由于f的编译类型是属于Father的，调用doWork方法会去父类中找
（4）被static修饰并同时存在父类子类中时，通过对象调用静态方法，
	 在底层是通过类名调用类方法，由于对象f的编译类型是Father，调用的是父类静态方法
*/