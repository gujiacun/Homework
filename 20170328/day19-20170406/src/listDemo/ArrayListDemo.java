//需求：操作ArrayList类，熟悉其常用方法，与Vector类的不同
//（1）定义一个类，实现类，重写run方法，在主方法中创建多线程并启动
//（2）调用ArrayList类的常用方法
package listDemo;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListDemo {

    public static void main(String[] args) {

        // 在主方法中创建多线程并启动
        // ThreadDemo num = new ThreadDemo();

        // new Thread(num, "A").start();
        // new Thread(num, "B").start();
        // 从结果可看出，由于ArrayList方法没有synchronized修饰，多线程并发会出现争夺现象

        // 创建ArrayList类对象
        // ArrayList类在底层是由Object数组存储数据
        ArrayList arr = new ArrayList();
        ArrayList arr02 = new ArrayList();

        // 集合类中存储的对象,都存储的是对象的引用,而不是对象本身
        // 向数组插入元素
        arr.add("123");
        arr.add("456");
        arr02.add("7");
        arr02.add("8");
        arr02.add("9");
        // 注意这两个方法的返回值类型都是boolean类型
        // System.out.println(arr.add(arr02));
        // System.out.println(arr.addAll(arr02));

        // arr.add(arr02);
        // 注意，要想返回此列表中所有元素，用toArray()方法，把所有元素转为一个数组,用Object数组接收返回值
        // Object[] array = arr.toArray();
        // 调用java.lang.Arrays.toString方法把数组转为String类型
        // System.out.println(Arrays.toString(array));
        // 下方把add方法改为addAll方法
        arr.addAll(arr02);
        Object[] array02 = arr.toArray();
        System.out.println(Arrays.toString(array02));

        // 根据元素索引值移除某个元素
        arr.remove(2);
        Object[] array03 = arr.toArray();
        // 移除指定元素后的数组，要重新转为新数组
        System.out.println(Arrays.toString(array03));

        // 返回现在数组中的元素个数
        System.out.println(arr.size());

        // 用新元素代替某个指定索引值上的元素
        arr.set(0, "321");
        Object[] array04 = arr.toArray();
        System.out.println(Arrays.toString(array04));
    }

}

class ThreadDemo implements Runnable {
    // 创建ArrayList类对象
    // @Override
    ArrayList arr = new ArrayList();

    public void run() {
        // 重写run方法
        for (int j = 0; j < 50; j++) {
            arr.add(j);

            System.out.println(Thread.currentThread().getName() + arr);
        }
    }
}
/**
 * 小结：ArrayList类线程不安全，但性能更高，以后有补救方法令它线程安全
 * 在API中注意方法的返回值类型
 */