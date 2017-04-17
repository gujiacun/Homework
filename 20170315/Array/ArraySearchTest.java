//需求：元素出现索引第一次
//步骤：1.新建一个方法，由于要接收搜询的数组名称和要搜索的元素，有两个形参
//2.需要返回元素第一次出现的索引，定义返回值类型为int
//3.需要遍历数组所有元素，用for循环
//定义一个类，叫ArraySearchTest
class ArraySearchTest {
	//定义主方法
	public static void main(String[] args) {
		//先定义一个数组，在里面寻找5第一次出现时的索引
		int[] array = {56,502,5,5,98,30};
		//在主方法创建一个变量来接受方法返回的结果
		int result = ArraySearchTest.search(array,5);
		System.out.println(result);
	}
	//定义主方法，接受数组名和所需要许寻找的元素
	static int search(int[] arr,int a){
		//遍历数组
		for(int i = 0;i < arr.length;i++){
			//条件判断，若为true即表示找到
			if(arr[i] == a){
				//返回结果
				return i;
			}
		}
		//若5在数组里不存在，返回-1表示不存在
		return -1;
	}
}
/*
小结：在使用数组时一定要记得在元素类型后面跟上[]
在遍历数组时，最好由0开始，比较不容易出错。
获取数组元素的格式： 元素类型 变量名 = 数组名[index];记住是中括号
*/