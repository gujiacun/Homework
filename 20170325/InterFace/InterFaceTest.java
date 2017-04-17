//需求：了解接口的定义格式，接口成员的特点
//创建接口
interface IWalkAble{
	//尝试定义字段
	public int age = 10;
	//尝试定义普通方法，错误: 接口抽象方法不能带有主体
	//void method(){
		//System.out.println("mememe");
	//}
	//public void method(){
		//System.out.println("mememe");
	//}
	//创建抽象方法，没方法体，留给子类实现
	void say();
}
//尝试继承类，错误: 此处需要接口，因为接口无法继承类，只能继承接口
interface IWalkAble01 extends IWalkAble{

}
//接口只能继承接口，支持多继承
interface IWalkAble02 extends IWalkAble,IWalkAble01{
	//尝试修改字段,错误: 需要<标识符>,接口中定义的成员变量,实质是全局静态常量,默认使用  public static final来修饰
	//age = 20;
}
//创建类
class aaa{
}
//创建实现类
class bbb implements IWalkAble{
	//覆写接口方法,由于接口中的方法默认为public abstract,但类中方法修饰符要手动写，默认为包访问权限
	public void say(){
		System.out.println("excited!");
	}
}
//创建类，叫InterFaceTest
public class InterFaceTest {
	//创建主方法
	public static void main(String[] args) {
		//尝试在接口中创建对象,错误: IWalkAble是抽象的; 无法实例化，因为接口没有构造器
		//IWalkAble i = new IWalkAble();
		//面向接口编程,体现多态
		IWalkAble w = new bbb();
		w.say();

	}
}
/*
小结：接口中定义的方法默认是公共的抽象方法，不能有方法体.除非手动写修饰符
要牢记接口各个成员的特点
*/