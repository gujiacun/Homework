//需求：操作import语句，导入Arrays类，把一个数组转换成String类型输出，然后排序，搜索元素，拷贝元素
//导入Arrays这个类，格式为： import 类的全限定名;这里只能导入一个类,要在后面加;
import java.util.Arrays;
//定义一个类文件，叫ImportTest
public class ImportTest {
	//定义主方法
	public static void main(String[] args) {
		//创建数组
		int[] array = {52,63,0,-54,39,10,987};
		//把一个数组转成String类型输出
		String arr = Arrays.toString(array);
		System.out.println(arr);
		//排序
		Arrays.sort(array);
		//把排序后的array数组重新赋值给arr并输出
		arr = Arrays.toString(array);
		System.out.println(arr);
		//搜索元素10
		int a = 0;
		//要用二分搜索法搜索特定数值，前提是把数组按照大小排好顺序
		int index = Arrays.binarySearch(array,0);
		System.out.println(index);
		//拷贝元素,在调用方法时要注意按方法的参数列表填入内容,copyOf(int[] original, int newLength)
		//先动态创建一个新数组，用来接收从旧数组拷贝而来的元素
		int[] arr02 = new int[7];
		//复制元素到新数组
		arr02 = Arrays.copyOf(array,7);
		//把新数组转换为String类型并输出
		String arr03 = Arrays.toString(arr02);
		System.out.println(arr03);
	}
}
/*
小结：若想导入该包下的所有的在当前文件中使用到的类，，格式为：import java.util.*
*/