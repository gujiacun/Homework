//需求：创建一个数组{3，12，69，10，25，8}把它的第二至第四个元素复制到长度为8的新数组中,从第三个元素开始复制
//创建一个新方法，功能为从旧数组中取得子序列，粘贴到新数组的指定位置中
//定义一个类，叫ArrayCopy
class ArrayCopy {
	//定义主方法
	public static void main(String[] args) {
		//创建数组
		int[] array = {3,12,69,10,25,8}; 
		//创建一个空的新数组
		int[] newArray = new int[8];
		//调用copy方法，传递参数值，注意变量要一一对应
		ArrayCopy.copy(array,newArray,1,2,3);

	}
	//创建新方法，由于要从旧数组拷贝元素到新数组，所以需要新旧数组的名称。
	//从旧数组的哪个索引位置开始拷贝，在新数组的哪个索引位置开始粘贴，需要两个下标
	//定义子序列的长度，确定拷贝的结束位置
	static void copy(int[] array,int[] newArray,int srcPos,int destPos,int length){
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
}
/*
小结：定义方法的参数最好不超过5个，要寻找能减少参数的方法，同时要多考虑程序面对的多种情况，让程序更强壮
*/