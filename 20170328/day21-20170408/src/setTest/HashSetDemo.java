//需求：往hashSet的对象增加对象，提供hashCode方法和equals方法，检查是否与原有元素重复
//步骤：（1）建hashSet对象
//（2）建三个类，一个只提供hashCode方法，一个只提供equals方法，一个两个都提供
//（3）建以上三个类的对象，分别用add方法加入hashSet对象各两次，看是否会被判断为同一个对象
package setTest;

import java.util.HashSet;

//建类，只提供hashCode方法
class Father01{
    @Override
    public int hashCode() {
        return 1;
    }
}
//建类，只提供equals方法
class Father02{
    @Override
    public boolean equals(Object obj) {
        return true;
    }
}
//建类，两个都提供
class Father03{
    @Override
    public int hashCode() {
        return 2;
    }
    @Override
    public boolean equals(Object obj) {
        return true;
    }
}
public class HashSetDemo {
    // 主方法
    public static void main(String[] args) {
        HashSet son = new HashSet();
//        Father01 blood01 = new Father01();
//        Father02 blood02 = new Father02();
//        Father03 blood03 = new Father02();
        //用add方法加入hashSet对象各两次
        son.add(new Father01());
        son.add(new Father01());
        son.add(new Father02());
        son.add(new Father02());
        son.add(new Father03());
        son.add(new Father03());
        
        //打印此时son中的元素个数，假如有元素被判断为同一个，打出数字会小于6
        System.out.println(son.size());
        //由于Father03类提供了两个方法，所以HashSet的对象son判定其对象两次加入时为同一个对象，后来的覆盖前一个
    }
}
/**
 * 小结：由于一个元素被加进HashSet的对象后，要检查是否与原有元素重复，先是hashCode,后是equals
 * 所以我们往HashSet的对象增加自定义对象时，要提供hashCode和equals方法，检查是否重复
 */
