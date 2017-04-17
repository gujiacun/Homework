//需求：操作switch语句
//定义类，叫SwitchTest
class SwitchTest {
	//定义主方法
	public static void main(String[] args) {
		//switch支持判断string类型，先定义一个string的变量
		String answer = "很惭愧，做了一点微小的贡献";
		//括号内的一般是整型表达式，也可以是变量
		switch(answer){
			//case语句中的空格和冒号绝对不能忘
			case "excited":
				System.out.println("亦可赛艇");
				break;
			//如果表达式的值等于case语句里的常量，则执行该代码块
			case "董先生连任支不支持":
				System.out.println("我就明确地告诉你们一点，我说资茨");
				break;
				//当表达式的值与以上的常量都不相等时，执行本行代码
			default:
				System.out.println("年轻人还是要提高自己的姿势水平，识得唔识得？");
		}
	}
}
/*
小结：switch语句本质上只支持int类型，但现在也支持string类型，编程一大特点就是非常容易做实验来证明自己的想法是否正确。
同时也要勇于尝试新东西。
*/