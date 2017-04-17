//需求：操作数组的动态初始化及静态初始化
//定义一个类，叫ArrayInitTest 
class ArrayInitTest {
	//定义主方法
	public static void main(String[] args) {
		//把声明及初始化合成一步的动态初始化
		String[] array = new String[5];
		//把声明及初始化合成一步的静态初始化
		String[] arrayTest = new String[]{"黑框眼镜","高高的裤腰带","会弹夏威夷吉他"};
		//上述代码可简化为下行，但这种简单写法必须声明与初始化同时进行
		//String[] arrayTest = {"黑框眼镜","高高的裤腰带","会弹夏威夷吉他"};
		//下行代码会报错
		//array = {"excited","excited","excited","excited","excited"};
		array = new String[]{"蛤蟆","蛤蟆","蛤蟆","蛤蟆","蛤蟆"};
		arrayTest = null;
	}
}
/*
小结：在使用数组时一定要记得在元素类型后面跟上[]
*/