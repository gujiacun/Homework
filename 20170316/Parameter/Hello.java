//需求：运用命令行向main方法的String数组传递参数
//定义一个类，叫Hello
class Hello {
	//定义主方法，由于被static修饰，所以可以调用，格式为Hello.main(实参);
	public static void main(String[] args) {
		System.out.println("Hello World!");
		//输出了hashcode，证明传递进来了String类型的数组
		System.out.println(args);
		//但此数组长度为0，即为空数组
		System.out.println(args.length);
		//我们可以在命令行中给main方法传递参数，并用for循环把传递进来的数组打印出来
		for(int i = 0;i < args.length;i++){
			System.out.println(args[i]);
		}
		//在命令行中输入A B C D E后，成功打印，上面语句的数组长度也变为5，但hashcode没有改变
	}
}
/*
小结：我对命令行的操作还不是很熟悉，听说linux经常要用到命令行，要记住常见的命令行操作
给main方法传递参数最好也能掌握。
*/