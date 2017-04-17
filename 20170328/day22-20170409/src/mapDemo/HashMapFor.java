//需求：对HashMap的key集合，value集合，entry(key-value)集合的迭代
//（1）建HashMap的对象，分别输出key集合，value集合，entry(key-value)集合
//（2）注意三者输出时的返回值类型，用for-each迭代以上三者的元素
package mapDemo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapFor {

    public static void main(String[] args) {
        // 建HashMap的对象,一般把key指定为String类型，把value指定为Object类型
        HashMap<String, Object> room = new HashMap<>();
        // 为集合对象添加元素
        room.put("Exile", "takahiro");
        room.put("Exile Tribe", "Elly");
        room.put("E-Girls", "Gold");
        // 输出key集合，返回Set集合
        Set<String> key = room.keySet();
        // 输出value集合，返回Collection对象
        Collection<Object> value = room.values();
        // 输出entry集合，返回 Set<Map.Entry<K,V>>
        Set<Map.Entry<String, Object>> entry = room.entrySet();

        // 迭代key集合
        for (String string : key) {
            System.out.println(string);
        }
        
        
        // 迭代value集合
        for (Object object : value) {
            System.out.println(object);
        }
        // 迭代entry(key=value)集合
        for (Map.Entry<String, Object> ele : entry) {
            // getKey()是Map.Entry<K,V>的实例方法,返回key
            String key1 = ele.getKey();
            // getValue()都是Map.Entry<K,V>的实例方法，,返回value
            Object value1 = ele.getValue();
            System.out.println(key1 + "--->" + value1);
        }
        System.out.println("---------------------");
        //迭代器也适用于Map接口的实现类
        Iterator it = key.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
            
        }
    }
}
/**
 * 小结：entrySet() 方法返回此HashMap中的所有映射关系，类型为 Set<Map.Entry<K,V>>
 * 意为它是Set的集合，而Map.Entry<K,V>是Map接口的内部类 getKey()和getValue()都是Map.Entry<K,V>的实例方法
 */
