//需求：操作泛型擦除
//步骤：（1）创建集合对象A，带泛型
//（2）创建另一个集合对象B，不带泛型，把A赋给B，此时类型被擦除，添加另一类型的数据
//（3）创建集合对象C，带另一个泛型，把B赋给C，取出第一个元素
package genericTypeDemo;

import java.util.HashSet;
import java.util.Set;

public class GenericDemo {

    public static void main(String[] args) {
        // 创建集合对象A，带泛型
        Set<String> fuck = new HashSet<String>();
        fuck.add("dick");
        System.out.println(fuck.toString());

        // 创建另一个集合对象B，不带泛型，把A赋给B
        Set pussy = null;
        // 类型擦除
        pussy = fuck;
        System.out.println(pussy.toString());
        // 添加Integer类型的数据
        pussy.add(10086);
        System.out.println(pussy.toString());

        // 创建集合对象C，带另一个泛型
        Set<Integer> asshole = null;
        asshole = pussy;
        // 报错，因为已经指定了Integer类型，只能用Integer来接受
        // String num = asshole.get(0);
    }
}
/**
 * 小结：慎用类型擦除，用时注意对象的类型
 */
