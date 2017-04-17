//需求：操作所有的逻辑运算符
//声明一个类，叫LogicalOperator
class LogicalOperator {
	//声明主方法
	public static void main(String[] args) {
		//长路与运算,有0为0，全1为1
		System.out.println(5 > 3 & 1 > 6);
		//长路或运算,有1为1，全0为0
		System.out.println(5 > 3 | 1 > 6);
		//非运算,true & false结果为false，加上非运算，变为true
		System.out.println(!(true & false));
		//异或运算，相同为0，不同为1
		System.out.println(true ^ false);
		//短路与运算,有0为0，全1为1，假如运算符左侧的表达式结果为false，停止运算
		//System.out.println(5 > 3 && 5 / 0 == 1);
		System.out.println(5 < 3 && 5 / 0 == 1);
		//短路或运算，有1为1，全0为0，假如运算符左侧的表达式结果为true，停止运算
		System.out.println(5 > 3 || 5 / 0 == 1);
	}
}
/*
小结：逻辑运算符的左右是boolean表达式或boolean常量，位运算符左右是数字
*/