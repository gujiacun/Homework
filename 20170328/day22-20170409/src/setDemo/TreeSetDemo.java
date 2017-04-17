//需求：有四个学生，个人信息为名字和年龄，请用TreeSet按照他们的年龄从小到大排序，并打印
//步骤：（1）在主方法新建TreeSet对象，新建Student类，在主方法建Person类的四个对象
//（2）在对象类中建2个字段，姓名和年龄，根据年龄自然排序，实现Comparable借口，重写compareTo方法
//（3）Student类的四个对象输入TreeSet对象，打印
package setDemo;

import java.util.TreeSet;

//对象类（学生及其信息）
//由于要实现对象的自然排序，先把传入TreeSet集合的对象的类实现Comparable接口，再重写comapreTo方法
class Student implements Comparable<Student> {
    // 学生信息
    String name;
    int age;

    // 根据信息（字段）创建带参构造器，在创建对象时直接传入参数
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 重写comapreTo方法
    @Override
    public int compareTo(Student o) {
        if (o.age > this.age) {
            return -1;
        } else if (o.age < this.age) {
            return 1;
        } else {
            return 0;
        }
    }

    // 注意要重写toString方法，否则会输出内存地址
    @Override
    public String toString() {
        return "name:" + this.name + "   age:" + this.age;
    }
}

// 测试类
public class TreeSetDemo {
    // 主方法
    public static void main(String[] args) {
        TreeSet<Student> classRoom = new TreeSet<>();
        // 新建Student类的对象
        Student jack = new Student("西方记者Wallace", 20);
        Student mary = new Student("香港记者张宝华", 21);
        Student frog = new Student("上海书记", 999);
        Student girl = new Student("苗族辣妹", 50);
        // 调用TreeSet中的实例方法，把元素传入
        classRoom.add(jack);
        classRoom.add(mary);
        classRoom.add(frog);
        classRoom.add(girl);
        System.out.println(classRoom);
    }
}
/**
 * 小结：在TreeSet中，普通的类一般都实现了compareTo方法，但若要传入自定义类的对象，自习重写方法
 */
