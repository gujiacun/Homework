//需求：复习操作方法的定义格式和调用格式
//定义一个类，叫MethodTest
class MethodTest {
	//定义主方法
	public static void main(String[] args) {
		/*方法的定义格式：
		修饰符 返回值的类型 方法名(参数类型 参数名){
			方法体
			return 返回值；（如果方法有返回，方法体包含这句）
		}
		修饰符，形式参数和return 返回值;可以视情况省略。
		有返回值，要填返回值的类型。无返回值，填void。
		*/
		//方法的调用格式：方法所在的类名.方法名(参数);
		MethodTest.print();
		//调用有返回值的方法时，要在调用者处新定义一个变量来接收返回值，两者数据类型应保持一致
		String sen = MethodTest.sentence();
		System.out.print(sen);
		MethodTest.number("您一个上海人，怎么就到北京当主席了呢？");
		double finalResult = MethodTest.result(900);
		System.out.print(finalResult);
	}
	//无参数无返回的方法
	//需求：定义一个方法，只要一调用就打印"闷声发大财"这句话
	//方法必须定义在主方法外
	static void print(){
		System.out.println("闷声发大财");
	}
	//无参数有返回
	//返回一个句子
	static String sentence(){
		return "你们香港记者就是有一个好，一有什么事，跑得比谁都快";
	}
	//有参数无返回
	static void number(String a){
		//由于被void修饰，无返回值，所以下句没法打印
		System.out.println("苟利国家生死以，其因祸福避趋之");
	}
	//有参数有返回
	static double result(double a){
		double c = Math.sqrt(a);
		return c;
	}
}
/*
小结：定义方法时，根据实际情况来选择用什么修饰符或要不要省略。
假如在方法结束时，如果不需要给调用者返回结果数据,此时使用void(无返回)修饰.
如果需要返回一个结果数据,我们就把该结果数据的类型作为该方法的返回值类型.
同时，一个方法只能返回一个结果。
假如在完成方法时需要用到未知的数，需要形式参数。
*/