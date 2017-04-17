//需求：操作static import，记住它的特点，并调用里面的方法
//定义一个类，叫Staticimport
//由于toString无法通过静态引入，所以用普通的import
import java.util.Arrays;
//静态调入，格式为import 包名.子包名.*;表示引入该包下的所有的在当前文件中使用到的类
import static java.util.Arrays.*;
//定义一个类，叫Staticimport
public class Staticimport {
	//定义主方法
	public static void main(String[] args) {
		//创建数组
		int[] array = new int[]{52,63,0,-54,39,10,987};
		//把一个数组转成String类型输出
		//由于Object中也有一个方法叫toString，而程序会默认从该根类中找方法，所以Arrays中的toString不能用静态调入
		String arr = Arrays.toString(array);
		System.out.println(arr);
		//排序，由于用了静态调入，所以Arrays下的方法能够直接用 方法(参数);
		sort(array);
		arr = Arrays.toString(array);
		System.out.println(arr);
	}
}
/*
小结：静态导入在底层也是通过普通调入实现的,因此在开发中少用,否则分不清某一个静态方法或字段来源于哪一个类.

*/