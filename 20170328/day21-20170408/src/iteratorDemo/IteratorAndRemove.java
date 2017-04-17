//需求：在迭代器中边迭代边删除集合的元素，集合对象和迭代器对象分别操作remove方法
package iteratorDemo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IteratorAndRemove {

    public static void main(String[] args) {
        // 新建集合
        List<Integer> combination = new LinkedList<Integer>();
        // 添加元素
        combination.add(100);
        combination.add(200);
        combination.add(300);
        combination.add(400);
        combination.add(500);
        // 迭代元素，进行到一定条件时删除元素，用迭代器对象操作remove方法
        Iterator<Integer> iter = combination.iterator();
        while (iter.hasNext()) {
            // 迭代器的next方法，返回的是Object类型
            Object ele = iter.next();
            // 假如迭代器的元素是300，把它从集合中删除
            if (ele.equals(300)) {
                iter.remove();
            }
        }
        // 进行完集合元素删除后，打印集合剩下的元素
        System.out.println(combination);
        System.out.println("--------------------");
        // 迭代元素，进行到一定条件时删除元素，用集合对象操作remove方法
        Iterator<Integer> iter02 = combination.iterator();
        for (Object ele : combination) {
            System.out.println(ele);
            if (ele.equals(300)) {
                combination.remove(ele);
            }
        }
    }
}
/**
 * 小结：在操作集合对象的迭代操作时，若要边迭代边删除，用迭代器遍历，用迭代对象进行remove
 */
