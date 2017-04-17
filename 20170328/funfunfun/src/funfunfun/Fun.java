package funfunfun;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
//import java.util.List;
import java.util.Map;
import java.util.Set;
//import java.util.Set;
//import java.util.TreeSet;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.HashSet;

public class Fun {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        // put方法输入元素
        map.put("香港记者", "张宝华");
        map.put("美国记者", "华莱士");
        map.put("香港特首", "董建华");
        map.put("湖南辣妹", "宋祖英");
        // get方法，通过输入key，返回value
        String str = map.get("美国记者");
        System.out.println(str);
        // containsKey方法，判断key是否存在
        if (map.containsKey("香港记者")) {
            System.out.println("key存在");
        } else {
            System.out.println("key不存在");
        }
        // containsValue方法，判断value是否存在
        if (map.containsValue("董建华")) {
            System.out.println("value存在");
        } else {
            System.out.println("value不存在");
        }
        // keySet方法，能打印所有的key，返回Set集合
        Set<String> s = map.keySet();
        // 用迭代器
        Iterator<String> iter = s.iterator();
        // 循环，打印输出
        while (iter.hasNext()) {
            // 输出的key是乱序的
            System.out.println(iter.next());
        }
        
        System.out.println("--------");
        // values方法，能打印所有的key，返回Collection集合
        Collection<String> c = map.values();
        // 用迭代器
        Iterator<String> iter2 = c.iterator();
        // 循环，打印输出
        while (iter2.hasNext()) {
            // 输出的value是乱序的
            System.out.println(iter2.next());
        }
        // List<String> lists = null;
        // lists = new ArrayList<String>();
        // lists.add("A");
        // lists.add("B");
        // lists.add("C");
        // lists.add("D");
        // lists.add("E");
        // lists.add("F");
        // Iterator<String> iter = lists.iterator();
        // while (iter.hasNext()) {
        // String str = iter.next();
        // if ("A".equals(str)) {
        // iter.remove();
        // } else {
        // System.out.println(str + "1");
        // }
        // // System.out.println(iter.next());
        // // System.out.println("--------");
        // }
        // for (int i = 0; i < lists.size(); i++) {
        // System.out.println(lists.get(i));
        // }
        // lists.remove(0);
        // for (int i = 0; i < lists.size(); i++) {
        // System.out.println(lists.get(i));
        // }
        // System.out.println("集合是否为空" + lists.isEmpty());
        // System.out.println("B是否存在" + lists.indexOf("B"));
        // Set<String> s1 = null;
        // Set<String> s2 = null;
        // s1 = new HashSet<String>();
        // s2 = new TreeSet<String>();
        // s1.add("F");
        // s1.add("B");
        // s1.add("A");
        // s1.add("C");
        // s1.add("D");
        // s1.add("E");
        // System.out.println(s1);
        // s2.add("E");
        // s2.add("B");
        // s2.add("A");
        // s2.add("F");
        // s2.add("D");
        // s2.add("C");
        // System.out.println(s2);
    }

}
