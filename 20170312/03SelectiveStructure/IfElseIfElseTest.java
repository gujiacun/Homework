//需求：操作if - else if -else
//定义一个类，叫IfElseIfElseTest
class IfElseIfElseTest {
	//定义一个主方法
	public static void main(String[] args) {
		/*小明考试，语文得了78分，数学得了88分，英语得了911分，哪科他得了最高分？
		分析：使用短路与运算符号，用语文分数去和数学和英语分数比较，结果为true即语文是最高分。
		若结果为false，即语文不是最高分，此时只需比较剩下的两科分数，更大的就是最高分
		*/
		int chinese = 78;
		int math = 88;
		int english = 91;
		if(chinese >= math && chinese >= english){
			System.out.println("语文是最高分，分数为：" + chinese);
		}else if(math >= english){
			System.out.println("数学是最高分，分数为：" + math);
		}else{
			System.out.println("英语是最高分，分数为：" + english);
		}
	}
}
/*
小结：若条件表达式1为true，执行条件执行体1，执行完后便离开if语句，不再管if语句里面的语句。
若为false，先判断else if里的条件表达式2，再根据结果决定是否执行语句。else语句意为当以上的所有表达式均为false时，所要执行的代码块。可以省略
*/