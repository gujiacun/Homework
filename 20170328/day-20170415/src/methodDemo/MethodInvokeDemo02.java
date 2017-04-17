//需求：用反射调用静态方法，调用数组参数
//步骤：（1）新建Worker类，建两个公共静态方法，参数类型分别为int数组，String数组
//（2）在主方法中创建Worker类的字节码对象，通过字节码对象获取某个特定方法的对象，通过方法对象调用方法
package methodDemo;

import java.lang.reflect.Method;
import java.util.Arrays;

class Worker{
    public static void doWork(int[] array){
        System.out.println(Arrays.toString(array));
    }
    public static void doWork(String[] array){
        System.out.println(Arrays.toString(array));
    }
}
public class MethodInvokeDemo02 {

    public static void main(String[] args) throws Exception {
        // 创建Worker类的字节码对象
        Class<Worker> wClass = Worker.class;
        // 通过字节码对象获取特定方法的对象
        Method way01 = wClass.getMethod("doWork", int[].class);
        // 通过特定方法的对象调用方法，由于是静态方法，不属于任何实例，invoke方法第一个参数填null
        way01.invoke(null, new Object[]{new int[]{1,2,3}});
        Method way02 = wClass.getMethod("doWork", String[].class);
        way02.invoke(null, new Object[]{new String[]{"excited","续1秒！"}});
    }
/**
 * 小结：使用反射调用静态方法，invoke第一个参数填null。调用数组参数时，用new Object[]{}包围
 */
}
