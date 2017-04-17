//需求：stack是栈，操作Stack类的常用方法
package listDemo;

import java.util.Stack;

public class StavkDemo {
    // 主方法
    public static void main(String[] args) {
        // Stack类是Vector类的子类
        // 新建Vector类的对象
        Stack star = new Stack();
        // 测试堆栈是否为空
        System.out.println(star.isEmpty());
        // 把项压入堆栈顶部
        star.push("黑框眼镜");
        star.push("高高的裤腰带");
        star.push("精通夏威夷吉他");
        // 查看堆栈顶部的对象，但不从堆栈中移除它(后进先出)
        System.out.println(star.peek());
        // 移除堆栈顶部的对象，并作为此函数的值返回该对象
        Object delete = star.pop();
        System.out.println(delete);
        // 被删除后，栈顶对象更新
        System.out.println(star.peek());
        // 返回对象在堆栈中的位置，以 1 为基数
        System.out.println(star.search("黑框眼镜"));
        System.out.println(star.search("高高的裤腰带"));
        // 假设搜寻对象在被搜寻对象中不存在，返回-1
        System.out.println(star.search("excited"));
        // 用Stack类中没有的方法size来返回此时栈中的元素个数
        System.out.println(star.size());
    }
}
/**
 * 小结：由于Stack类是Vector类的子类，所以可以用一些Stack类中没有的方法
 */
