// 需求：建父类子类，操作注解中的@inherited标签，用Class中的getAnnotations() 返回此子类上存在的所有注释。
// 新建一个注解，用@Target，@Retention，@inherited修饰，用在字段上
// 把注解放在父类的字段上，再获取并打印子类元素上所有的注解
package annotatiponTest;

import java.lang.annotation.Annotation;

// 建父类，字段被自定义注解修饰
@VIP02
class Fathers{
    String name;
}
// 建子类
@Deprecated
class Sons extends Fathers{
    int age;
}
public class InheritedTest {

    public static void main(String[] args) {
        // 得到子类元素所有的注解
        // (1)得到子类元素的字节码对象
        Class sonsClass = Sons.class;
        // (2)返回子类所有注解组成的数组
        Annotation[] array = sonsClass.getAnnotations();
        for (Annotation annotation : array) {
            System.out.println(annotation);
        }
        // 结果可知，子类包含父类中的@VIP02
        System.out.println(sonsClass.isAnnotationPresent(VIP02.class));
        System.out.println(sonsClass.isAnnotationPresent(Deprecated.class));
    }
}
/*
 * 小结：掌握自定义注解的格式，先建Annatation文件，建@Target，@Retention
 */
