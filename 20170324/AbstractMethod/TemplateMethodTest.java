//需求：理解模板方法设计模式
//新建抽象父类，提供一个子类的通用方法，并把其中某个步骤留给子类实施
abstract class Father{
	//建算法骨架，先建方法
	public long getTime(){
		//记录开始时间
		long startTime = System.currentTimeMills();
		//程序运行，此处留给不同子类实现
		this.method();
		//记录结束时间
		long endTime = System.currentTimeMills();
		//计算总时间
		long totalTime = endTime - startTime;
		return totalTime;
	}
	//用abstract修饰，无方法体，留给子类实现
	abstract void method();
}
//建一个子类，String连接10,000次
class Son01 extends Father{
	public void method(){
		for(int i = 0;i < 10000;i++){
			String str = i + "";
		}
	}
}
//建一个子类，计算0到10,000整数之和
class Son02 extends Father{
	public void method(){
		for(int i = 0;i <= 10000;i++){
			long result = 0 + i;
		}
	}
}
//建类，叫TemplateMethodTest
public class TemplateMethodTest {
	//新建主方法
	public static void main(String[] args) {
		Son02 s = new Son02();
		s.getTime();
		System.out.println("Hello World!");
	}
}
