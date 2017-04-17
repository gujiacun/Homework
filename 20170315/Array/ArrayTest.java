//需求：创建各个数据类型的数组
//定义类,叫ArrayTest
class ArrayTest{
	//定义主方法
	public static void main(String[] args) {
		//声明各个类型的数组，先不进行初始化
		byte[] b; 
		short[] s;
		int[] i;
		long[] l;
		float[] f;
		double[] d;
		char[] c;
		boolean[] whether;
		String[] str;
		//给以上的数组进行静态初始化
		b = new byte[]{1,3,5};
		s = new short[]{63,69,98,20};
		i = new int[]{63,987};
		l = new long[]{6987L,166598L};
		f = new float[]{63.0F,58.064F};
		d = new double[]{98.036};
		c = new char[]{'A','蛤'};
		whether = new boolean[]{true,false,true,true};
		str = new String[]{"too young","too simple"};
		//给以上的数组进行动态初始化
		//b = new byte[3];
		//s = new short[4]
		//i = new int[2.;]
		//l = new long[2];
		//f = new float[4];
		//d = new double[1];
		//c = new char[2];
		//whether = new char[4];
		//str = new str[2];
		//System.out.println
		//把声明及初始化合成一步的动态初始化
		int[] arr = new int[5];//数组长度是5
		//把声明及初始化合成一步的静态初始化
		String[] arrayDemo = new String[]{"黑框眼镜","高高的裤腰带","会弹夏威夷吉他"};
		//上述代码可简化为，但这种简单写法必须声明与初始化同时进行
		String[] arrayDemo1 = {"黑框眼镜","高高的裤腰带","会弹夏威夷吉他"};
		//下面重新创建长度为7的数组，并分配给arr.注意在数组重新初始化时，无论动/静态，new int[]都不能省略
		arr = new int[7];

	}
}
/*
小结：数组的动态初始化，程序员指定数组的长度，系统自动为数组元素分配初始值。
格式为：元素的数据类型[] 数组名 = new 元素的数据类型[X];
数组的静态初始化，程序员指定每个元素的初始值，系统自动分配数组长度。
格式为：元素的数据类型[] 数组名 = new 元素的数据类型[]{元素1，元素2...元素N};
new表示在堆空间开辟一块内存区域来存储数据，null表示没有引用任何内存空间
*/