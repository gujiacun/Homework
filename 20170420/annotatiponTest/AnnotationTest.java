//需求：使用JDK自带的注解/标签
package annotatiponTest;

import java.util.Date;


class Father{
    public void tell(){
        System.out.println("1");
    }
}
class Son extends Father{
    // 标记此方法重写了父类中的同名方法
    // 从源代码可看出，此标签只能用于方法
    @Override
    public void tell(){
        System.out.println("2");
    }
}
// 写@SuppressWarnings("all")把所有类型的警告都包含其中,这样类下面的元素不必写压制警告的标签
@SuppressWarnings("all")
public class AnnotationTest {

    public static void main(String[] args) {
        // 标记此方法已过时
        Date d = new Date();
       // 方法被一条横线划去，表明此方法已过时，从源代码可看出，造成此效果是因为方法上行加上@Deprecated
        d.toLocaleString();
        
        // 抑制编译器发出的黄色警告
        @SuppressWarnings("unused")
        String name;
        // 当多个程序元素拥有程序警告，可以把它们的@SuppressWarnings放在比它们高一级的东西上
        // 方法内的元素把警告放在方法上，几个方法的警告放在类上，这样只需写一次
        // 还可以写@SuppressWarnings("all")把所有类型的警告都包含其中
        @SuppressWarnings("unused")
        int age;
        
    }
    //在以下没过时的方法上也加上@Deprecated,方法同样被一条横线划去
    @Deprecated
    public void work(){
        
    }
    //在以下没过时的方法上加上文档注释，里面写@deprecated,方法同样被一条横线划去
    /**
     * @deprecated
     */
    public void doWork(){
        
    }
}
/**
 * 注解/标签就是粘在字段/方法/类等等上面的"@XXXX"。元注解即放在注解上面的注解，与@Target,@Retention有关
 * 前一个限制注解的作用对象，ElementType有关。后一个限制注解的持续时间，RetentionPolicy有关
 */
