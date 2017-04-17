//需求：用do - while按顺序打印大写字母A到Z
//定义一个类，叫DoWhileTest
class DoWhileTest {
	//定义主方法
	public static void main(String[] args) {
		//初始化变量值alphabet，输入第一个打印的元素A
		char alphabet = 'A';
		do{
			//输出第一个元素A
			System.out.println(alphabet);
			//变量自增1，由于char类型在底层是存储为int类型，所以把它当作一个整型变量
			alphabet ++;
			//循环控制条件，当变量等于时，执行最后一次循环，返回打印语句
		}while (alphabet <= 'Z');
	}
}
/*

小结：char类型在底层是存储为int类型，所以char类型变量可以执行自增自减
*/