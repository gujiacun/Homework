// 需求：操作内省机制，利用Introspector类操作符合JavaBean规范的类中的属性
//步骤：（1）新建一个类User，符合JavaBean规范
//（2）在Introspector类的静态方法getBeanInfo中传入类的字节码对象，获这个类的BeanInfo类对象（属性类对象）
//（3）通过属性类对象获取javabean属性描述器，由于有多个属性，返回数组。建User类对象
//（4）把javabean属性数组循环，打印出User类中所有属性的名字，所有读取和获得属性的方法
//（5）用反射给name属性赋值，在循环中用if，equals判断，获取name属性的set方法并用Method类对象接收，用invoke调用
package introspector_Test;

import java.beans.BeanInfo;


import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

public class JavaBeanTest {

    public static void main(String[] args) throws Exception {
        User_JavaBeanTest user = new User_JavaBeanTest();
        // 只获取User_JavaBeanTest类的属性，不获取其父类Object类的属性
        BeanInfo beanInfo = Introspector.getBeanInfo(User_JavaBeanTest.class,Object.class);
        // 获得所有属性的数组
        PropertyDescriptor[] array = beanInfo.getPropertyDescriptors();
        // 获取每一个属性
        for (PropertyDescriptor ele : array) {
            // 获取每一个属性的名字
            System.out.println(ele.getName());
            // 获取每一个属性的get方法
            System.out.println(ele.getReadMethod());
            // 获取每一个属性的set方法
            System.out.println(ele.getWriteMethod());
            System.out.println();
            if ("name".equals(ele.getName())) {
                Method way = ele.getWriteMethod();
                way.invoke(user,"江主席");
            }
        }
        System.out.println(user);
    }
/**
 * 小结：内省机制，属于反射内容，特别针对于符合javabean规范的类。即通过类的字节码对象操作类的属性（类里字段的set/get方法）
 */
}
