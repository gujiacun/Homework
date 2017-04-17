//需求：操作栈这一数据结构，模拟实现Stack类的方法，继承自MyArrayList类
//(1)新建类，继承父类
//（2）实施入栈，查找栈顶元素，删除栈顶三个方法
package stackDemo;

import arrayTest.MyArrayList;

public class MyStack extends MyArrayList {

    // 入栈
    public void push(Object ele) {
        super.add(ele);
    }

    // 查找栈顶元素
    public Object peek() {
        return super.find(amount - 1);
    }

    // 删除栈顶
    public void pop() {
        super.delete(amount - 1);
    }

    // 测试以上方法
    public static void main(String[] args) {
        // 新建类的对象，调用实例方法
        MyStack s = new MyStack();
        s.push("年轻人要提高自己姿势水平");
        // 第二句的内容成为栈顶
        s.push("识得唔识得");
        System.out.println(s.peek());
        // 删除栈顶，剩下的一句成为栈顶
        s.pop();
        System.out.println(s.peek());
    }
    /**
     * 小结：栈是数据结构，我们这里自行为它创造了很多方法，栈的工具类可以由数组工具类和双向链表类来实现
     */
}
