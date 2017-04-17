//需求：操作队列，在自定义的双向链表工具类基础上，实现双向队列的工具类。
//步骤：（1）新建队列类，继承自双向链表工具类
//（2）对队列的头部和尾部进行查询，删除，增添操作，注意调用父类方法

package queueDemo;

import myLinkedListDemo.MyLinkedList;

//新建队列类，继承自双向链表工具类
//注意要在同一个包下
public class MyDeque extends MyLinkedList {

    // 查询
    public Object getFirst() {
        // 直接获取父类中的字段
        return this.first.ele;
    }

    public Object getLast() {
        // 直接获取父类中的字段
        return this.last.ele;
    }

    // 删除
    public void removeLast() {
        // super表示当前对象的父类对象，调用父类中的remove方法
        // remove方法要传入值，由于是删除第一个，直接删this.first这一字段，要改访问权限
        super.remove(this.first);
    }

    public void removeFirst() {
        // super表示当前对象的父类对象，调用父类中的remove方法
        // remove方法要传入值，由于是删除最后一个，直接删this.last这一字段，要改访问权限
        super.remove(this.last);
    }

    // 增添
    public void addLast(Object ele) {
        // 父类中存在同名方法，直接用super调用父类的方法即可
        super.addLast(ele);
    }

    public void addFirst(Object ele) {
        super.addFirst(ele);
    }

    // 主方法，做测试
    public static void main(String[] args) {
        MyDeque deque = new MyDeque();
        deque.addLast("AMCD");
        deque.addFirst("lkj");
        System.out.println(deque);
        System.out.println(deque.getFirst());
        deque.removeFirst();
        System.out.println(deque.getLast());

    }

}
/**
 * 小结：善用super和this，减少代码重复，掌握访问权限修饰符
 */
