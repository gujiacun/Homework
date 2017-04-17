//需求：操作在基本数据类型下，方法参数的值传递机制.
//步骤：在主方法中新建一个int变量，调用另一个方法（在里面给变量重新赋值），分别输出该变量在调用方法前，调用方法时，调用方法后的值
//定义一个类，叫ParameterTest01
class ParameterTest01 {
	//定义主方法
	public static void main(String[] args) {
		//在主方法定义int变量
		int num = 36;
		//输出调用change方法前num的值
		System.out.println("在main方法刚初始化时：num = " + num);
		//调用change方法
		ParameterTest01.change(num);
		//输出调用change方法后num的值
		System.out.println("在main方法里，调用change方法后：num = " + num);
	}
	//定义change方法
	static void change(int number){
		//输出num刚被传入change方法，尚未执行其他语句时候的值
		System.out.println("调用change方法前：num = " + number);
		//对number进行重新赋值
		number = 63;
		//输出执行上行语句后的值
		System.out.println("调用change方法后：num = " + number);
	}
}
/*
小结：为什么会出现以上四个数呢？ main方法与change方法分别在不同的栈帧里。main方法在栈底，change方法在栈顶。
当程序执行change(number);时（即调用change方法），main方法把里面的num的值（36）拷贝一份，再传递给change方法里的number变量，传递的仅仅是36这个常量的副本。
而在change方法里，number变量一开始等于36，后来经过重新赋值变为63。
此时change方法被调用完毕，位于栈顶的它首先出栈，然后main方法现在既在栈顶，又在栈底。
回到主方法，在它的栈帧里，num变量的值从未改变，仍然为36.所以在栈里面不需要垃圾回收，因为调用完就销毁。
注意：要想真正改变num的值，要在change方法里定义一个返回值，return，同时在主方法里定义新变量接受返回结果
*/