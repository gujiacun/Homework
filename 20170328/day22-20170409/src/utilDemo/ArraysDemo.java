//需求：操作Arrays工具类和Collections工具类的一些方法
package utilDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysDemo {
    //主方法
    public static void main(String[] args) {
        //新建集合
        List<Integer> list = new ArrayList<>();
        //底层自动装箱
        list.add(20);
        list.add(96);
        list.add(-36);
        list.add(90);
        System.out.println(list);
        // 把集合转换为数组,调用Collection接口中的方法,返回Object数组
        Object[] array = list.toArray();
        // 把数组转换为集合，赋值符号右边是Object数组，左边的泛型要与之保持一致
        List<Object> list2 = Arrays.asList(array);
        //把数组转换为集合，也可以直接在括号里输入数组元素
        List<Integer> list3 = Arrays.asList(30,98,-12,879);
        //但以下情况报错
        int[] arr = {1,2,3,4,5};
        //因为左边是Integer类型，右边是int[],除非把左边转为int[]
        List<int[]> list4 = Arrays.asList(arr);
        System.out.println(list2);
        System.out.println(list3);
        System.out.println(list4);
        
        
        Integer[] arr00 = {1,2,3,4,5};
        List<Integer> list00 = Arrays.asList(arr00);
    }
}
/**
 * 小结：小心使用集合与数组的互相转换，记住格式，必要时查文档
 */
