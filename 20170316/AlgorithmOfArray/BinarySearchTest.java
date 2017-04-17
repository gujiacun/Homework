//需求：操作二分搜索法，在数组中寻找特定元素，返回其索引值，并打印。前提:数组元素必须有顺序.
//步骤：创建新方法，接收主方法传来的数组名称，搜索元素，返回索引值
//在主方法中调用方法并接受结果，打印索引值
//定义类，叫BinarySearchTest
class BinarySearchTest {
	//定义主方法
	public static void main(String[] args) {
		//定義一個有序數組
		int[] array = {0,6,8,19,35,69,78};
		//調用binarySearch方法並傳遞實參，定義變量接收返回值
		int index = BinarySearchTest.binarySearch01(array,35);
		System.out.println(index);
	}
	//定义進行二分搜索法的方法
	static int binarySearch01(int[] arr,int x){
		//需要先定義最低索引值和最高索引值，然後用它們的和除以2得出中間索引值，及其對應的值
		//把搜索元素與中間值比較，若搜索元素較大，則它在數組較大的一半中，修改最低索引值，下一輪在數組較大的一半中尋找
		//若搜索元素較小，則它在數組較小的一半中，修改最高索引值，下一輪在較小的一半中尋找
		//每一輪中，搜索範圍都是上一輪的一半，所以稱爲二分
		//在第一輪中的情況如下
		/*int low01 = 0;
		int high01 = 7;
		int mid01 = (low01 + high01) / 2;
		if(x > arr[mid01]){
			low01 = mid01 + 1;
		}else if(x < arr[mid01]){
			high01 = mid01 - 1;
		}else{
			return x;
		}
		*/
		//由上面可推出，上述代碼要執行一定次數，但次數不定，因此我們用while來控制循環
		//至於循環控制條件，用最低索引值<=最高索引值來控制
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
}
/*
小結：變量的值是否需要在循環執行時產生變化，是把它放在循環外或循環裏的條件，邏輯錯誤
*/