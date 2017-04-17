//需求：一个小组有3名学生，判断学生是否交了学费，若没有则交学费
//步骤：先定义一个类，存放学生的状态，包含名字，是否交了学费。
//类中要有方法，当学生没有交学费时，便调用该方法，用判断语句来判断
//有复数名学生，执行的是同一项操作，重复操作用循环结构
//如果有1，000名学生，便要在主方法中调用1，000次，用数组把学生对象做成数组
//定义类文件。存放学生的字段和方法
class Student{
	String name;
	//只有交了学费与没交学费两种状态，因此用boolean类型作为字段的数据类型
	boolean isFee;
	//定义方法，当学生没交学费时才调用
	void fees(){
		isFee = true;
		System.out.println("该学生未交学费，现已交付");
	}
}
//定义类文件
class StudentTest {
	//定义主方法，程序的入口
	public static void main(String[] args) {
		//先创建三个学生对象，并为他们赋值
		Student s1 = new Student();
		s1.name = "小李";
		s1.isFee = true;
		Student s2 = new Student();
		s2.name = "小王";
		s2.isFee = false;
		Student s3 = new Student();
		s3.name = "小何";
		s3.isFee = false;
		//创建数组，把以上三个对象组成数组，引用数据类型的数据也可以组合成数组
		Student[] array = new Student[]{s1,s2,s3};
		//使用for循环执行重复操作
		for(int i = 0;i < array.length;i++){
			//判断对象的属性是否为false，是就调用方法
			if(!array[i].isFee){
				array[i].fees();
			}
		}
	}
}
/*
小结：要牢记每个语法知识点的作用，但碰到需求时要学会把需求转换为对应的代码。
要调用类中的非static修饰的字段或方法，要创建该类的对象再调用
*/