//需求：执行switch语句中，如果有几种情况对应的是一种处理的代码，代码省略
//定义类，叫SwitchTest02
class SwitchTest02 {
	//定义主方法
	public static void main(String[] args) {
		//星期一至五为工作日，星期六至日为休息日
		int weekday = 5;
		switch(weekday){
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
				System.out.println("今天是工作日");
				//一定要记得在case代码块里写break
				break;
			case 6:
			case 7:
				System.out.println("今天是休息日");
				break;
			//注意："default"与":"之间有一个空格
			default :
				System.out.println("请重新输入");
		}
	}
}
/*
小结：写代码时要注意格式，空格不能省略，写时要注意输入法的切换。
*/