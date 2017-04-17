//需求：判断一个点和圆的关系(在圆外,圆周上,圆内).
//分析：圆的半径为5，圆心坐标为(3,2),点A坐标为(6,8),要比较点A与圆心的距离与圆半径的大小关系
//分别创建一个点类和圆类，从主方法中输入数据到点对象中，再把点对象输入到圆对象中，判断
//创建点类
class Point{
	//创建字段，表示横，纵坐标，要符合javabean规范
	private int x;
	private int y;
	public Point(int x,int y){
		this.x = x;
		this.y = y;
	}
	//用set/get方法访问私有字段
	public int getX(){
		return x;
	}
	public void setX(int x){
		//this修饰的x表示当前调用这方法的对象，把局部变量x传给字段x
		this.x = x;
	}
	//用set/get方法访问私有字段
	public int getY(){
		return y;
	}
	public void setY(int y){
		//this修饰的x表示当前调用这方法的对象，把局部变量x传给字段x
		this.y = y;
	}
}
//创建圆类
class Circle{
	//创建字段，表示横，纵坐标，要符合javabean规范
	private int x0;
	private int y0;
	public Circle(int x,int y){
		this.x0 = x;
		this.y0 = y;
	}
	//创建字段，表示点A与圆心的距离，据此与圆半径比较
	public int distance;
	public int r = 5;
	//用set/get方法访问私有字段
	public int getX0(){
		return x0;
	}
	public void setX0(int x0){
		//this修饰的x表示当前调用这方法的对象，把局部变量x传给字段x
		this.x0 = x0;
	}
	//用set/get方法访问私有字段
	public int getY0(){
		return y0;
	}
	public void setY0(int y0){
		//this修饰的x表示当前调用这方法的对象，把局部变量x传给字段x
		this.y0 = y0;
	}
	//创建方法，计算点A与圆心的距离
	public double calculate(Point p){
		//注意括号
		double distance = Math.sqrt(Math.pow(p.getX() - x0,2) + Math.pow(p.getY() - y0,2));
		return distance;
	}
	//用if-else if-else结构输出结果，1表示点在圆内，0表示圆上，-1表示圆外
	public int judge(){
		if(r > distance){
			return 1;
		}else if (r < distance){
			return -1;
		}else{
			return 0;
		}
	}
}
//创建测试类
public class PointTest {
	//主方法，程序入口
	public static void main(String[] args) {
		//通过创建点类的对象输入数据,点A坐标为(6,8)
		Point p = new Point(6,8);
		//通过创建圆类的对象输入数据,圆心坐标为(3,2)
		Circle c = new Circle(3,2);
		//调用圆类的方法计算点A与圆心的距离
		double dis = c.calculate(p);
		//调用judge方法，判断圆心与点A的距离，创建变量接受结果
		int result = c.judge();
		//输出结果
		System.out.println(result);
	}
}
/*
小结：真复杂。。。要学会把需求细化，转换为具体思路，自顶向下设计，每次只进行平级思考，
自下向上实现
每次创建对象就是在调用构造方法，所以在创建对象就输入数据时，要手动在类中创建构造方法
*/