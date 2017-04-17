//需求：求出1至100内第3，6，8个能被3整除的数
//定义类，叫BreakTest
class BreakTest {
	//定义主方法
	public static void main(String[] args) {
		/*
		步骤：用循环语句来循环1至100的整数。
		在上一步的基础上找出所有能被3整除的数。
		定义一个新变量，用来记数，当这个变量等于3，6，8时输出结果
		*/
		//定义一个新变量，用来记数
		int count = 0;
		//用循环语句来循环1至100的整数。
		for(int i = 1;i <= 100;i++){
			//找出所有能被3整除的数,进行下一步的判断
			if(i % 3 == 0){
				count++;
				//当这个变量等于3，6，8时输出结果
				switch(count){
					case 3:
					case 6:
					case 8:
						System.out.println(i);
					//必须要有break来终止当前循环
					break;
				}
			}
		}
	}
}
/*
小结：break表示跳出当前所在的循环。
*/