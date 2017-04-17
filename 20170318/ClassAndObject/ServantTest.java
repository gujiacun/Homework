//需求：对类和对象进行操作，理解两者关系，记住两者基本事项
//创建类文件，描述佣人，具有状态（字段）和行为（方法）,类名首字母大写
class Servants{
	//佣人的性别
	char sex ='m';
	//年龄
	int age = 36;
	//姓名
	String name;
	//能做很多事情，如买菜，做饭，清洁，用方法来描述
	void buy(){
		System.out.println("佣人去买菜了");
	}
	//注意，此处的方法不能被static修饰，因为这里的方法和字段属于该类所创建的对象
	void cook(){
		System.out.println("佣人去做饭了");
	}
	void clean(){
		System.out.println("佣人去搞清洁了");
	}
}
//定义类文件，叫ServantTest
class ServantTest 
{
	//创建主方法
	public static void main(String[] args) 
	{
		//在主方法中若想调用class Servants里的方法，得先把该类实例化，通过实例来调用方法
		//对象创建格式：类名 对象名 = new 类名();
		Servants serve = new Servants();
		//通过对象调用clean方法
		serve.clean();
		//获取对象的状态，通过对象访问字段
		char sex = serve.sex;
		System.out.println(sex);
		//修改对象的属性的值,并输出
		serve.age = 32;
		System.out.println(serve.age);
		//对象的打印操作,若直接打印输出，输出类名@16进制的hashcode
		System.out.println(serve);
		//对象的比较操作
		Servants serve2 = new Servants();
		serve2.age = 55;
		Servants serve3 = new Servants();
		serve3.age = 66;
		//"=="两边都是基本数据类型时，比较其值，是应用数据类型时，比较的是两者在内存中的引用地址
		System.out.println(serve == serve2);
		System.out.println(serve2 == serve3);
		//次行代码表示把serve2这对象的地址赋值给serve，serve的应用地址与serve2一样
		serve = serve2;
		System.out.println(serve);
		System.out.println(serve2);
		//把serve3的引用地址清空。此时serve3没有指引地址
		serve3 = null;
		//操作匿名对象,格式为new 类名();
		new Servants().clean();
	}
}
/*
小结：牢记新建对象的格式，同时匿名对象的创建格式为新建对象格式的后一半，由于要调用构建方法，所以在后面要加().
*/