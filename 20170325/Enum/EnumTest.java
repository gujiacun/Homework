//需求：操作enum，按步骤引出，了解特点，使用常用方法
//定义一个	人,使用一个变量restday来表示他哪一天休息
//方法一：新建类，用int类型表示星期一至日
class Person{
	private int restday;
	public int getRestday(){
		return restday;
	}
	public void setRestday(int restday){
		this.restday = restday;
	}
}
//由于上面的类的业务代码较模糊，类型不安全（int有极多数据，星期只有7个数据）改进为
//专门创建类来存储星期，禁止更改
class Weekday{
	//私有化构造器，防止创建新对象
	private Weekday(){
	}
	//创建7个对象，代表星期所有数据，同时用final修饰，防止被更改
	//用static修饰，可以直接用类名调用
	static final Weekday MONDAY = new Weekday();
	static final Weekday TUESDAY = new Weekday();
	static final Weekday WEDNESDAY = new Weekday();
	static final Weekday THURSDAY = new Weekday();
	static final Weekday FRIDAY = new Weekday();
	static final Weekday SATURDAY = new Weekday();
	static final Weekday SUNDAY = new Weekday();
}
class Person02{
	//只能从类Weekday中输入数据，用private限定访问权限
	private Weekday restday;
	public Weekday getRestday(){
		return restday;
	}
	//Weekday是数据类型
	public void setRestday(Weekday restday){
		this.restday = restday;
	}
}

//中央已经钦定了，就用枚举啦
enum Weekend{
	MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY;
	//定义构造方法
	Weekend(){
	}
	//定义成员变量
	int age = 10;
	//定义普通方法
	public void way(){
		System.out.println("233");
	}

}
class Person03{
	//只能从类Weekend中输入数据，用private限定访问权限
	private Weekend restday;
	public Weekend getRestday(){
		return restday;
	}
	//Weekday是数据类型
	public void setRestday(Weekend restday){
		this.restday = restday;
	}
}
//创建测试类
public class EnumTest {
	//建主方法
	public static void main(String[] args) {
		//创建对象，输入数据
		Person p = new Person();
		p.setRestday(3);
		int result = p.getRestday();
		System.out.println(result);
		Person02 pp = new Person02();
		//由于星期在类Weekday中是对象，所以要用类名调用
		pp.setRestday(Weekday.TUESDAY);
		//无法实例化枚举类型
		//Weekend w = new Weekend();
		//w.way();
		//由于枚举中都是全局公共静态常量，可以用类名调用
		System.out.println(Weekend.MONDAY);
		//调用Enum类中的方法
		//返回枚举对象的常量名称
		System.out.println(Weekend.MONDAY.name());
		//返回枚举对象的序号,从0开始.
		System.out.println(Weekend.SUNDAY.ordinal());
		//返回枚举对象的常量名称
		System.out.println(Weekend.SUNDAY.toString());
		//把一个指定名称字符串转换为当前枚举类中同名的常量
		Weekend day = Weekend.valueOf("SUNDAY");
		//返回当前枚举类型所有的常量,使用一个数组封装起来
		Weekend[] array = Weekend.values();
		//用for each 循环打印数组元素
		for(Weekend x : array){
			System.out.print(x);
			System.out.print(" , ");
		}
	}
}
/*
小结：枚举是多个固定的常量对象的集合，由public static final 修饰的对象
*/