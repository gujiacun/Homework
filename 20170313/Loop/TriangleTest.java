//需求：输出三角形，第一行有1个X，然后组行递增，共5行
//声明一个类，叫TriangleTest
class  TriangleTest{
	//声明主方法
	public static void main(String[] args) {
		//方法一：逐行打印
		//第一行
		System.out.println("X");
		//第二行
		System.out.println("XX");
		//第三行
		System.out.println("XXX");
		//第四行
		System.out.println("XXXX");
		//第五行
		System.out.println("XXXXX");
		//方法二：分析，在每行中X的个数与行数相等，以上代码可写为
		//第一行
		int line1 = 1;
		for(int i = 1;i <= line1;i++){
			System.out.print("X");
		}
		System.out.println();
		//第二行
		int line2 = 2;
		for(int i = 1;i <= line2;i++){
			System.out.print("X");
		}
		System.out.println();
		//第三行
		int line3 = 3;
		for(int i = 1;i <= line3;i++){
			System.out.print("X");
		}
		System.out.println();
		//第四行
		int line4 = 4;
		for(int i = 1;i <= line4;i++){
			System.out.print("X");
		}
		System.out.println();
		//第五行
		int line5 = 5;
		for(int i = 1;i <= line5;i++){
			System.out.print("X");
		}
		System.out.println();
		//方法三：在方案二中，我们可以看到line变量在每行中都会递增，应把它作为控制外循环的变量，把上面的for循环看成一个整体
		
		for(int linex = 1;linex <= 5;linex++){
			for(int i = 1;i <= linex;i++){
				System.out.print("X");
			}
			System.out.println();
		}
	}
}
/*
小结：要注意区分System.out.print("X");与System.out.println("X");的区别，一个是在本行内打印，一个是换行打印
*/