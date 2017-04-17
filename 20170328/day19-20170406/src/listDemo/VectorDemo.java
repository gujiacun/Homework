//需求：操作Vector类，实现可增长的对象数组，调用类里的实例方法
package listDemo;

import java.util.Vector;

public class VectorDemo {
    // 主方法
    public static void main(String[] args) {
        // 新建Vector类的对象
        Vector frog = new Vector();
        frog.add("香港记者：林郑月额当特首，中央支持不支持？");
        frog.add("江主席：资茨，我就明确告诉你这一点");
        System.out.println(frog.toString());
        // 集合类中存储的对象,都存储的是对象的引用,而不是对象本身
        frog.clear();
        System.out.println(frog);
        frog.add(3);
        frog.add(9);
        StringBuilder str = new StringBuilder("108");
        frog.add(str);
        // 打印出[3, 9, 108]
        System.out.println(frog);
        // 在下面更改str的值
        str.append("稻花香里说丰年");
        // Vector对象里存的是str的引用地址，str内容改变，frog里的内容也跟着改变
        System.out.println(frog);

        // 分析Vector类中add方法与addAll方法的不同
        // 分别创建两个Vector类对象
        Vector v1 = new Vector();
        Vector v2 = new Vector();
        // 为v1增加元素
        v1.addElement("水可");
        v1.addElement("载舟");
        // 为v2增加元素
        v2.addElement("亦");
        v2.addElement("可");
        v2.addElement("赛");
        v2.addElement("艇");
        // 把v2通过add方法和addAll方法传入v1并打印
        // v2被作为整个元素加入v1的数组
        v1.add(v2);
        // 打印[水可, 载舟, [亦, 可, 赛, 艇]]
        System.out.println(v1);
        // v2的所有元素被拆开，全部加入到v1的数组
        // v1.addAll(v2);
        // 打印[水可, 载舟, 亦, 可, 赛, 艇]
        // System.out.println(v1);

        // 在此向量的指定位置加入指定元素
        v1.add(1, "禁止暴力膜蛤");
        System.out.println(v1);

        // 返回数组中元素的个数
        System.out.println(v1.size());

        // 清除所有元素
        frog.clear();
        System.out.println(frog);
        v1.clear();
        System.out.println(v1);
        v2.clear();
        System.out.println(v2);

        // 移除某个元素
        Vector v3 = new Vector();
        // Vector类把数据存储到Object数组中，现在可自动装箱
        v3.add(3);
        v3.add(3);
        v3.add(5);
        v3.add(8);
        System.out.println("清除前" + v3);
        // 这代表清除v3数组中索引号为3的元素
         //v3.remove(3);
        // 移除string型的对象，但是源数组没有
        //v3.remove("3");
        // 下行代表清除3这个基本类型的相应的包装类对象
         v3.remove(Integer.valueOf(3));
        System.out.println("清除后" + v3);
    }
}
/**
 * 小结：add(int index, E element) ，在此向量的指定位置插入指定的元素 addAll(int index, c)
 * 在指定位置将指定对象中的所有元素插入到此向量中
 */
