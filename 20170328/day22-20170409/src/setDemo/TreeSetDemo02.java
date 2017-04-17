package setDemo;
//需求：在另一个类TreeSetDemo的基础上，按照人名的长度来排序，即自定义排序

//步骤：（1）新建三个类，测试类，自定义对象类BigStudent，实现比较器类judge
//（2）在BigStudent类建姓名，年龄字段。在judge实现comparator类，重写compare方法
//（3）在测试类建TreeSet对象时通过构造器传入比较器类的对象
//(4)往TreeSet对象添加对象类的对象（即集合的元素）
//（5）打印

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

//由于要实现对象的定制排序，先把传入TreeSet集合的对象的类实现Comparator接口，再重写comapre方法
//对象类（学生及其信息）
class BigStudent {
    // 学生信息
    String name;
    int age;

    // 根据信息（字段）创建带参构造器，在创建对象时直接传入参数
    public BigStudent(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 注意要重写toString方法，否则会输出内存地址
    @Override
    public String toString() {
        return "name:" + this.name + "   age:" + this.age;
    }
}

// 比较器类judge，实现comparator接口
class Judge implements Comparator<BigStudent> {
    // 重写comapre方法
    @Override
    public int compare(BigStudent o1, BigStudent o2) {
        if (o1.name.length() > o2.name.length()) {
            return -1;
        } else if (o1.name.length() < o2.name.length()) {
            return 1;
        } else {
            return 0;
        }
    }
}

// 测试类
public class TreeSetDemo02 {
    // 主方法
    public static void main(String[] args) {
        // 创建judge类（比较器类）的对象
        Judge judge = new Judge();
        // 建TreeSet对象，TreeSet(Comparator<? super E> comparator)
        // 此构造方法表示构造一个新的空 TreeSet，它根据指定比较器进行排序
        Set<BigStudent> tree = new TreeSet<>(judge);
        // 建BigStudent的对象
        BigStudent jack = new BigStudent("西方记者Wallace", 20);
        BigStudent mary = new BigStudent("香港记者张宝华", 21);
        BigStudent frog = new BigStudent("上海书记", 999);
        BigStudent girl = new BigStudent("苗族辣妹", 50);
        // 传入tree中
        tree.add(jack);
        tree.add(girl);
        tree.add(frog);
        tree.add(mary);
        // TreeSet判断两个对象是否为同一个的规则是看compareTo/compare的返回值是不是0
        // 由于上海书记 和 苗族辣妹 长度一样，返回0，判定为同一个对象，后来者覆盖了前者
        System.out.println(tree);
    }
}
/**
 * 小结：仔细掌握TreeSet的自然排序和定制排序的步骤和过程，和HashSet判定是否为相同对象作比较
 */
