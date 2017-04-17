//需求：发送短信功能的设计
//步骤：发送短信是一个功能，由若干代码集合而成，所以应做成一个方法。
//定义一个方法。
//由于发送短信有多种状态，用int类型作返回值类型。
//声明一个类，叫MethodTest01
class MethodTest01 {
	//定义主方法
	public static void main(String[] args) {
		//调用下方的Message方法，向它传递内容，同时定义新变量接收从方法中返回的值
		int result = MethodTest01.Message("10086","How many brothers feel victim to the street?");
		System.out.println(result);
		//调用有返回值的方法时，要在调用者处新定义一个变量来接收返回值，两者数据类型应保持一致
		boolean login = MethodTest01.login("龙傲天","10010");
		System.out.println(login);
	}
	//定义发送短信的方法
	//用户会输入发送电话（long）和内容（String），所以需要两个形式参数
	//方法要给用户返回表示状态的整数。要有返回值
	/*
	0:运营商已经接受
	1:老婆已接受
	2:请重新发送
	*/
	static int Message(String number, String essay){
		String str1 = "10086";
		String str2 = "10010";
		//用equals方法比较方法接受的number变量的值，若为10086，返回0；若为10010，返回1；否则返回2
		if(str1.equals(number)){
			return 0;
		}else if(str2.equals(number)){
			return 1;
		}else{
			return 2;
		}
	}
	//需求：设计登录功能
	//只有两种状态，登陆成功和失败，所以用boolean类型作为方法的返回值类型
	//方法接受账号和密码，所以有两个形式参数
	static boolean login(String name,String password){
		String names = "龙傲天";
		String passwords = "10010";
		//用equals方法和短路与运算判断用户输入的用户名和密码是否与服务器存储的相同
		if(names.equals(name) && passwords.equals(password)){
			//相同则返回true
			return true;
		}else{
			//否则返回false
			return false;
		}
	}
}
/*
小结：在方法内部,使用return关键字，主要有两个作用
1.给调用者返回一个结果值.
2.结束当前方法.这一点与return在循环语句中的作用是一样的

*/