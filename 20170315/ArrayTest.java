//需求：创建各个数据类型的数组
//定义类
class ArrayTest
{
	//定义主方法
	public static void main(String[] args) 
	{
		//声明各个类型的数组，先不进行初始化
		byte[] b; 
		short[] s;
		int[] i;
		long[] l;
		float[] f;
		double[] d;
		char[] c;
		boolean[] whether;
		String[] str;
		//给以上的数组进行动态初始化
		b = new byte[3];
		//把声明及初始化合成一步
		int[] arr = new int[5];//数组长度是5
		//下面重新创建长度为7的数组，并分配给arr
		arr = new int[7];
	}
}
/*
小结：
*/