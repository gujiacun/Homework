//需求：操作TreeMap常用方法，
package mapDemo;

import java.util.Comparator;
import java.util.TreeMap;

import javax.sql.rowset.spi.TransactionalWriter;

//import setDemo.BigStudent;

//import setDemo.BigStudent;

public class TreeMapDemo {

    public static void main(String[] args) {
        // 创建对象
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("西方记者Wallace", 89);
        // 是否为空
        System.out.println(treeMap.isEmpty());
        // 是否包含此键
        System.out.println(treeMap.containsKey("西方记者Wallace"));
        // 是否包含此值
        System.out.println(treeMap.containsValue(8));
        // 返回指定键所映射的值
        System.out.println(treeMap.get("西方记者Wallace"));
        // 返回此映射中包含的映射关系的 Set 视图
        System.out.println(treeMap.entrySet());
        // 将指定映射中的所有映射关系复制到此映射中
        /// putAll(Map<? extends K,? extends V> map)
        TreeMap<String, Integer> treeMap02 = new TreeMap<>();
        treeMap02.put("香港记者张宝华", 21);
        treeMap.putAll(treeMap02);
        System.out.println(treeMap);

        // 定制排序
        Judge judge = new Judge();
        TreeMap<BigStudent, Integer> school = new TreeMap<>(judge);
        // 建BigStudent的对象
        BigStudent jack = new BigStudent("西方记者Wallace", 20);
        BigStudent mary = new BigStudent("香港记者张宝华", 21);
        BigStudent frog = new BigStudent("上海书记", 999);
        BigStudent girl = new BigStudent("苗族辣妹", 50);
        // 传入school中
        school.put(jack, 0);
        school.put(girl, 0);
        school.put(frog, 0);
        school.put(mary, 0);
        // TreeMap判断两个对象是否为同一个的规则是看compareTo/compare的返回值是不是0
        // 由于上海书记 和 苗族辣妹 长度一样，返回0，判定为同一个对象，后来者覆盖了前者
        System.out.println(school);
    }

}

class BigStudent {
    // 学生信息
    String name;
    int age;

    // 根据信息（字段）创建带参构造器，在创建对象时直接传入参数
    public BigStudent(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 注意要重写toString方法，否则会输出内存地址
    @Override
    public String toString() {
        return "name:" + this.name + "   age:" + this.age;
    }
}

// 比较器类judge，实现comparator接口
class Judge implements Comparator<BigStudent> {
    // 重写compare方法
    @Override
    public int compare(BigStudent o1, BigStudent o2) {
        if (o1.name.length() > o2.name.length()) {
            return -1;
        } else if (o1.name.length() < o2.name.length()) {
            return 1;
        } else {
            return 0;
        }
    }
}
/**
 * 小结：TreeMap与TreeSet的定制排序实现方式和步骤一样
 */

