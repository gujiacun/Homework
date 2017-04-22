// 需求：自定义注解并使用
// 步骤：（1）建Annotation文件（建VIP注解）。指定Target（作用对象）和Retention（存留时间），public @interface VIP{}
//(2)在测试类Employee贴VIP注解，然后在注解的类中测试一/两个抽象方法，看基本类型的包装类是否可行，变量名为value时测试类中的value是否可以省略，String数组，为抽象方法设默认值
//(3)用反射获取程序元素上的注解
//(4)建第三方程序VIPDemo.java,赋予注解功能，功能为来获取Employee上所有注解
//(5)在VIPDemo.java,上，先获取Employee的字节码对象，再通过字节码对象获取该类所有注解，循环打印
//(6)在测试类Employee上再增加  过时/压制全部警告   的注解，在VIPDemo类中打印全部注解，解释原因。再判断测试类Employee上是否使用某注解(用字节码对象使getAnnotation方法)
//(7)在测试类Employee里增加一个方法，方法上增加注解，判断这个方法是否有使用这个注解
//(8)用getAnotation获取单个注解，通过此获得注解里面的属性，给其中一些属性设置默认值


package annotatiponTest;

import java.lang.annotation.Annotation;

// 当且仅当注解只有一个属性，而且属性名为value时，注解可以省略value=
// 当注解中有属性是有默认值时，在使用注解是可以不给它传值
@VIP(value = 3,age = 5)
@Deprecated
@SuppressWarnings("rawtypes")
public class Employee {

    public static void main(String[] args) {
        // 用反射获取程序元素上的注解
        // (1)获取元素的字节码对象；（2）通过字节码对象用getAnnotations拿到所有注解的数组，循环打印
        Class clz = Employee.class;
        Annotation[] array = clz.getAnnotations();
        for (Annotation annotation : array) {
            System.out.println(annotation);
        }
        
    }
}
/**
 * 小结：自定义注解，@Target里面若想定义多个位置，如@Target({ElementType.METHOD,ElementType.TYPE})
 * 中间要用{}括住
 */
