//需求：溢出现象
//定义一个类，名叫OutOfBounds
class OutOfBounds 
{
	//定义一个主方法
	public static void main(String[] args) 
	{
		//输出long类型的最大值
		System.out.println(Long.MAX_VALUE);
		//输出一个数，比long类型最大值大1
		System.out.println(Long.MAX_VALUE + 1);
		//输出了long类型最小值，因为上句代码的输出值已经超过long类型的范围
	}
}
/*
小结：虽然平时很少用到比long最大值还大的数，但我们仍需注意byte，short，int的边界值
*/