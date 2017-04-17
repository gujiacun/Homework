//需求：操作方法的可变参数，掌握格式和特点
//创建一个类，叫VarArgs
class VarArgs {
	//定义主方法
	public static void main(String[] args) {
		//要求：编写一个方法,统计使用数组传递过来的数的总和.
		/*步骤：在主方法创建一个数组。
		创建一个方法，功能为接收从主方法传来的数组，并把数组内的元素全部相加求和，返回结果。
		在主方法内创建新变量接受结果，输出
		*/
		int[] array = {10,36,5,98,22,78};
		//用第一种方法
		int result = VarArgs.getSum(array);
		System.out.println(result);
		//用方法的可变参数,在得到一系列数据时不再需要把它们先定义成数组，直接调用方法就好
		int result02 = VarArgs.getSum02(10,36,5,98,22,78);
		System.out.println(result02);
	}
	//创建方法，接收从主方法传来的数组，所以形式参数为int[] arr。求和要用for循环
	static int getSum(int[] arr){
		//定义变量作为结果
		int sum = 0;
		//用for循环求数组元素之和
		for(int i = 0;i < arr.length;i++){
			//缩写，同sum = sum + arr[i];
			sum += arr[i];
		}
		//返回结果
		return sum;
	}
	//用方法的可变参数简化以上代码
	static int getSum02(int ...  X){
		//定义变量作为结果
		int sum = 0;
		//用for循环求数组元素之和
		for(int i = 0;i < X.length;i++){
			//缩写，同sum = sum + arr[i];
			sum += X[i];
		}
		//返回结果
		return sum;
	}
}
/*
小结：方法的可变参数使得我们在编写方法时更简便，此时方法中可以接受的参数不再是固定个数。
同时，可变参数只能出现在参数列表的最后，避免歧义，可变参数的本质是数组
*/