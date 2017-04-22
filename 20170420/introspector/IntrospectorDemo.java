package introspector;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

//演示javabean内省机制
public class IntrospectorDemo {

	public static void main(String[] args) throws Exception {
		
		//在 Java Bean 上进行内省，了解其所有属性、公开的方法和事件，User.class是javabean字节码对象
		BeanInfo bean = Introspector.getBeanInfo(User.class);
		//获取bean里面所有属性,用数组来接收
		PropertyDescriptor[] pds = bean.getPropertyDescriptors();
		//创建User对象
		User user = User.class.newInstance();
		
		for(PropertyDescriptor pd : pds){
			System.out.println("属性名:" + pd.getName());
			System.out.println("属性读的方法" + pd.getReadMethod());
			System.out.println("属性写的方法" + pd.getWriteMethod());
			
			//给name属性赋值
			if("name".equals(pd.getName())){
				//获取写入属性的方法对象
				Method method = pd.getWriteMethod();
				//调用方法，发送数据赋值
				method.invoke(user,"小黄");
			}
		}
		System.out.println(user.getName());		
	}
}
/*
 *	小结:内省机制使用Introspector类，有该类里的getBeanInfo()来进行内省，扫描对象里面的所有属性
 *		BeanInfo bean = Introspector.getBeanInfo(User.class); 进行User类里属性扫描
 *		然后通过getPropertyDescriptors()方法来获取类里的所有的属性，用该PropertyDescriptor类型
 *		数组来接收所有的属性。然后遍历，属性名: pd.getName()	属性读的方法：pd.getReadMethod()
 *		属性写的方法: pd.getWriteMethod()
 */
