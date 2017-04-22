// 需求：自定义一个注解
// 步骤：（1）创建Annatation文件
//（2）用@Target(ElementType.常量)限制其作用对象，用Retention(RetentionPolicy.常量)限制持续时间
//（3）再用@inherited修饰，表示被子类继承
package annotatiponTest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 注意格式，后面不能跟;符号
@Target({ElementType.FIELD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface VIP02 {

}
