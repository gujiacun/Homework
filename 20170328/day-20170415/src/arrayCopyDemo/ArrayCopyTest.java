//需求：用反射把旧数组部分元素拷贝到新数组中，用反射实现任意数据类型数组的拷贝
//步骤：（1）在主方法新建旧数组，动态建新数组，建arrayCopyDIY方法，参数为Object src, int srcPos, Object dest, int destPos, int length
//（2）检测一：检测目标/源是否为null，抛出空指针异常
//检测二：由于传进来的是Object，检测目标/源的真实类型是否都为数组，抛出ArrayStoreException
//检测三：检测数组索引是否越界
//检测四：源和目标的元素类型是否相同，抛出ArrayStoreException
//（3）拷贝移位用for循环拿到源数组每个元素，把旧数组元素赋给新数组某些位置
package arrayCopyDemo;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayCopyTest {

    public static void main(String[] args) {
        // 建旧数组，动态建新数组
        int[] oldArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int[] newArray = new int[9];
        System.out.println(Arrays.toString(newArray));
        arrayCopyDIY(oldArray, 2, newArray, 4, 5);
        System.out.println(Arrays.toString(newArray));
    }

    public static void arrayCopyDIY(Object src, int srcPos, Object dest, int destPos, int length) {
        if (src == null || dest == null) {
            throw new NullPointerException("源和目标不能为空");
        }
        if (!src.getClass().isArray() || !dest.getClass().isArray()) {
            throw new ArrayStoreException("源和目标都为数组");
        }
        if (srcPos < 0 || destPos < 0 || length < 0 || srcPos + length > Array.getLength(dest) || destPos + length > Array.getLength(dest)) {
            throw new ArrayIndexOutOfBoundsException("数组索引越界啦");
        }
        if (src.getClass().getComponentType() != dest.getClass().getComponentType()) {
            throw new ArrayStoreException("源和目标元素类型必须相同");
        }
        for (int i = srcPos;i < srcPos + length;i++) {
            // 从旧数组中获取需要拷贝的元素
            Object temp = Array.get(src, i);
            // 把需要拷贝的元素复制到新数组的指定位置
           Array.set(dest, destPos, temp);
           // 每一次往新数组增加元素，destPos都会增加1
           destPos++;
        }
    }

}

/**
 * 
 *小结：get(Object array, int index) 
          返回指定数组对象中索引组件的值
          
   set(Object array, int index, Object value) 
          将指定数组对象中索引组件的值设置为指定的新值。
          
          
    注意Array类中的方法set方法和get方法的格式
 */