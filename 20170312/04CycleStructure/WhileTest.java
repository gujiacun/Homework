//需求：操作while语句
//定义一个类，叫WhileTest
class WhileTest {
	//定义主方法
	public static void main(String[] args) {
		//求1到50的和
		//定义加数最初的值
		int num = 1;
		//定义结果
		int result = 0;
		//由于1到50的整数全部加上，所以需要循环50次，当加数为50时，是最后一次循环
		while (num <= 50){
			//结果加上加数
			result += num;
			//加数逐渐递增
			num ++;
		}
		//结束循环，输出结果
		System.out.println(result);
	}
}
/*
小结：循环体里必须有修改循环变量的部分，否则当符合判断条件时，会变为死循环
*/