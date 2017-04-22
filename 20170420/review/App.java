package review;
//测试类
public class App {

	public static void main(String[] args) {
		// 创建主板，键盘，鼠标的对象
		MotherBorad mother = new MotherBorad();
		KeyBoard keyboard = new KeyBoard();
		Mouse mouse = new Mouse();
		// 通过主板对象调用插入方法
		mother.install("keyboard", keyboard);
		mother.install("mouse", mouse);
		// 通过主板对象调用工作方法
		mother.doWork();
	}

}
