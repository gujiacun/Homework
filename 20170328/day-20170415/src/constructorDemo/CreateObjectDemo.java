//需求：用反射调用构造器并利用此创建对象
//步骤：（1）建Person类，提供三个不同构造方法，（公共无参，公共有参，私有有参），各自打印一句话
//（2）在测试类中，先用传统方式创建Person类对象
//（3）反射创建对象，先拿到Person类的字节码对象，通过字节码对象拿构造器对象（三种方式），
//（4）通过构造器对象用newInstance传入参数，创建对象
package constructorDemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class Person{
    String name;
    int age;
    //公共无参
    public Person(){
        System.out.println("我是公共无参");
    }
    //公共有参
    public Person(int age) {
        this.age = age;
        System.out.println("我是公共有参" + age);
    }
    //私有有参
    private Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("我是私有有参" + name + age);
    }
}
public class CreateObjectDemo {

    public static void main(String[] args) throws Exception {
        // 传统方式创建Person类对象
        //Person person01 = new Person();

        // 先建Person类的字节码对象
        Class<Person> personClass = Person.class;
        // 通过字节码对象调用getConstructor方法，返回Constructor的对象
        Constructor<Person> c01 = personClass.getConstructor();
        // 上一步只是拿到构造器对象，尚未调用
        c01.newInstance();
        
        //上一步拿的是公共无参构造器，要拿公共有参构造器，在getConstructor()里写参数的class类型
        c01 = personClass.getConstructor(int.class);
        c01.newInstance(100);
        
        //要拿被private修饰的构造器，要先用getDeclaredConstructor拿（无视访问权限）
        //把Constructor的对象设为可访问，用newInstance调用构造器（传入参数）
        c01 = personClass.getDeclaredConstructor(String.class,int.class);
        c01.setAccessible(true);
        c01.newInstance("江主席",100);
    }
/**
 * 当构造器被private修饰，要拿它的对象，要用getDeclaredConstructor拿，设为可访问，再调用
 */
}
