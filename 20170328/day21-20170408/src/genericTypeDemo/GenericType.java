//需求：使用泛型的原因及好处
package genericTypeDemo;

import java.util.ArrayList;
import java.util.List;

public class GenericType {

    public static void main(String[] args) {
        // 不用泛型，存储在集合中的对象都是Object型
        List list = new ArrayList();
        list.add(200);
        list.add("林则徐诗篇朗诵者");
        // 取出以上两个元素，get方法来自ArrayList类，返回某索引值的元素
        Object ele01 = list.get(0);
        Object ele02 = list.get(1);
        // 把ele02转为Integer类型，此时报错，需要强制转换类型
        String num01 = (String) ele02;

        // 假如使用泛型，指定输入集合的数据都只能是某类型（禁止用基本数据类型）
        List<String> list02 = new ArrayList<String>();
        list02.add("机电系荣耀");
        list02.add("威夷州吉他演奏者");
        // 没有报错，get方法来自ArrayList类，返回某索引值的元素
        String name01 = list02.get(0);
        String name02 = list02.get(1);
        System.out.println(name01);
        System.out.println(name02);
    }
}
/**
 * 小结：在网上看过很多人喷java的类型擦除，但泛型使用广泛，能约束集合中的数据类型， 也能为编程提供灵活性
 */
