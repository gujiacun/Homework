//需求：在引用数据类型下，操作方法的值传递机制
//步骤：在主方法中创建一个长度为2的数组，构建另外的方法，调用方法把数组元素顺序颠倒，把前后两次的数组输出
//定义一个类，叫ParameterTest02
class ParameterTest02 {
	//定义主方法
	public static void main(String[] args) {
		//构建数组
		int[] array = {5,6};
		//把数组通过Arrays工具类里的toString方法把int数组转换为String类型并输出
		String ret = java.util.Arrays.toString(array);
		//格式为java.util.Arrays.toString(实参)，java.包.类.方法(实参);
		System.out.println("调用swap方法前的数组：" + ret);
		//调用swap方法，方法所在的类名.方法(实参);此时array数组已发生改变
		ParameterTest02.swap(array);
		//定义新变量，把已改变的数组转换为String类型并输出
		String result = java.util.Arrays.toString(array);
		System.out.println("调用swap方法后的数组：" + result);
	}
	//定义用于把数组元素顺序颠倒的方法
	static void swap(int[] arr){
		//定义新变量temp，用于暂时存储变量
		int temp = arr[0];
		arr[0] = arr[1];
		arr[1] = temp;
	}
}
/*
小结：引用数据类型，主方法传递实际参数时，先把引用地址复制一份，再把副本传给方法。
由于主方法与被调用的方法操作的是同一块内存空间，假如主方法中变量的值在被调用的方法中被修改，主方法中变量的值也被修改。
*/
