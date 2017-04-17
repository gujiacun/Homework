//需求：List和Set以及Map之间相互转换
//（1）创建List对象，转为Set对象，再转为List对象，记住格式
//（2）建Map对象，把键值，value值，entry都转换
package mapDemo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SwitchDemo {

    public static void main(String[] args) {
        // 创建List对象
        List<String> list = new ArrayList<>();
        // 转为Set对象,原码public HashSet(Collection<? extends E> c)
        // 即可以在构造器里传入(Collection类的对象，再转换为Set对象
        Set<String> set = new HashSet<>(list);
        // 把Set对象转为List对象,public ArrayList(Collection<? extends E> c)
        // 即可以在构造器里传入(Collection类的对象，再转换为List对象
        List<String> list2 = new ArrayList<>(set);

        // 建Map对象
        Map<String, Object> map = new HashMap<>();
        map.put("咖啡", "Java");
        map.put("蟒蛇", "Python");
        map.put("蛤丝克尔", "Haskell");

        // 输出集合的所有key，返回Set集合对象，不允许重复
        // 由于在创建Map对象时已经指定key的类型是String，所以这里泛型是String
        Set<String> keys = map.keySet();
        System.out.println(keys);

        // 输出集合的所有value，返回Collection集合对象，不允许重复
        // 由于在创建Map对象时已经指定value的类型是Object,所有这里泛型是Object
        Collection<Object> values = map.values();
        System.out.println(values);
    }
}
/**
 * 小结：List对象和Set对象都可以通过构造器直接转为对方的类型
 */
