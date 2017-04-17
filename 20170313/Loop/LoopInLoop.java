//需求：使用嵌套循环，并优化其性能
//定义一个类。叫LoopInLoop
class LoopInLoop {
	//定义主方法
	public static void main(String[] args) {
		//有11个平行世界，不同的世界有同一个人，都在同时从1数到10
		//11个世界，外层循环11次
		for(int i = 1;i <= 11;i++){
			//1个人从1数到10
			for(int j = 1;j <= 10;j++){
				System.out.print(j + "\t");
			}
			//表示换行
			System.out.println();
		}
	}
}
/*
小结：循环不适宜嵌套超过3层，我更习惯先分析外层循环次数，再分析里层循环次数
*/