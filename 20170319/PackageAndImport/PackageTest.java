//需求：创建一个包，记住package语句要放在文件的第一句，所有代码前面
//同时在命令行中执行编译命令和运行命令，编译：javac -d . 类名.java 。 运行命令：java 包名.类名
//创建包，叫pp，后面一定要加;
package pp;
//创建一个类，叫PackageTest
public class PackageTest {
	//定义主方法，程序入口
	public static void main(String[] args) {
		//输出语句
		System.out.println("Hello World!");
	}
}
/*
小结：记住常见的命令行格式，文件层次为包，类，方法
*/