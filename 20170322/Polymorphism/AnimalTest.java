//需求：引入并初步理解多态的概念，使用多态的格式，知道多态的前提
//创建类AnimalTest
public class AnimalTest {
	//创建主方法
	public static void main(String[] args) {
		//创建佣人对象
		Servant s = new Servant();
		//创建狗对象，运用多态，Animal是编译类型，Dog是运行类型
		Animal a = new Dog();
		//通过对象s调用feed方法，传入变量a，此时表示Dog
		s.feed(a);
		//创建猫对象，运用多态，Animal是编译类型，Cat是运行类型
		a = new Cat();
		//通过对象s调用feed方法，传入变量a，此时表示Cat
		s.feed(a);
	}
}
//创建父类Animal
class Animal{
	//动物共同的状态
	public void eat(){
		System.out.println("动物每天进食维持生命");
	}
}
//创建子类Dog
class Dog extends Animal{
	//狗是动物中的子类，食物有其特殊性
	public void eat(){
		System.out.println("狗吃狗粮");
	}
}
//创建子类Cat
class Cat extends Animal{
	//狗是动物中的子类，食物有其特殊性
	public void eat(){
		System.out.println("猫吃猫粮");
	}
}
//创建一个类，叫Servant
class Servant{
	//佣人负责喂狗和猫食物
	public void feed(Animal a){
		//如果没有多态，Servant类的feed方法就要进行重载，分别对应Cat的对象和Dog的对象
		System.out.println("佣人给动物喂食物");
		//根据父类Animal的变量a来调用不同的eat方法，此时子类和父类有方法重写现象
		a.eat();
	}
}
/*
小结：多态能抹平不同的子类对象之间的差异，把他们当父类的类型来看待
*/