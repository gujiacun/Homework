//需求：操作反射其他的API
package otherReflect;

enum Weekday{
    MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY
}
abstract class Father{
    
}
class Son extends Father{
    
}
public class OtherReflect {

    public static void main(String[] args) {
        // Class类中:要调用Class类的方法，先得创建其实例，即创建某个类的字节码对象
        Class<Father> f = Father.class;
        // int getModifiers():获得修饰符
        System.out.println(f.getModifiers());
        // String getName():返回类的全限定名
        System.out.println(f.getName());
        // Package getPackage():获得该类的包
        System.out.println(f.getPackage());
        // String getSimpleName():获得类的简单名字
        System.out.println(f.getSimpleName());
        //
        // Class getSuperclass():获得类的父类
        Class<Son> s = Son.class;
        System.out.println(s.getSuperclass());
        // boolean isArray():判断该Class实例是否是数组
        System.out.println(f.isArray());
        // boolean isEnum() :判断该Class实例是否是枚举
        System.out.println(f.isEnum());
        
        //枚举的对象的数据类型就是枚举本身
        System.out.println(Weekday.MONDAY.getClass());
    }
}
/**
 * 小结：用枚举做单例，不接受反射的获取构造器的方法
 */
