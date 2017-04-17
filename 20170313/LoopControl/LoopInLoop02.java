//需求：运用嵌套循环，把break;和continue;分别放在里循环和外循环，观察结果，比较异同。
//定义类，叫LoopInLoop02
class LoopInLoop02 {
	//定义主方法
	public static void main(String[] args) {
		//题目：魔王让师徒四人分别从1数到10
		/*步骤：1.有四人，外层循环4次
		2.每人从1数到10，里层循环10次
		*/
		for(int i = 1;i <= 4;i++){
			for(int j = 1;j <= 10;j++){
				if(j == 6){
					break;
				}
				System.out.println(j);
			}
			System.out.println("--------");
		}
		//经实验，break放在里层循环时，当符合判断条件时就会跳出里层循环，但外层循环不受影响

		for(int i1 = 1;i1 <= 4;i1++){
			if(i1 == 3){
				break;
			}
			for(int j1 = 1;j1 <= 10;j1++){
				System.out.println(j1);
			}
			System.out.println("--------");
			//经实验，break放在外层循环时，当符合判断条件时就会跳出外层循环，但里层循环不受影响

			for(int i2 = 1;i2 <= 4;i2++){
				for(int j2 = 1;j2 <= 10;j2++){
					if(j2 == 6){
						continue;
					}
					System.out.println(j2);
				}
				System.out.println("--------");
			}
			//经实验，continue放在里层循环时，当符合判断条件时就会跳出里层循环，但外层循环不受影响
		}
		for(int i3 = 1;i3 <= 4;i3++){
			if(i3 == 3){
				continue;
			}
			for(int j3 = 1;j3 <= 10;j3++){
				System.out.println(j3);
			}
			System.out.println("--------");
		}
		//经实验，continue放在外层循环时，当符合判断条件时就会跳出外层循环，但里层循环不受影响
	}
}
/*
小结：把语句放在里层或外层循环时，要注意该语句的作用范围，到底是跳出哪个循环
*/