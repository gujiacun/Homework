//需求：操作引用数据类型的转换关系，操作 instanceof 运算符
//创建父类
class Animal{

}
//创建子类
class Dog extends Animal{

}
//创建操作类InstanceOfTest
class InstanceOfTest {
	//创建主方法
	public static void main(String[] args) {
		//自动类型转换，由子类类型变量转换为父类类型变量
		//Dog d = new Dog();
		//Animal a = new Animal();
		//a = d;
		//以上三行可合并为以下一行
		Animal a = new Dog();
		//自动类型转换就是多态，把子类对象赋给父类变量，运行时体现子类特征
		System.out.println("Hello World!");
		//强制类型转换，把父类类型对象赋给子类类型变量
		Dog d = (Dog)a;
		//操作 instanceof 运算符，判断对象a是否属于Dog类型和Animal类型
		System.out.println(a instanceof Dog);
		System.out.println(a instanceof Animal);
		//使用getClass()方法，得到对象a的真实类型，而非编译类型
		System.out.println(a.getClass() == Dog.class);
		System.out.println(a.getClass() == Animal.class);
	}
}
/*
小结：由于在多态中，对象在编译时是编译类型，在运行时体现实际类型，instanceof判断对象是否是
某个类型的实例，getClass()方法得到对象的真实类型
*/