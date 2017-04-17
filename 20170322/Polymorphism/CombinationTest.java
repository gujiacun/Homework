//需求：为解决代码复用问题，若两个类有继承关系，可用继承;其余情况优先用组合关系
//在数组排序中实现组合关系，先创建工具类，实现排序功能。再在主方法中创建数组，调用排序算法
//创建排序工具类
class ArraysUtil{
	//新建方法，实现排序功能，只是排序，无需创建新数组，也无需返回值
	public void sort(int[] score){
		for (int i = 0; i < score.length - 1; i++) {
			int minIndex = i;
			//由于是在内循环结束后才交换值，所以j要定义在内循环外
			int j = i + 1;
			for (; j < score.length; j++) {
				if (score[minIndex] > score[j]) {
					minIndex = j;
				}
			}
			//内循环结束后，把得到的最小值的索引与score[i]交换，一次内循环只需交换一次。
			int temp = score[minIndex];
			score[minIndex] = score[i];
			score[i] = temp;
		}
	}
}
//创建测试类，CombinationTest
public class CombinationTest {
	//创建主方法
	public static void main(String[] args) {
		//创建新数组
		int[] array = {1,3,-6,65,21,0};
		//创建对象，调用工具类中的排序方法，把数组传过去并排序
		ArraysUtil tool = new ArraysUtil();
		tool.sort(array);
		//用Arrays类中的toString方法把newArray转换为String类型并输出
		System.out.println(java.util.Arrays.toString(array));
	}
}
/*
小结：组合关系是在测试类中通过创建工具类的对象来调用工具方法，与继承关系不同，不会修改工具类字段
*/