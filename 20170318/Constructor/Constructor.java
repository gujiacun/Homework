//需求；操作构造方法，理解它的定义，特点，作用，重载
//定义一个类，叫Person
class Person{
	String name;
//当我们开始在类里自定义构造方法时，系统不再给我们分配构造方法
//构造方法的格式：[修饰符] 方法名(形式参数){程序语句;}构造方法的方法名与所在类名相同，无返回类型
	Person(String n){
		//把n参数的值付给字段name，可以给字段设置初始值
		name = n;
		System.out.println(n);
	}
		
}
//定义一个类，叫Constructor
class Constructor {
	//创建主方法，程序入口
	public static void main(String[] args) {
		//当我们在创建一个类的对象时，就是在调用构造器
		//由于此时Person类中有自定义构造方法，而且需要输入参数，在创建对象时直接输入内容
		Person p = new Person("与美国华莱士谈笑风生的长者");
		//若把构造方法里的name = n;注释掉，则n的值是与美国华莱士谈笑风生的长者，name是默认值
		System.out.println(p.name);
		//创建新对象，调用无参数构造方法
		Overload load1 = new Overload();
		//创建新对象，调参数为int类型的构造方法
		Overload load2 = new Overload(3);
		//创建新对象，调用参数为int类型和String类型的构造方法
		Overload load3 = new Overload(6,"蛤蛤");
	}
}
//需求：操作方法重载，认识到构造方法也是方法，其重载与方法相同
//定义一个类，叫Overload
class Overload{
	//以下方法为重载，在同一个类，方法名相同，参数列表不同，与返回值类型无关
	Overload(){
		System.out.println("此为无参数构造方法");
	}
	//由于都是构造方法，不用写返回值类型
	Overload(int age){
		System.out.println("此构造方法参数为int类型");
	}
	Overload(int age,String name){
		System.out.println("此构造方法参数为int类型和String类型");
	}
}
/*
小结：构造方法能创建对象，完成对象的初始化操作，可以给字段设置初始值。
*/