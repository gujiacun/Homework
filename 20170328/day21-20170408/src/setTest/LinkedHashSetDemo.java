//需求：操作LinkedHashSet的add方法，感受一波它的记录元素添加的先后顺序
package setTest;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class LinkedHashSetDemo {

    public static void main(String[] args) {
        // 创建LinkedHashSet对象
        LinkedHashSet<Integer> son = new LinkedHashSet<Integer>();
        son.add(500);
        son.add(600);
        son.add(300);
        son.add(100);
        //打印结果与添加顺序相同，在底层按照链表的算法排序
        System.out.println(son);
        //假如是HashSet，结果会怎样？
        HashSet<Integer> girl = new HashSet<Integer>();
        girl.add(60);
        girl.add((int)'a');
        girl.add(10);
        girl.add(90);
        // 在哈希表中元素没有先后顺序，都按照哈希算法来排好序
        System.out.println(girl);
    }
}
/**
 * 小结：LinkedHashSet底层采有哈希表和链表算法，分别负责元素唯一性和元素添加的先后顺序
 */
