//需求：实验在case后不加上break语句的后果
//定义类
class SwitchTest03 
{
	//定义主方法
	public static void main(String[] args) 
	{
		//小明考了60分，想知道系统如何自动评价他的成绩
		//初始化值
		int score = 60;
		//switch语句的判断条件是整数表达式是否等于某个int类型的值。
		switch (score){
		//不加break，switch里的所有代码都将执行
			case 60:
				System.out.println("合格");
			case 70:
				System.out.println("不错");
			case 80:
				System.out.println("良好");
			case 90:
				System.out.println("优秀");
		}
	}
}
/*
小结：break用在switch语句中，用来跳出这个语句块。
*/