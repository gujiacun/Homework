//需求：进行数组的基本操作，得到数组的长度，获取某个元素，知道数组的索引范围，给数组元素赋值,遍历数组元素
//定义类文件，叫ArrayOperatorTest
class ArrayOperatorTest {
	//定义主方法
	public static void main(String[] args) {
		//先定义一个数组
		int[] arrayTest = new int[]{10,36,89,65};
		//通过length属性来获取数组的长度（数组的元素个数）
		System.out.println(arrayTest.length);
		//数组的索引范围由0开始，逐一递增，最大值为数组长度减1
		//获取数组最后一个元素的值,注意最后一个元素的索引值为数组长度减1
		int num = arrayTest[arrayTest.length - 1];
		System.out.println(num);
		//给数组第二个元素重新赋值为963，并打印出来
		arrayTest[1] = 963;
		System.out.println(arrayTest[1]);
		//使用for循环遍历数组元素
		//数组的索引值由0开始，到数组长度-1结束
		for(int i = 0;i < arrayTest.length;i++){
			System.out.println(arrayTest[i]);
		}
	}
}
/*
小结：获取数组元素的格式： 元素类型 变量名 = 数组名[索引值];
给数组元素赋值的格式： 数组名[索引值] = 常量;
*/