//需求：了解接口的定义格式，接口成员的特点
//创建接口
interface IWalkAble{
	//尝试定义字段
	int age = 10;
	//尝试定义普通方法，错误: 接口抽象方法不能带有主体
	void method(){
		System.out.println("mememe");
	}
}
//尝试继承类，错误: 此处需要接口
interface IWalkAble01 extends aaa{

}
//接口只能继承接口，支持多继承
interface IWalkAble02 extends IWalkAble,IWalkAble01{
	//尝试修改字段,错误: 需要<标识符>,接口中定义的成员变量,实质是全局静态常量,默认使用  public static final来修饰
	age = 20;
}
//创建类
class aaa{
}
//创建类
class InterFaceTest {
	//创建主方法
	public static void main(String[] args) {
		//尝试在接口中创建对象,错误: IWalkAble是抽象的; 无法实例化
		//IWalkAble i = new IWalkAble();


	}
}
/*
小结：接口中定义的方法都是公共的抽象方法，不能有方法体.
要牢记接口各个成员的特点
*/