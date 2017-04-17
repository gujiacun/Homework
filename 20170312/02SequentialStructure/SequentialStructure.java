//需求：复习最常见的程序的顺序结构
//定义类文件，叫SequentialStructure
class SequentialStructure {
	//定义主方法
	public static void main(String[] args) {
		//定义boolean类型变量whether
		boolean whether = Integer.MAX_VALUE > Short.MAX_VALUE;
		System.out.println(whether);
		////定义int类型变量num，程序由上往下执行
		int num = 'B' + 'a';
		System.out.println(num);
	}
}
/*
小结：如果代码里没有流程控制，程序是按照书写的格式从上而下一行一行执行的，
一条语句执行完之后继续执行下一条语句，中间没有判断和跳转，直到程序的结束。
*/