//需求：操作冒泡排序升序
//定义一个类，叫ArraySort02
class ArraySort02 {
	//定义主方法
	public static void main(String[] args) {
		//定义数组
		int[] arr = {2,9,6,7,4,1};
		//冒泡排序的本质是用相邻的两个数比较，若有前者比较大就与后者交换位置
		//先用第一与第二个数比较，若第一个比较大就与第二个交换位置
		//由于int[0] < int[1],所以两者不交换位置
		//现在得出int[1]是已知的数中最大的，用这个数与下一个数比较
		//由于int[1] > int[2],所以交换位置，交换后int[2] = 9,以此类推,以下为第一轮
		int i = 0;
		int j = i + 1;
		for(;i < 1;i++){
			if(arr[i] > arr[j]){
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		for (int k = 0; k < arr.length; k++) {
			System.out.println(arr[k]);
		}
		System.out.println("--------");
		//以下为第二轮
		int i1 = 1;
		int j1 = i1 + 1;
		for(;i1 < 2;i1++){
			if(arr[i1] > arr[j1]){
				int temp = arr[i1];
				arr[i1] = arr[j1];
				arr[j1] = temp;
			}
		}
		for (int k = 0; k < arr.length; k++) {
			//可以看到元素9和6调换了位置
			System.out.println(arr[k]);
		}
		System.out.println("--------");
		//完整展示,在比较时，左边的数要从索引0到倒数第二个数
		for(int i2 = 0;i2 < arr.length - 1;i2++){
			//在比较时，右边的数要从索引1到最后一个数
			for(int j2 = i2 + 1;j2 < arr.length;j2++){
				if(arr[i2] > arr[j2]){
					int temp = arr[i2];
					arr[i2] = arr[j2];
					arr[j2] = temp;
				}
			}
		}
		for (int k = 0; k < arr.length; k++) {
			//遍历输出数组元素
			System.out.println(arr[k]);
		}
	}
}
/*
小结：各数组各元素依次比较相邻的两个元素大小，若前者较大则交换位置，经过第一轮比较排序后可得出最大值，然后使用同样的方法把剩下的元素逐个比较，最后得到结果。
*/