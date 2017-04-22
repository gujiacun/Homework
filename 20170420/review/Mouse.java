package review;
//鼠标类，实现 IUSB接口，重写swapData方法
public class Mouse implements IUSB{

	public void swapData(){
		System.out.println("鼠标在狂舞....");
	}
}
