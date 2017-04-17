//需求：用for语句打印从1到10所有能被3整除的数
//定义一个类
class ForTest{
	//定义主方法
	public static void main(String[] args) {
		//从1开始，到10结束，每次增加1
		for(int i = 1;i <= 10;i ++){
			//出现能被3整除的数就打印
			if (i % 3 == 0){
			 System.out.println(i);
			}
		}
	}
}
/*
小结：循环的自增可能是增加1，也可能是任意数
*/