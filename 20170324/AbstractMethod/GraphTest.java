//需求：由图形求面积引出抽象类和抽象方法
//分析：由于圆，矩形，三角形的求面积公式不同，所以他们的父类的方法最好用抽象方法
//创建抽象类父类
abstract class Graph{
	//创建抽象方法，在子类中重写
	abstract public double getArea();
}
//创建圆类,要重写父类方法
class Circle extends Graph{
	//求圆的面积时，需要半径
	private double r;
	//由于不能直接在调用方法时输入数据，要通过构造方法在建对象时输入数据
	Circle(double r){
		//把输入的形式参数的值赋给字段
		this.r = r;
	}
	//由于要重写父类方法，所以参数列表与父类方法一致
	public double getArea(){
		return Math.PI * Math.pow(r,2);
	}
}
//创建矩形类
class Rectangle extends Graph{
	//求矩形的面积时，需要长和宽
	public double width;
	public double length;
	//另一种是创建无参构造方法，创造对象后再给字段赋值，再通过对象调用方法
	Rectangle(){
		//this.width = width;
		//this.length = length;
		
	}
	//由于要重写父类方法，所以参数列表与父类方法一致
	public double getArea(){
		return width * length;
	}
}
//创建三角形类
class Triangle extends Graph{
	//求三角形面积，需知道它三边分别的长度
	private double a;
	private double b;
	private double c;
	private double p = a + b + c;
	Triangle(double a,double b,double c){
		this.a = a;
		this.b = b;
		this.c = c;
	}
	//由于要重写父类方法，所以参数列表与父类方法一致
	public double getArea(){
		return Math.sqrt(p * (p - a) * (p - b) * (p - c));
	}
}
//创建类，叫GraphTest
public class GraphTest {
	//创建主方法
	public static void main(String[] args) {
		//创建图形类的对象，调用带参构造方法，调用getArea()方法求出面积
		Circle c = new Circle(6.3);
		double areaCircle = c.getArea();
		System.out.println(areaCircle);
		//用无参构造方法创建图形类的对象
		Rectangle e = new Rectangle();
		//通过对象给字段赋值
		e.width = 3;
		e.length = 5;
		//调用求面积方法，输出结果
		System.out.println(e.getArea());
	}
}
/*
小结：在子类中重写父类的抽象方法时，子类方法的参数列表要与父类的一致
当创建的对象与输入的数据有关，考虑手动建个带参构造方法
*/