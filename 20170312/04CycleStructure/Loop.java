//需求：死循环和循环语句对比
//声明类
class Loop {
	//声明主方法
	public static void main(String[] args) {
//		while(true){
//			System.out.println("excited!");
//		}
//		do{
//			System.out.println("excited!");
//		}while(true);
		for(;;){
			System.out.println("excited!");
		}
	}
}
/*
小结：若循环变量没有改变二循环条件一直为true，循环条件将一直执行，成为死循环
*/