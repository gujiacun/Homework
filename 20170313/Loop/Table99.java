//需求：输出九九乘法表的前六行
//定义类，叫Table99
class Table99 {
	//定义主方法
	public static void main(String[] args) {
		//方法一：逐行打印
		System.out.println("1 x 1 = 1");
		System.out.println("1 x 2 = 1  2 x 2 = 2");
		System.out.println("1 x 3 = 3  2 x 3 = 6  3 x 3 = 9");
		System.out.println("1 x 4 = 4  2 x 4 = 8  3 x 4 = 12  4 x 4 = 16");
		System.out.println("1 x 5 = 5  2 x 5 = 10 3 x 5 = 15  4 x 5 = 20  5 x 5 = 25");
		System.out.println("1 x 6 = 6  2 x 6 = 12 3 x 6 = 18  4 x 6 = 24  5 x 6 = 30  6 x 6 = 36");
		//方法二：在每行中，等式的个数和行数相等，同时，等式中第二个乘数和行数相等。而且第一个乘数从1开始，以1递增，直到与行数相等
		System.out.println("------分割------");
		//在第1行中，代码可写为
		int line1 = 1;
		//循环次数和行数相等
		for(int i = 1;i <= 1;i++){
			//注意：输出的数据要换行就用println，不换行用print
			System.out.print(i + " x " + line1 + " = " + i * line1 + "\t");
		}
		//同理，在剩下的行中，代码可写为
		//换行
		System.out.println();
		int line2 = 2;
		for(int i = 1;i <= 2;i++){
			System.out.print(i + " x " + line2 + " = " + i * line2 + "\t");
		}
		System.out.println();
		int line3 = 3;
		for(int i = 1;i <= 3;i++){
			System.out.print(i + " x " + line3 + " = " + i * line3 + "\t");
		}
		System.out.println();
		int line4 = 4;
		for(int i = 1;i <= 4;i++){
			System.out.print(i + " x " + line4 + " = " + i * line4 + "\t");
		}
		System.out.println();
		int line5 = 5;
		for(int i = 1;i <= 5;i++){
			System.out.print(i + " x " + line5 + " = " + i * line5 + "\t");
		}
		System.out.println();
		int line6 = 6;
		for(int i = 1;i <= 6;i++){
			System.out.print(i + " x " + line6 + " = " + i * line6 + "\t");
		}
		System.out.println();
		//由于有6行，每行的行数与循环次数都不同，所以应把行数设为一个变量，作为外层循环的变量
		//方法三：使用嵌套循环，设置行数为控制外层循环的变量，第一个乘数为控制内层循环的变量
		for(int linex = 1;linex <= 6;linex++){
			for(int i = 1;i <= linex;i++){
				System.out.print(i + " x " + linex + " = " + i * linex + "\t");
			}
			System.out.println();
		}
	}
}
/*
小结：注意在观察数字时要仔细寻找规律，要选择合适的数字作为变量来控制里层与外层循环
*/