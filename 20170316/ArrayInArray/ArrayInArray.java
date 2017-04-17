//需求：操作多维数组的声明，两种初始化方法，获得元素，赋值
//定义一个类，叫ArrayInArray
class ArrayInArray {
	//定义主方法
	public static void main(String[] args) {
		//定义三个一维数组
		int[] arr1 = {10,20,30,65,98};
		int[] arr2 = {40,50};
		int[] arr3 = {60,69};
		//如果一个数组中每个元素都是一维数组，那它就是二维数组，下面进行初始化
		int[][] twoArray = {arr1,arr2,arr3};
		//以上代码也可写为int[][] twoArray = {{10,20,30},{40,50},{60}};
		//可以把二维数组理解成表格，第一个括号内是行，第二个括号内是列。获得数组中第2行第1列的数据。
		int result = twoArray[2][1];
		System.out.println(result);
		//给数组的第0行第二列数字赋值为639
		twoArray[0][2] = 639;
		System.out.println(twoArray[0][2]);
		//打印数组的第一个元素
		for(int i = 0;i < twoArray[0].length;i++){
			System.out.print(twoArray[0][i] + " , ");
		}
		//二维数组的动态初始化,创建一个数组，有10个元素，每个元素长度为5
		int[][] newArray = new int[10][5];
	}
}
/*
小结：N维数组的每一个元素都是N - 1维数组，行意为数组的长度（元素的个数），列意为每个元素最多能有多少个值
*/