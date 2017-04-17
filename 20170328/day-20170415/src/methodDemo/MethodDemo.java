//需求：用反射获取类中的方法
//（1）建User类，建方法（公共无参，公共有参，私有有参）
//（2）在测试类中建方法getAll（获取所有方法），getOne（获取某个特定方法）
package methodDemo;

import java.lang.reflect.Method;

class User{
    public void doWork(){
        System.out.println("我是公共无参");
    }
    public void doWork(String name){
        System.out.println("我是公共有参" + name);
    }
    private void doWork(String name,int age){
        System.out.println("我是私有有参" + name + age);
    }
}
public class MethodDemo {

    public static void main(String[] args) throws Exception {
        //getAll();
        getOne();

    }

    private static void getOne() throws Exception {
        //(1)获取类的字节码对象
        Class<User> userClass = User.class;
        //(2)通过字节码对象获取类中某个特定的公共方法
        // getMethod("方法名",方法参数的Class类型)
        Method way01 = userClass.getMethod("doWork");
        // invoke(Class对象.newInstance(),new Object[]{})
        way01.invoke(userClass.newInstance());
        
        Method way02 = userClass.getMethod("doWork",String.class);
        way02.invoke(userClass.newInstance(), new Object[]{"美国记者华莱士"});
        
        //获取某个特定的私有方法
        Method way03 = userClass.getDeclaredMethod("doWork", String.class,int.class);
        //设置该私有方法可以被访问
        way03.setAccessible(true);
        way03.invoke(userClass.newInstance(), new Object[]{"湖南辣妹",50});
                
    }

    private static void getAll() {
        //(1)获取类的字节码对象
        Class<User> userClass = User.class;
        //(2)通过字节码对象获取类中的所有公共方法(包括继承与父类或接口的)
        Method[] arr01 = userClass.getMethods();
        //打印验证
        System.out.println(arr01.length);
        for (Method method : arr01) {
            System.out.println(method);
        }
        System.out.println("---------------------------------------");
        //(3)获取类中的所有方法(不包括继承与父类或接口的)
        Method[] arr02 = userClass.getDeclaredMethods();
        for (Method method : arr02) {
            System.out.println(method);
        }
    }
/**
 * 小结：获取一个类的私有成员时，在拿到它相对应的对象后，一定要通过setAccessible把设为true，再调用
 */
}
