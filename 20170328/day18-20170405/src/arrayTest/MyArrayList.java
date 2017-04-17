//需求：在PlayerList类中，方法能被其它数组所共享，能存储任意数据类型，所以自己把它再抽象化
//把Object类型数组改为Object类型数组，能存储任意数据类型，表示基于数组算法的列表
package arrayTest;

import java.util.Arrays;

public class MyArrayList {
    // 用新建数组，存储任意类型的数据
    private Object[] elements = null;// 先声明
    // 数组中存储元素的个数,默认为0
    protected int amount = 0;

    // 新建一个无参构造器，里面调用有参构造器
    public MyArrayList() {
        // 表示当在测试类中调用构造器时，若不传参数，就默认创建一个长度为10的数组
        this(10);
    }

    // 1)动态创建新数组，即数组长度，可以以此为构造器
    // 构造器没有返回值类型
    public MyArrayList(int initialCapacity) {
        // 检测索引值
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("请重新输入");
        }
        // 动态创建数组格式为 数组类型[] 数组名 = new 数组类型[元素个数];
        elements = new Object[initialCapacity];
    }

    // 2)为数组添加元素
    public void add(Object ele) {
        //假如amount == elements.length，请用Arrays.copyOf扩容
        if (amount == elements.length) {
            Object[] temp = Arrays.copyOf(elements, elements.length * 2);
            elements = temp;
        }
        // 注意形式参数的名称，不要犯低级错误
        elements[amount] = ele;
        // 由于定义了数组长度为0，而添加元素会令数组索引加1，新元素不断在数组的新位置被添加
        amount++;
    }

    // 3):查询指定索引位置的元素是多少
    public Object find(int i) {
        // 检测索引值，若小于0或大于数组长的，抛出错误
        if (i < 0 || i > +amount) {
            throw new IllegalArgumentException("索引越界");
        }
        return elements[i];
    }

    // 4):根据元素查询该元素在数组中的索引位置
    public int findIndex(Object ele) {
        // 用equals把传入内容与数组中的所有内容作比较，用for循环逐个判断
        for (int i = 0; i < amount; i++) {
            // 如果传入元素与数组中的某个元素相等，输出某元素的索引
            if (ele.equals(elements[i])) {
                return i;
            }
        }
        // 假如在数组中找不到该元素，返回-1
        return -1;
    }

    // 5):替换指定索引位置的元素值
    public void change(int index, Object newEle) {
        if (index < 0 || index > +amount) {
            throw new IllegalArgumentException("索引越界");
        }
        elements[index] = newEle;
    }

    // 6):把指定元素替换为新元素
    public void update(Object oldEle, Object newEle) {
        int index = findIndex(oldEle);
        change(index, newEle);
    }

    // 7):删除指定索引位置的元素
    public void delete(int index) {
        if (index < 0 || index > +amount) {
            throw new IllegalArgumentException("索引越界");
        }
        // 步骤：（1）把index后面的元素集体向前移动1位
        // （2）最后的元素设为null
        // （3）上场球员个数减1
        // 由于最后一个元素要被设置为null，所以i < amount - 1
        for (int i = index; i < amount - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[amount - 1] = null;
        amount--;
    }

    // 8):打印数组元素,打印风格:[11,22,33,44,55].
    public void print() {
        // 假如数组为空，返回null，假如数组还没传入元素，返回[]
        if (elements == null) {
            System.out.println("Null");
        }
        if (amount == 0) {
            System.out.println("[]");
        }
        // 数组不空，先动态新建StringBuilder
        // StringBuilder底层是char数组，一个字符是一个位置
        StringBuilder str = new StringBuilder(amount * 3 + 1);
        str.append("[");
        // 用for循环把数组元素全都循环出来，并拼接到str中
        for (int i = 0; i < amount; i++) {
            str.append(elements[i]);
            // 假如不是最后一个元素，就在此元素与下一个元素之间加逗号
            if (i != amount - 1) {
                str.append(",");
            } else {
                // 是最后一个元素就加]
                str.append("]");
            }

        }
        // 循环结束后，把数组转为String类型并打印
        System.out.println(str.toString());
    }

    // 9） 返回数组的元素个数
    public int size() {
        return amount;
    }

    // 10) 判断数组中元素个数是否为0/数组是否为空
    public boolean isEmpty() {
        return amount == 0;
    }

    // 11)清空数组所有元素
    public void clear() {
        for (int i = 0; i < amount; i++) {
            // 把数组所有元素都赋为null
            elements[i] = null;
            amount = 0;
        }

    }

    // 主方法
    // public static void main(String[] args) {
    // // TODO Auto-generated method stub
    //
    // }

}
/**
 * 小结：把数组工具类中的主要方法自己模拟一边，还有些重载方法，不仅要会用工具，还知道工具的原理，以防
 * 以后需要自行搭建工具类
 */