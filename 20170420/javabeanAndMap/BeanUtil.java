package javabeanAndMap;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class BeanUtil {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    // javabean转换为Map
    // （1）新建javabean的类Person，建字段name，id，age
    // （2）建Map对象，获得jb的描述信息包装对象，拿属性描述器，for-e循环，拿到属性名和属性get方法的Method对象，调用invoke方法，map.put
    public static Map<String, Object> bean2Map(Object obj) throws Exception {
        Map<String, Object> map = new HashMap<>();
        // 获取传进来的Person类对象的所在类的所有属性包装对象
        BeanInfo info = Introspector.getBeanInfo(obj.getClass(), Object.class);
        PropertyDescriptor[] array = info.getPropertyDescriptors();
        for (PropertyDescriptor ele : array) {
            String name = ele.getName();
            Method getWay = ele.getReadMethod();
            // invoke调用的相当于jb中的get方法，得到类中的值
            Object object = getWay.invoke(obj);
            map.put(name, object);
        }
        return map;
    }

    // Map转换为javabean
    // （1）在工具类的方法中，传入map对象和Class对象，因为Class对象一会要操作，使用泛型，返回相同的泛型
    // （2）javabean中已经有了属性，缺的是属性值，由map传入它的value
    // （3）获取javabean的描述信息包装对象，通过此获取属性描述器的数组，用foreach循环得到每个属性描述器
    // （4）由于Map的key就是javabean的属性，Map的value就是javabean的属性值，本质是用set方法把Map的value赋给javabean的属性值
    // （5）在循环中，用属性描述器得到属性名称并外部存储为string，同时用属性描述器得到获得属性的set方法，调用invoke，填入map.get(key)
    public static <T> T map2Bean(Map<String, Object> map02, Class<T> clz) throws Exception {
        BeanInfo beanInfo = Introspector.getBeanInfo(clz,Object.class);
        PropertyDescriptor[] array = beanInfo.getPropertyDescriptors();
        T obj = clz.newInstance();
        // 循环中的每个元素都是描述器
        for (PropertyDescriptor propertyDescriptor : array) {
            // 得到javabean类中每个属性的名称，等价于Map中的key
            String name =propertyDescriptor.getName();
            // 得到javabean类中每个属性的set方法
            Method setWay = propertyDescriptor.getWriteMethod();
            // obj是字节码文件的对象，map02.get(name)是set方法的参数
            setWay.invoke(obj, map02.get(name));
        }
        return obj;
    }
}
/**
 * 小结：一定要抓住Map和javabean的相识点，map的key相当于javabean的属性，map的value相当于javabean的属性值
 */
