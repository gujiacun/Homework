//需求：操作Properties的一些方法，但与IO有关部分迟点再操作
package mapDemo;

import java.util.Properties;
import java.util.Set;

public class PropertiesDemo {
    //主方法
    public static void main(String[] args) {
        //新建对象及添加元素
        Properties p = new Properties();
        //注意，此类是Map接口的实现类，其中的key和value都只能是String类型
        p.put("1", "linux内核原码");
        //调用 Hashtable 的方法 put
        p.put("2", "图形学");
        p.put("3", "编译原理");
        //setProperty,加入元素
        p.setProperty("4", "程序员三大浪漫");
        //用指定的键在此属性列表中搜索属性
        System.out.println(p.getProperty("4"));
        //返回此属性列表中的键集，返回值是Set<String>
        Set<String> result = p.stringPropertyNames();
        System.out.println(result);
    }
}
/**
 * 小结：Properties本身继承了HashTable的方法，自身也有相同功能且调用父类的方法的方法
 */
