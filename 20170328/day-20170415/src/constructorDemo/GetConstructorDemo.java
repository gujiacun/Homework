//需求：获取自定义类中的构造器
//（1）自定义一个User类，提供构造方法（公共无参，公共有参，私有有参），
//（2）在测试类中主方法中创建并调用getAll方法，拿User类的所有构造器
//（3）在测试类中主方法中创建并调用get方法，拿User类的某一个指定构造器
package constructorDemo;

import java.lang.reflect.Constructor;

class User{
    //字段
    String name;
    int age;
    // 公共无参构造器
    public User(){
        
    }
    // 公共有参构造器
    public User(int age) {
        super();
        this.age = age;
    }
    // 私有有参构造器
    private User(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
}
public class GetConstructorDemo {

    public static void main(String[] args) throws NoSuchMethodException, SecurityException {
        // 创建并调用getAll方法，拿User类的所有构造器
        getAll();
        // 创建并调用get方法，拿User类的某一个指定构造器
        get();
    }

    private static void get() throws NoSuchMethodException, SecurityException {
        // （1）先得到某个类的字节码对象
        Class<User> user = User.class;
        // （2）在通过字节码对象拿该类的指定构造器
        Constructor<User> aaa = user.getConstructor(int.class);
        System.out.println(aaa);
        Constructor<User> bbb = user.getConstructor();
        System.out.println(bbb);
        // 获取那个被private修饰的构造器，要用另外的方法
        Constructor<User> ccc = user.getDeclaredConstructor(String.class,int.class);
        System.out.println(ccc);
    }

    private static void getAll() {
        // (1)要拿某类的构造器，先拿该类的字节码对象
        // 通过类的class属性来获取该类的字节码对象,泛型填入该类
        Class<User> user = User.class;
        //(2)通过字节码对象调用getConstructors()方法获取该类的构造器
        //返回Constructors<?>[]
        Constructor<?>[] all= user.getConstructors();
        // 打印数组长度
        System.out.println(all.length);
        //迭代每一个得到的构造器
        for (Constructor<?> constructor : all) {
            System.out.println(constructor);
        }
        System.out.println("----------------------------------");
        //上述方法只能拿到该类中的公共构造器，若要无视访问权限得到所有构造器，用以下方法
        Constructor<?>[] all02= user.getDeclaredConstructors();
        
        // 打印数组长度
        System.out.println(all02.length);
        //迭代每一个得到的构造器
        for (Constructor<?> constructor : all02) {
            System.out.println(constructor);
        }
    }
}
/**
 * 小结：所有的数据类型都有class属性
 */
