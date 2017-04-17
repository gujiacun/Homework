//需求：操作三元运算符。一个网站有1，065条数据，每页只能显示20条，问应该设置多少页。
//声明一个类，叫Page
class Page 
{
	//声明主方法
	public static void main(String[] args) 
	{
		//声明，定义网站的总数据
		int totalData = 1065;
		//声明，定义网站每页能显示的数据
		int eachPage = 20;
		//声明，定义网站的总页数
		int totalPage = totalData / eachPage;
		//运用三目运算符，假如总数据除以每页数据有余数，剩下的数据要再新增加一页来显示，如果能整除，则返回结果
		totalPage = totalData % eachPage != 0 ? totalPage + 1 : totalPage;
		//打印结果
		System.out.println(totalPage);
	}
}
/*
小结：X ? Y : Z  ,X为boolean类型表达式，若为true，返回Y，为false，返回Z。Y和Z和赋值符号左边的变量要保持类型一致
*/