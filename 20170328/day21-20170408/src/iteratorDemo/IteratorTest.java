//需求：操作对List集合的四种迭代方式
package iteratorDemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorTest {

    public static void main(String[] args) {
        // 创建List类的对象，注意指定泛型
        List<Double> life = new ArrayList<Double>();
        // 添加元素
        life.add(1.0);
        life.add(2.0);
        life.add(3.0);
        life.add(4.0);
        // 方式一：for
        for (int i = 0; i < life.size(); i++) {
            System.out.println(life.get(i));
        }
        System.out.println("-----");
        // 方式二：for-each
        for (Double double1 : life) {
            System.out.println(double1);
        }
        System.out.println("-----");
        // 方式三：while操作迭代器
        // (1)先创建迭代器对象,由于Iterator是接口，不能用new，要借助Collection接口的iterator方法，返回一个Iterator对象
        // 由于ArrayList类时Collection接口的实现类的子类，继承了iterator方法
        Iterator<Double> iter = life.iterator();
        // hasNext()返回boolean类型，用作判断条件
        while (iter.hasNext()) {
            // next()方法返回迭代的下一个元素
            System.out.println(iter.next());
        }
        System.out.println("-----");
        // 方式四：for操作迭代器
        for (Iterator<Double> iter02 = life.iterator(); iter02.hasNext();) {
            System.out.println(iter02.next());
        }

    }
}

/**
 * 小结：第四种方法把迭代器的对象的作用域限定在for循环内，提高性能，但若迭代器对象在下方还需要使用，用第三种
 */
