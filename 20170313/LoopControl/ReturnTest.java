//需求：求出1至100内前8个不能被3整除的数
//定义类，叫ReturnTest
class ReturnTest {
	//定义主方法
	public static void main(String[] args) {
		/*
		步骤：用循环语句来循环1至100的整数。
		在上一步的循环过程中，找出所有不能被3整除的数。
		定义一个新变量，用来记数，当这个变量等于8时输出结果
		*/
		//定义一个新变量，用来记数
		int count = 0;
		//用循环语句来循环1至100的整数。
		for(int i = 1;i <= 100;i++){
		//在循环过程中，找出所有不能被3整除的数。
			if(i % 3 != 0){
				System.out.println(i);
				//一旦找到，count加1
				count++;
			}
			//当这个变量等于8时输出,结束整个方法
			if(count == 8){
				return;
			}
		}
	}
}
/*
小结：在循环语句中，return表示结束循环所在的方法。
break，return都能结束当前的循环，如果循环以外的语句还要执行，只能用break。
*/