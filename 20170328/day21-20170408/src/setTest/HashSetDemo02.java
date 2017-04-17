//需求：往hashSet的对象增加对象，根据对象的字段自定义规则，检查是否与原有元素重复
//（1）建HashSet对象
//（2）定义学生类，添加学号，姓名，性别字段，构建带参构造器，根据字段自定义规则（hasgCode和equals）检查重复
//（3）把学生类的对象传入HashSet对象，打印元素个数
package setTest;

import java.util.HashSet;
import java.util.Set;

//定义学生类,根据字段自定义规则,检查元素是否重复
class Student {
    int number;
    String name;
    String sex;

    public Student(int number, String name, String sex) {
        this.number = number;
        this.name = name;
        this.sex = sex;
    }
//此时是根据number来定义检查规则，若对象之间的number一样，即使其它数据一样，也会被判断为同一个对象
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + number;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (number != other.number)
            return false;
        return true;
    }

}

public class HashSetDemo02 {

    public static void main(String[] args) {
        // 建HashSet对象，要用泛型，类型定为学生类
        Set<Student> set = new HashSet<Student>();
        // 两个对象除学号外，其它数据均不相同
        set.add(new Student(1, "华莱士", "male"));
        set.add(new Student(1, "张宝华", "female"));
        //但是自定义规则，判断为同一个对象
        System.out.println(set.size());
    }
}
/**
 * 小结：如要把自定义的对象存储到哈希表中,该类型 的对象应该覆盖equals和hashCode方法, 并在该方法中提供自己的判断规则.
 * 请自动生成hashCode和equals方法.要根据哪个字段来判断， 就重写哪个字段的equals，hashCode方法
 */
