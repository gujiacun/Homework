
//需求：一个字符串，统计每个字符各自出现的次数
//步骤：（1）新建字符串，自然想到字符串-出现次数，此形式重复出现，存储为Map
//（2）要统计每个字符，先把字符串拆为字符数组
//（3）新建Map对象，用for循环统计
//（4）把字符存为key，把出现次数存为value
//（5）在循环，判断字符是否在Map对象里，若在，取出value值，加一后再放回；不在，字符存key，value存1
package mapDemo;

import java.util.HashMap;
import java.util.Map;

public class MapExample {

    public static void main(String[] args) {
        // 新建字符串
        String str = "riuwefhanvovjagduyccjahcnmsgdawy";
        // String类中有实例方法，toCharArray，使字符串对象转为char数组
        char[] array = str.toCharArray();
        Map<Character, Integer> couple = new HashMap<Character, Integer>();
        // 这里只能用for-each，因为数组中的每个元素也是Map对象couple中的key（键）
        for (char ele : array) {
            // containsKey 若此映射包含此键，返回true
            if (couple.containsKey(ele)) {
                // get()方法,返回指定key值的value
                int number = couple.get(ele);
                number++;
                couple.put(ele, number);
            } else {
                couple.put(ele, 1);
            }
        }
        System.out.println(couple);
    }
}
/**
 * 小结：Map的对象中的key和value都可以是任意类型，所以循环操作时最好用for-each，因为循环中的 元素可能是key或value。
 * 同时，Map类中的搜索方法是containsKey和containsValue，增加元素时put
 */
