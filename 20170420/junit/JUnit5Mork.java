// 需求：自行实现junit的单元测试功能
// 步骤：（1）先新建测试类，里面建需要被测试的方法，在之前和之后的方法
//（2）新建注解，MyAfter，MyTest，MyBefter  
//（3）获取测试类EmployeeDaoTest所有的方法,先获取测试类的字节码对象
//（4）创建三个集合来接收三种类型注解方法
//（5）foreach循环得到测试类中每个方法，分类：假如这个方法被MyBefore/MyAfter/MyTest修饰，就被添加到相应的list集合中
//（6）把方法按照测试前，测试，测试后的顺序输出

package junit;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
//第三方程序赋予注解特殊功能
public class JUnit5Mork {
	
	public static void main(String[] args) throws Exception {
		//获取字节码对象
		Class<EmployeeDaoTest> clz = EmployeeDaoTest.class;
		
		//获取所有的方法
		Method[] m  = clz.getDeclaredMethods();
		//创建三个集合来接收三种类型注解方法
		List<Method> beforeList = new ArrayList<>();
		List<Method> afterList = new ArrayList<>();
		List<Method> testList = new ArrayList<>();
		//foreach循环得到测试类中每个方法，分类
		for(Method ele : m){
			//假如这个方法被MyBefore/MyAfter/MyTest修饰，就被添加到相应的list集合中
			if(ele.isAnnotationPresent(MyBefore.class)){
				beforeList.add(ele);
			}else if(ele.isAnnotationPresent(MyAfter.class)){
				afterList.add(ele);
			}else if(ele.isAnnotationPresent(MyTest.class)){
				testList.add(ele);
			}
		}
		//创建测试类对象
		Object obj = clz.newInstance();
		//进行方法的顺序输出
		for(Method ele : testList){
			for(Method b : beforeList){
				b.invoke(obj);
			}
			ele.invoke(obj);
			for(Method a : afterList){
				a.invoke(obj);
			}
			
		}
	}
}
	/**
	 * 小结：遇到复杂问题要一步一步进行推导，分析这个问题涉及哪些方面内容，要记住一个类中有哪些方法，这些方法各有什么作用
	 */