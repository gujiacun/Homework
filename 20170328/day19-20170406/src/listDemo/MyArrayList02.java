//需求：在PlayerList类中，方法能被其它数组所共享，能存储任意数据类型，所以自己把它再抽象化
//把Object类型数组改为Object类型数组，能存储任意数据类型，表示基于数组算法的列表
package listDemo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.naming.directory.SearchControls;

//模拟java中自带的ArrayList集合类，写一个数组常用的方法的集合
public class MyArrayList02 {



    // 用新建数组，存储任意类型的数据
    Object[] elements = null;
    // 数组中存储元素的个数,默认为0
    int size = 0;

    // 新建一个无参构造器，里面调用有参构造器
    public MyArrayList02() {
        // 表示当在测试类中调用构造器时，若不传参数，就默认创建一个长度为10的数组
        this(10);
    }

    // 1)动态创建新数组，即数组长度，可以以此为构造器
    public MyArrayList02(int initCapacity) {
        if (initCapacity < 0) {
            throw new IllegalArgumentException("请重新输入");
        }
        elements = new Object[initCapacity];
    }

    // 2)为数组添加元素
    public void add(Object ele) {
        // 先检查数组有没有满，若满了，自动扩容，新建一个长度更大的新数组，把旧数组拷贝到新数组，再添加
        if (size == elements.length) {
            Object[] newArray = Arrays.copyOf(elements, elements.length * 2);
            elements = newArray;
        }
        // 假如数组没满，插入在最后元素后
        elements[size] = ele;
        // 插入元素后，元素个数增加
        size++;
    }

    // 3):查询指定索引位置的元素是多少
    public Object get(int index) {
        if (index < 0 || index > elements.length) {
            throw new IllegalArgumentException("请重新输入");
        }
        return elements[index];
    }

    // 4):根据元素查询该元素在数组中的索引位置
    public int indexOf(Object ele) {
        for (int i = 0; i < size; i++) {
            if (ele.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    // 5):替换指定索引位置的元素值
    public void set(int index, Object ele) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("请重新输入");
        }
        elements[index] = ele;
    }

    // 6):把指定元素替换为新元素
    public void change(Object oldEle, Object newEle) {
        int i = this.indexOf(oldEle);
        this.set(i, newEle);
    }

    // 7):删除指定索引位置的元素
//    public void remove(int index) {
//        this.set(index, null);
//        //size--;
//    }
    
    
    public void remove(int index){
        for (int i = index; i < size - 1; i++) {
            elements[index] = elements[index + 1];
        }
        elements[size - 1] = null;
        size--;
    }

    // 8):打印数组元素,打印风格:[11,22,33,44,55].
    public void toArray() {
        if (elements == null) {
            System.out.println("空数组");
        }
        if (size == 0) {
            System.out.println("[]");
        }
        StringBuilder sb = new StringBuilder(size);
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i != size - 1) {
                sb.append(",");
            } else {
                sb.append("]");
            }
        }
        System.out.println(sb);
    }
    // 9） 返回数组的元素个数
    public int size(){
        return size;
    }
    // 10) 判断数组中元素个数是否为0/数组是否为空
    public boolean isEmpty(){
        return size == 0;
    }
    // 11)清空数组所有元素
    public List<Object> clear(){
        return Collections.emptyList();
    }
    
    
    // 主方法
    public static void main(String[] args) {
        MyArrayList02 list02 = new MyArrayList02(5);
        list02.add("123");
        list02.add("456");
        list02.add("789");
        list02.remove(0);
        list02.toArray();
    }
}
