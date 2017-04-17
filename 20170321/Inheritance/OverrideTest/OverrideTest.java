//需求：在子类中操作重写方法，打印验证
class Son{
	//重写父类中的kill方法
	public void kill(){
		System.out.println("我是jose aldo，被爸爸13秒终结");
	}
}
//创建父类class，叫Father
class Father{
//在父类创建方法
	protected void kill(){
		System.out.println("我是conor mcgregor，是jose aldo爸爸");
	}
}
//创建类，叫OverrideTest
public class OverrideTest {
	//创建主方法，程序入口
	public static void main(String[] args) {
		System.out.println("Hello World!");
		//创建Son的对象s，通过它调用kill方法
		Son s = new Son();
		s.kill();
	}
}
/*
小结：重写方法必须都是实例方法，静态方法是叫隐藏，注意区分
在重写方法中，实例方法签名必须相同，子类方法的访问权限要大于等于父类方法
它的作用是解决子类继承父类之后,如果父类的某个方法不满足子类的具体特征,此时需要重新在子类中写方法.

*/