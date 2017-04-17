//需求：操作boolean类型
//定义一个类，叫BooleanTest02
class BooleanTest02 
{
	//定义主方法
	public static void main(String[] args) 
	{
		//boolean类型的数据只有两个值，一个是true，一个是false
		boolean whether1 = true;
		System.out.println(whether1);
		boolean whether2 = false;
		System.out.println(whether2);
		//定义boolean变量的格式：boolean 变量名 = 表达式A 比较运算符 表达式B;
		boolean result = 50 >= 20;
		System.out.println(result);
		//给变量result重新赋值
		result = 50 >= 60;
		System.out.println(result);
	}
}
