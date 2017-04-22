package annotatiponTest;

import java.lang.annotation.Annotation;

public class VIPDemo {

    public static void main(String[] args) {
     // 用反射获取类上的注解
        // (1)获取元素的字节码对象；（2）通过字节码对象用getAnnotations拿到所有注解的数组，循环打印
        Class<Employee> clz = Employee.class;
        Annotation[] array = clz.getAnnotations();
        for (Annotation annotation : array) {
            // SuppressWarnings("rawtypes")只存在于source文件。编译过后就消失
            System.out.println(annotation);
        }
        // 用反射判断指定类型的注释是否存在于此元素上
        System.out.println(clz.isAnnotationPresent(VIP.class));
        System.out.println("============================");
        //获取注解VIP中的三个属性
        //（1）获取被贴元素的字节码对象
        @SuppressWarnings("deprecation")
        Class<Employee> class1 = Employee.class;
        //（2）由于注解接口是特殊接口，通过字节码对象获取指定的VIP注解对象，再强转为VIP接口的实例
        VIP vip = (VIP) class1.getAnnotation(VIP.class);
        //（3）通过VIP接口的实例调用里面的抽象方法，打印
        System.out.println(vip.age());
        System.out.println(vip.hobby());
        System.out.println(vip.value());
    }
}
/**
 * 小结：自定义注解时，要根据具体情况而定，不支持基本数据类型的包装类，同时要注意各个注解的生存时间
 */
