//需求：操作选择结构中的if语句
//定义一个类，叫IfTest
class IfTest {
	//定义主方法
	public static void main(String[] args) {
		//比较850与63两个数的大小
		if(850 > 63){
			//假如850 > 63这个条件为真，则执行大括号里面的循环体
			System.out.println("850是最大数");
		}
		//96和10的立方哪个数比较大？
		boolean whether = 96 > Math.pow(10, 3);
		//if语句的条件表达式为boolean类型的表达式，可以为boolean的变量和常量
		if(whether){
			System.out.println("96是最大数");
		}
		//由于下句代码不受上方的if语句的约束，无论上方的条件执行体执行与否，都会输出
		System.out.println("96是最大数");
	}
}
/*
小结：只有当条件表达式为true时，if语句中的条件执行体才会执行，若为false则跳过不执行
*/