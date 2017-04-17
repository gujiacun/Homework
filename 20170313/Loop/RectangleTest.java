//需求：使用循环结构输出由X构成的矩形，一行6个，4行
//定义一个类，叫RectangleTest
/*
步骤：要输出4行，把它作为外层循环的循环次数
一行输出6个X，作为里层循环的循环次数
*/
class RectangleTest {
	//定义主方法
	public static void main(String[] args) {
		//方法一：直接使用输出语句逐行打印
		System.out.println("XXXXXX");
		//一行6个，一共4行输出语句
		System.out.println("XXXXXX");
		System.out.println("XXXXXX");
		System.out.println("XXXXXX");
		//输出分割线
		System.out.println("--------");

		//方法二：既然有4行，可以把它作为外层循环的循环次数
		for (int j = 1;j <=4 ;j++ ){
			//一行输出6个X
			System.out.println("XXXXXX");
		}
		System.out.println("--------");

		//方法三:使用嵌套循环
		//定义一个for循环，为外层循环，循环次数为4
		for(int line = 1;line <= 4;line++){
			//定义一个for循环，为里层循环，循环次数为6
			for(int i = 1;i <= 6;i++){
				//输出X
				System.out.print("X");
			}
			//换行
			System.out.println();
		}
	}
}
/*
小结：编程时要先分析下需求，再想出思路，想出步骤，最后才是写代码。
思路很重要，要锻炼出互相紧扣的思路链，逐渐改进代码，使它更简洁易懂，易于维护。
*/