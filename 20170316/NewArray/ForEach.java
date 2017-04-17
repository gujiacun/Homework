//需求：用增强for循环遍历数组元素
//定义一个类，叫ForEach
class ForEach {
	//定义主方法
	public static void main(String[] args) {
		//创建数组
		String[] array = {"On our ","journey to","connect the world"};
		//使用增强for循环，格式为for（数组元素类型 变量名:数组名）{循环体};
		for(String X:array){
			//输出时直接输出变量X，即可输出array数组中的每一个元素
			System.out.print(X + " ");
		}
	}
}
/*
小结：ForEach循环在数组，对象，集合中均有应用。在数组中，它的实质是for循环，主要作用是减少代码量
*/