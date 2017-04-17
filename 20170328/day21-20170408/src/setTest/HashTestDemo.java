//需求：操作HashSet的方法
package setTest;

import java.util.HashSet;
import java.util.Iterator;

public class HashTestDemo {

    public static void main(String[] args) {
        // 创建HashSet类的对象
        HashSet<String> h = new HashSet<String>();
        // 添加元素，由于已指定泛型，只能输入该类型数据
        h.add("续1s！");
        h.add("续2s！");
        h.add("续3s！");
        h.add("续4s！");
        // HashSet类是Set接口的实现类，不允许元素重复，若重复，后者会覆盖前者
        h.add("续4s！");

        // 是否包含指定元素
        System.out.println(h.contains("续5s!"));
        // 是否为空
        System.out.println(h.isEmpty());
        // 元素个数
        System.out.println(h.size());
        // 迭代
        Iterator iterator = h.iterator();
        // Iterator中的方法，hasNext表示是否还有下一个元素
        while (iterator.hasNext()) {
            // next方法表示输出下一个元素
            Object object = (Object) iterator.next();
            System.out.println(object);
        }
        // 清除元素
        h.clear();
        // 已覆写toString方法，输出为空字符串
        System.out.println(h);
    }
}
/**
 * 小结：HashSet由于用了hash算法，查询（contains方法）速度较快
 */
