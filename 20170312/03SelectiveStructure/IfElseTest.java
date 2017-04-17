//需求：操作if-else语句。注意if-else语句与三元运算符的异同
//定义一个类，叫IfElseTest
class IfElseTest {
	//定义主方法
	public static void main(String[] args) {
		//一个网站有125条数据，每页只能显示20条，问要设计多少个页面？
		//解法一：三元运算符
		//总数据
		int allData = 125;
		//每页显示数据
		int eachPage = 20;
		//需要的页数
		int pageAmount = allData / eachPage;
		//假如总数据除以每页显示数据有余数，则需要额外多一页来存储剩下的数据
		pageAmount = allData % eachPage == 0 ? pageAmount : pageAmount + 1;
		//输出结果
		System.out.println(pageAmount);

		//一个网站有639条数据，每页只能显示30条，问要设计多少个页面？
		//解法二：if - else语句
		int totalData = 639;
		int everyPage = 30;
		int amountOfPage = totalData / everyPage;
		int leftAmount = totalData % everyPage;
		if(leftAmount == 0){
			System.out.println(amountOfPage);
		}else{
			System.out.println(amountOfPage + 1);
		}
	}
}
/*
小结：if-else和三元运算符，从语义上二者的含义相同.
从本质上说,if-else是语句结构,三元运算符是一种运算符号.
三元运算符必须有一个结果,表达式必须有结果,必须有返回.而if-else,不能返回什么结果,只能控制语句的结构.
*/