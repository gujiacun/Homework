//需求：求出1至100内第3，6，8个不能被3整除的数
//定义类，叫ContinueTest
class ContinueTest{
	//定义主方法
	public static void main(String[] args) {
		/*
		步骤：用循环语句来循环1至100的整数。
		在上一步的循环过程中，碰到能被3整除的数就跳过。
		定义一个新变量，用来记数，当这个变量等于3，6，8时输出结果
		*/
		//定义一个新变量，用来记数
		int count = 0;
		//用循环语句来循环1至100的整数。
		for(int i = 1;i <= 100;i++){
			//在循环过程中，碰到能被3整除的数就跳过
			if(i % 3 == 0){
				continue;
			}
			//在循环过程中，碰到不能被3整除的数,count就加1
			count++;
			//当count等于3，6，8时输出结果
			switch(count){
				case 3:
				case 6:
				case 8:
					System.out.println(i);
			}
		}
	}
}
/*
小结：在循环语句中，continue表示让程序跳过当前的情况，立刻跳转到下一次的循环。
在for循环中，continue使程序立刻调转到更新语句中。
*/