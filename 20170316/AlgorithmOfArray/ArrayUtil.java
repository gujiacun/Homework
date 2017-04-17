//需求：數組的工具類，把操作數組常用的方法封裝在此類中
//不需要主方法，因爲我們不直接運行它，而是在別的類中調用此類中的方法
class ArrayUtil {

	//int類型數組的元素拷貝粘貼
	static void copy(int[] array,int srcPos,int[] newArray,int destPos,int length){
		if(srcPos <= 0 || destPos <= 0 || srcPos > destPos){
			System.out.println("输入数字有误");
		}
		//如何确定循环次数？循环从开始的索引值，到子序列的长度加上开始索引值结束
		for(int i = srcPos;i < length + srcPos;i++){
			newArray[destPos] = array[i];
			//新数组的下标也要每循环一次增加1，与旧数组匹配
			destPos++;
		}
		//遍历打印新数组元素
		for(int i = 1;i < newArray.length;i++){
			System.out.println(newArray[i]);
		}
	}

	//二分搜索法
	static int binarySearch01(int[] arr,int x){
		int low = 0;
		//數組的最高索引值為數組長度 - 1
		int high = arr.length - 1;
		//一個數的二進制數向左移一位，等於x2，向右移一位，等於/2，中間索引
		while(low <= high){
			//中間的索引值一定要放在循環裏面，隨著循環迭代而變更，若放在循環外，其值就無法改變
			int mid = (low + high) >> 1;
			if(x > arr[mid]){
				low = mid + 1;
			}else if(x < arr[mid]){
				high = mid - 1;
			}else{
				return mid;
			}
		}
		//假如以上條件均不符合，即輸入數據有誤，返回-1
		return -1;
	}

	//逆序排列数组元素
	static int[] reverse(int[] arrayForTest){
		//由于是逆序排列，新数组元素[0] = 旧数组元素[旧.length - 1],新数组元素[1] = 旧数组元素[旧.length - 2],即两数相加为旧.length - 1
		int[] newArray = new int[arrayForTest.length];
		for(int i = 0;i < arrayForTest.length;i++){
			newArray[i] = arrayForTest[arrayForTest.length - 1 - i];
		}
		return newArray;
	}

	//打印數組元素
	static void print(String[] args) {
		int nums[] = { 1, 2, 3, 4, 5 };
		String str = "[";
		for (int i = 0; i < nums.length; i++) {
			str += nums[i];
			if(i != nums.length - 1){
				str += ", ";
			}
		}
		System.out.println(str);
	}


	//获取该数组最大元素
	//步骤：通过定义一个变量。把数组第一或最后一个元素存储进去，再把它与数组剩下的数字逐一做比较。
	//若发现有数字比它大，便把较大值重新赋予给那个变量，直到比较完最后一个元素
	static int getMax(int[] arrayForTest){
		int maxNumber = arrayForTest[0];
		//用for循环遍历该数组所有元素
		for(int i = 0;i < arrayForTest.length;i++){
			//用if语句，若在遍历过程中发现有数字比maxNumber大，把较大数字赋给maxNumber
			if(maxNumber < arrayForTest[i]){
				maxNumber = arrayForTest[i];
			}
		}
		return maxNumber;
	}

	
	//获取该数组最小元素
	//步骤：通过定义一个变量。把数组第一或最后一个元素存储进去，再把它与数组剩下的数字逐一做比较。
	//若发现有数字比它小，便把较小值重新赋予给那个变量，直到比较完最后一个元素
	static int getMin(int[] arrayForTest){
		int minNumber = arrayForTest[0];
		//用for循环遍历该数组所有元素
		for(int i = 0;i < arrayForTest.length;i++){
			//用if语句，若在遍历过程中发现有数字比maxNumber大，把较大数字赋给maxNumber
			if(minNumber < arrayForTest[i]){
				minNumber = arrayForTest[i];
			}
		}
		return minNumber;
	}
}
/*
小結：在editplus中，按ctrl + F11，可快速尋找在這個文件中的所有方法列表
創建一個工具類，我們在別的文件裏就不用重新寫方法，大大減輕負擔，同時使工程結構更簡單
*/
