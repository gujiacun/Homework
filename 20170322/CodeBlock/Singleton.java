//需求：创建一个数组的工具类，设计为单例模式的饿汉式
//饿汉式单例模式的步骤
//      1):必须在该类中,自己先创建出一个对象.
//      2):私有化自身的构造器,防止外界通过构造器创建新的对象.
//      3):向外暴露一个公共的静态方法用于获取自身的对象.

//创建数组的工具类，ArraysUtil
class ArraysUtil{
	//自己创建对象
	//要用static修饰，是因为向外暴露的方法为静态，且返回对象
	//若创建对象的方法为非静态，则静态上下文不能引用非静态上下文，向外暴露的方法报错
	private static final ArraysUtil tool = new ArraysUtil();
	//私有化自身的构造器
	private ArraysUtil(){
	}
	//向外暴露一个公共的静态方法用于获取自身的对象
	public static ArraysUtil getInstance(){
		//返回值类型为本类，return已创建的对象
		return tool;
	}

	//int類型數組的元素拷貝粘貼
	public void copy(int[] array,int srcPos,int[] newArray,int destPos,int length){
		if(srcPos <= 0 || destPos <= 0 || srcPos > destPos){
			System.out.println("输入数字有误");
		}
		for(int i = srcPos;i < length + srcPos;i++){
			newArray[destPos] = array[i];
			destPos++;
		}
		for(int i = 1;i < newArray.length;i++){
			System.out.println(newArray[i]);
		}
	}

	//二分搜索法
	public int binarySearch(int[] arr,int x){
		int low = 0;
		int high = arr.length - 1;
		while(low <= high){
			int mid = (low + high) >> 1;
			if(x > arr[mid]){
				low = mid + 1;
			}else if(x < arr[mid]){
				high = mid - 1;
			}else{
				return mid;
			}
		}
		return -1;
	}

	//逆序排列数组元素
	public int[] reverse(int[] arrayForTest){
		int[] newArray = new int[arrayForTest.length];
		for(int i = 0;i < arrayForTest.length;i++){
			newArray[i] = arrayForTest[arrayForTest.length - 1 - i];
		}
		return newArray;
	}

	//打印數組元素
	public void print(String[] args) {
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
	public int getMax(int[] arrayForTest){
		int maxNumber = arrayForTest[0];
		for(int i = 0;i < arrayForTest.length;i++){
			if(maxNumber < arrayForTest[i]){
				maxNumber = arrayForTest[i];
			}
		}
		return maxNumber;
	}

	
	//获取该数组最小元素
	public int getMin(int[] arrayForTest){
		int minNumber = arrayForTest[0];
		for(int i = 0;i < arrayForTest.length;i++){
			if(minNumber < arrayForTest[i]){
				minNumber = arrayForTest[i];
			}
		}
		return minNumber;
	}
}

//创建测试类，Singleton
public class Singleton {
	//创建主方法，程序入口
	public static void main(String[] args) {
		int[] array = {1,-3,61,0,54,-36};
		//ArrayUtil.getInstance()通过类名调用方法，返回值为该类的对象tool
		//tool.reverse()通过得到的对象调用reverse逆序排序方法，括号填入数据
		int[] newArray = ArraysUtil.getInstance().reverse(array);
	}
}
/*
小结：向外暴露一个公共的静态方法用于获取自身的对象，返回值为对象。
在该类中,自己创建对象时，创建语句要用static修饰，因为向外暴露的方法被static修饰，
而静态上下文无法引用非静态的变量
*/