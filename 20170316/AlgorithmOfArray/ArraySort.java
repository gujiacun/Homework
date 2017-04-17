//需求：操作选择排序，升序
//定义一个类，叫ArraySort
class ArraySort {
	//定义主方法
	public static void main(String[] args) {
		//定义数组
		int[] arr = {2,9,6,7,4,1};
		//选择排序的本质是选择某个索引位置的元素（通常是第一个）
		//然后与后面的元素比较，若较大则交换位置，第一轮求出最小值，然后依次类推，以下第一轮
		//for(int i = 0;i < 1;i++){
			//if(arr[i] > arr[i + 1]){
				//int temp = arr[i];
				//arr[i] = arr[i + 1];
				//arr[i + 1] = temp;
			//}
		//}
		//第二轮
		//for(int i = 1;i < 2;i++){
			//if(arr[i] > arr[i + 1]){
				//int temp = arr[i];
				//arr[i] = arr[i + 1];
				//arr[i + 1] = temp;
			//}
		//}
		//第三轮
		//for(int i = 2;i < 3;i++){
			//if(arr[i] > arr[i + 1]){
				//int temp = arr[i];
				//arr[i] = arr[i + 1];
				//arr[i + 1] = temp;
			//}
		//}
		//每一轮的轮数与i相差1，以此作为外部循环变量，以上代码可简写为以下
		//数组内有N个元素，循环次数要N - 1 次
		for(int times = 1;times < arr.length;times++){
			for(int i = times;i < arr.length;i++){
				//符合条件就交换两个的值
				if(arr[times - 1] > arr[i]){
					int temp = arr[i];
					arr[i] = arr[times - 1];
					arr[times - 1] = temp;
				}
			}
		}
		for(int i = 0;i < arr.length;i++){
			System.out.println(arr[i]);
		}
	}
}
/*
小结：选择排序是先选定一个元素，再与后面元素比较。在分析算法时记得要多画图，一次循环一次一次地逐渐分析，在总结规律。
*/