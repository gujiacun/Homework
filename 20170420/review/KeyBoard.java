package review;
//键盘类，实现 IUSB接口，重写swapData方法
public class KeyBoard implements IUSB{
	
	public void swapData(){
		System.out.println("键盘在狂抽...");
	}
}
