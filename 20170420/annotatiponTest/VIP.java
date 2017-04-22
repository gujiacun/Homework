package annotatiponTest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 指定注解只能放在类和方法上
@Target({ ElementType.TYPE, ElementType.METHOD })
// 制定注解能存活到JVM运行
@Retention(RetentionPolicy.RUNTIME)
public @interface VIP {
// 注解接口是特殊的接口，里面的都是抽象方法,所以后面都要跟()
//    String name();
//    int age();
//    int[] array();
    // 不支持基本数据类型的包装类
    //报错：Integer num();
    
    int value() ;
    int age();
    String hobby() default "扎心了，老铁";
}
