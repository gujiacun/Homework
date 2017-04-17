//需求：操作双向链表数据结构，掌握其特点，在类中自定义方法实现增，删，查，打印
//步骤：（1）创建链表类，测试类，在测试类中创建链表类的对象，并调用尾部插入的方法
//（2）在主方法新建一个节点，分两种情况，1.当链表中已经有其它节点。2.当链表只有一个节点
//（3）增加节点，把增加的节点作为第一个节点；把增加的节点作为最后一个节点；
//（4）打印节点中所有的元素，重写toString方法
//（5）删除某个节点
package myLinkedListDemo;

//测试类
public class MyLinkedListTest {
    // 主方法
    public static void main(String[] args) {
        // 创建链表类的对象
        MyLinkedList list = new MyLinkedList();
        // 对象调用addLast方法，并传入节点中所存储的数据
        list.addLast("B");
        list.addLast("C");
        list.addLast("D");
        // 对象调用addFirst方法，并传入节点中所存储的数据
        System.out.println(list);
        list.addFirst("A");
        // 删除操作
        System.out.println(list);
        list.remove("D");
        System.out.println(list);
    }

}
/**
 *小结：链表时，一定要画图，可以把prev，next看成是每个节点的属性 。
 */