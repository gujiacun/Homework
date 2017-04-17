//需求：操作TreeSet的添加元素，打印，并操作其他常用方法
package setTest;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class TreeSetDemo {
    // 主方法
    public static void main(String[] args) {
        // 建对象
        TreeSet<Integer> son = new TreeSet<Integer>();
        // add方法，打印
        son.add(30);
        son.add(80);
        son.add(5);
        son.add(-36);
        // 返回大于等于这个特定元素的所有元素,可以直接打印
        System.out.println(son.tailSet(5));
        // 移出一个不在此的元素，返回boolean类型
        System.out.println(son.remove(100));
        // 移除并获取第一个元素
        System.out.println(son.pollFirst());
        // 将指定 collection 中的所有元素添加到此 set 中
        List<Integer> list = new ArrayList<Integer>();
        list.add(100);
        list.add(300);
        list.add(200);
        son.addAll(list);
        System.out.println(son);
}
}
/**
 * 小结：TreeSet类底层采用红黑树算法，对存储在里面的元素默认使用自然排序，从小到大
 */
