//需求：掌握匿名内部类两种格式
//创建一个接口
interface IWalkAble{
	//写抽象方法
	void say();
}

//创建一个类
class Father{
	public void say(){
		System.out.println("我是爸爸");
		//创建一个匿名内部类继承父类,本身没有构造器,但是会调用父类构造器
		new Father() {
			public void say(){
			System.out.println("我是爸爸的内部类");
			}
		//分号绝对不能省略
		};
	}
}

public class Anonymous {
	public static void main(String[] args) {
		//创建一个匿名内部类实现接口，一定要重写接口中的抽象方法
		new IWalkAble(){
			public void say(){
				System.out.println("excited!");
			}
		//分号绝对不能省略
		};
		//
	}
}
/*
小结：匿名内部类必须定义在某个宿主类里面，而且还是某方法里面
因为匿名内部类只是局部内部类的一种特殊情况
*/