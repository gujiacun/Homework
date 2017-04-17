//需求：操作比较运算符
//声明一个类，叫ComparisonOperator
class ComparisonOperator {
	//声明一个主方法
	public static void main(String[] args) {
		//比较两个数的大小，先声明及定义两个变量，再用">"比较
		int i1 = 65;
		int i2 = 64;
		//判断表达式为i1 > i2，结果为boolean类型，假如为true，执行第一个条件执行体，假如为false，执行else{}里面的条件执行体
		if(i1 > i2){
			//条件为true，执行此句
			System.out.println("最大值为： " + i1);
		}else{
			//条件为true，不执行此句
			System.out.println("最大值为： " + i2);
		}
		//上面代码也可写为如下，判断i1 < i2是否为真命题
		boolean whichbigger = i1 < i2;
		//输出结果
		System.out.println(whichbigger);
		//"="表示赋值,"=="才是真正的等号，表示比较是否相等，判断i1是否等于i2
		boolean whether = i1 == i2;
		System.out.println(whether);
		//判断3不等于4是否为真命题
		System.out.println(3 != 4);
		//注意：boolean类型的表达式可以直接放在打印语句中，也可以先把它赋值给boolean类型的变量
		System.out.println(3 >= 4);
	}
}
/*
小结：比较运算符的左右两侧，既可以是变量，常量，也可以是表达式
*/