//需求：操作数组基本算法
//定义一个类，叫ArrayOperatorTest02
class ArrayOperatorTest02 {
	//定义主方法
	public static void main(String[] args) {
		//先定义一个数组
		int[] arrayForTest = {96,36,58,12,106,3};
		//获取该数组最大元素
		//步骤：通过定义一个变量。把数组第一或最后一个元素存储进去，再把它与数组剩下的数字逐一做比较。
		//若发现有数字比它大，便把较大值重新赋予给那个变量，直到比较完最后一个元素
		int maxNumber = arrayForTest[0];
		//用for循环遍历该数组所有元素
		for(int i = 0;i < arrayForTest.length;i++){
			//用if语句，若在遍历过程中发现有数字比maxNumber大，把较大数字赋给maxNumber
			if(maxNumber < arrayForTest[i]){
				maxNumber = arrayForTest[i];
			}
		}
		System.out.println(maxNumber);
		//获取该数组最小元素
		//步骤：通过定义一个变量。把数组第一或最后一个元素存储进去，再把它与数组剩下的数字逐一做比较。
		//若发现有数字比它小，便把较小值重新赋予给那个变量，直到比较完最后一个元素
		int minNumber = arrayForTest[0];
		//用for循环遍历该数组所有元素
		for(int i = 0;i < arrayForTest.length;i++){
			//用if语句，若在遍历过程中发现有数字比minNumber小，把较小数字赋给minNumber
			if(minNumber > arrayForTest[i]){
				minNumber = arrayForTest[i];
			}
		}
		System.out.println(minNumber);

		//打印数组元素,输出效果为{96,36,58,12,106,3}
		//步骤：1.把输出效果拆分为三部分，数字部分，逗号部分和两个大括号
		//2.数字部分要用for循环来遍历输出
		//3.大括号要在for循环开始前和结束后通过String拼接
		//4.逗号要在每一次数字输出后通过String拼接，但输出最后一个数字时不用加逗号
		String result = "{";
		for(int i = 0;i < arrayForTest.length;i++){
			result += arrayForTest[i];
			if(i < arrayForTest.length - 1){
				result += ",";
			}
		}
		result += "}";
		System.out.println(result);
		//创建新对象接收方法返回的逆序排列之后的新数组
		int[] newArray = ArrayOperatorTest02.reverse(arrayForTest);
		//使用for循环输出新数组所有元素
		for(int i = 0;i < newArray.length;i++){
			System.out.println(newArray[i]);
		}
	}
		//逆序排列数组元素
		//步骤：1.创建一个新方法，由于在运行时有未知量（旧数组名称）参与，形式参数有一个，类型为数组
		//2.逆序排列数组元素后，会产生一个新数组，返回值类型也为数组
		//3.新数组的元素暂时不知道，而且数组元素顺序不同，但数组长度相同，用动态初始化创建新数组
	static int[] reverse(int[] arrayForTest){
		//由于是逆序排列，新数组元素[0] = 旧数组元素[旧.length - 1],新数组元素[1] = 旧数组元素[旧.length - 2],即两数相加为旧.length - 1
		int[] newArray = new int[arrayForTest.length];
		for(int i = 0;i < arrayForTest.length;i++){
			newArray[i] = arrayForTest[arrayForTest.length - 1 - i];
		}
		return newArray;
	}
}
/*
小结：在打印数组所有元素时，要学会把不同元素拆分分不同部分，归纳它们什么时候该出现。
数组元素通常用循环来打印，直接打印数组只会输出数组的hasgcode
*/