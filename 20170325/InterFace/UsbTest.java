//需求：比较接口和抽象类的区别
//创建抽象类
abstract class Aaa{
	//实验抽象类有没有构造方法
	Aaa(){
		System.out.println("我是抽象类");
	}
}
//创建接口,指定USB规范
interface IUsb{
	//实验接口有没有构造方法,报错，证明没有
	//IUsb(){
	//}
	//创建规范
	void swapData();
	//创建接口中的类和内部类
	class AAA{
		class aaa{
			//System.out.println("我是接口中的内部类");
		}
	}
}
//创建实现类，表示鼠标
class Mouse implements IUsb{
	public void swapData(){
		System.out.println("鼠标在正常工作");
	}
}
//创建实现类，表示音响
class Radio implements IUsb{
	public void swapData(){
		System.out.println("音响在正常工作");
	}
}
//创建实现类，表示主板
class MotherBoard{
	//创建方法，表示把设备插入到主板中,可用类名调用
	public static void plugIn(IUsb usb){
		usb.swapData();
	}
}
//创建抽象类的子类,子类继承抽象类，实现接口
class Son extends Aaa implements IUsb{
	Son(){
		System.out.println("我是抽象类的子类");
	}
	public void swapData(){
		System.out.println("。。。");
	}
}
//创建测试类
public class UsbTest {
	//创建主方法
	public static void main(String[] args) {
		//尝试建对象,错误: Aaa,IUsb是抽象的; 无法实例化
		//Aaa a = new Aaa();
		//IUsb u = new IUsb();
		//建实现类的对象
		Radio r = new Radio();
		//调用Son的构造方法，实验得出抽象类也有构造方法
		Son s = new Son();
		//创建Mouse对象,把实现类的对象赋给接口的变量，运行时调用实现类的方法
		IUsb mice = new Mouse();
		//创建MotherBoard对象
		MotherBoard board = new MotherBoard();
		//通过MotherBoard对象调用plugIn方法，把Mouse对象传进去，体现多态
		board.plugIn(mice);
		//给接口创建匿名内部实现类
		new IUsb(){
			public void swapData(){
				System.out.println("fuck you");
			}
		};
	}
}
/*
小结：接口与抽象类的比较，优先使用接口。都不能直接实例化，但接口没构造方法，抽象类有
一个子类只能继承一个父类，能实现多个接口
接口字段默认是public static final,方法默认public abstract
*/