// 需求：javabean与Map的互相转换，javabean有属性和值，map由key和value
//先建工具类BeanUtil，建两方法用于互相转换
//1.javabean转换为Map
//步骤：（1）新建javabean的类Person，建字段name，id，age
//（2）建Map对象，获得jb的描述信息包装对象，拿属性描述器，for-e循环，拿到属性名和属性get方法的Method对象，调用invoke方法，map.put
//2.Map转换为javabean
//步骤：（1）在工具类的方法中，传入map对象和Class对象，因为Class对象一会要操作，使用泛型，返回相同的泛型
//（2）javabean中已经有了属性，缺的是属性值，由map传入它的value
//（3）获取javabean的描述信息包装对象，通过此获取属性描述器的数组，用foreach循环得到每个属性描述器
//（4）由于Map的key就是javabean的属性，Map的value就是javabean的属性值，本质是用set方法把Map的value赋给javabean的属性值
//（5）在循环中，用属性描述器得到属性名称并外部存储为string，同时用属性描述器得到获得属性的set方法，调用invoke，填入map.get(key)
package javabeanAndMap;

import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Map;


public class JavaBeanAndMap {

    public static void main(String[] args) throws Exception {
        // 建对象，调用方法
        Person someone = new Person(33L, 23, "shiki");
        Map<String, Object> map = BeanUtil.bean2Map(someone);
        System.out.println(map);
        System.out.println("==================================");
        Map<String, Object> map02 = new HashMap<>();
        map02.put("id",29L);
        map02.put("name","wei");
        map02.put("age",23);
      
        Person obj = BeanUtil.map2Bean(map02,Person.class);
        System.out.println(obj);
    }

}
/**
 * 小结：一定要抓住Map和javabean的相识点，map的key相当于javabean的属性，map的value相当于javabean的属性值
 * 两个互换，就是通过反射获取字节码对象，据此获得BeanInfo对象，据此获得PropertyDescriptor[]，以数组每个元素
 * 得到javabean类中每个属性的名称和set/get方法，把方法invoke，在进行下一步
 */

