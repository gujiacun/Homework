//需求：操作LinkedList，即双向链表，单向队列双向队列和栈的工具集合类
package listDemo;

import java.util.Arrays;
import java.util.LinkedList;

public class LinkedListDemo {
    // 主方法
    public static void main(String[] args) {
        // 创建LinkedList类的对象，LinkedList类在底层是双向链表结构算法
        LinkedList link = new LinkedList();
        // 在头部和尾部增加元素
        link.addFirst("1234");
        link.addFirst("辣妹子辣");
        link.addLast("有事情可以找大哥");
        // 在指定位置插入元素
        // 若索引为0，此操作会令输入内容变为顶端
        link.add(0, "强闯春晚直播现场");

        // 把双向链表转成数组，再输出
        Object[] array = link.toArray();
        System.out.println(Arrays.toString(array));

        // 打印栈顶元素
        System.out.println(link.peek());
        // 打印栈底元素
        System.out.println(link.peekLast());
        // 往栈顶添加元素
        link.push("与美国记者谈笑风生");
        System.out.println(link.peek());
    }
}
/**
 * 小结：LinkedList类实现了多个数据结构的方法操作，可以仔细体会
 */
