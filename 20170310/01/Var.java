//需求：掌握声明，定义变量的格式，不要犯低级错误
//声明一个类，叫Var
class Var 
{
	//声明主方法
	public static void main(String[] args) 
	{
		//声明变量格式  type variableName;
		int num;
		//给变量赋予初始值  variableName = constant;
		num = 16;
		//打印该变量
		System.out.println(num);
		//在声明变量的时候,并做初始化
		byte b = 5;
		//打印该变量
		System.out.println(b);
		//char类型变量初始值化时，字面量要用单引号包围
		char alphabet = '欅';
		//打印该字符
		System.out.println(alphabet);
	}
}
/*
小结：变量在声明后，必须初始化(赋值)之后才能使用,初始化才是真正的在内存分配空间给变量
*/