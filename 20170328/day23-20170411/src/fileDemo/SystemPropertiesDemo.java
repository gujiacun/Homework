//需求：操作System类中的getProperties() 方法，获取当前系统属性；
//把上一步获得的Properties的对象输出。再 获取指定键指示的系统属性。
package fileDemo;

import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class SystemPropertiesDemo {

    public static void main(String[] args) {
        // 获取当前系统所有属性，返回的是Properties类的对象，key和value都是String类型
        Properties pros = System.getProperties();
        // 由于Properties类继承自HashTable，实现了Map接口，可以用entrySet方法
        // 再把键值对用Set封装
        Set<java.util.Map.Entry<Object, Object>> entry = pros.entrySet();
        // 用for-each迭代输出
        for (Entry<Object, Object> entry2 : entry) {
            //获取一大堆属性
            System.out.println(entry2.getKey() + ">>>>>>" + entry2.getValue());
        }
        System.out.println("-----------");
        //getProperty,返回特定键指定的系统属性
        String ret = System.getProperty("java.vm.version");
        System.out.println(ret);
    }
}
/**
 * 小结：善用IDE自动补全，记住各个实现类之间的关系
 */
