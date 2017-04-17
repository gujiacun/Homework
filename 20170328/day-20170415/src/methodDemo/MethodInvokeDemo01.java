//需求：使用反射调用方法
//步骤：（1）新建Person类，建方法（公共无参，公共有参，私有有参）
//（2）在主方法中创建Person类的字节码对象，通过字节码对象获取某个特定方法的对象，通过方法对象调用方法
package methodDemo;

import java.lang.reflect.Method;

class Person{
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

public class MethodInvokeDemo01 {

    public static void main(String[] args) throws Exception {
        // (1)建Person类的字节码对象
        Class<Person> perClass = Person.class;
        // (2)通过字节码对象获取某个特定方法的对象
        Method way01 = perClass.getMethod("doWork");
        // (3)通过某个特定方法的对象，用invoke传入参数，调用方法
        way01.invoke(perClass.newInstance(), new Object[]{});
        
        // 调用公共有参,由于同一个类的字节码对象只有一份，不用重复建
        Method way02 = perClass.getMethod("doWork", String.class);
        way02.invoke(perClass.newInstance(), "香港记者张宝华");
        
        //调用私有有参方法
        //通过字节码对象获取方法对象
        Method way03 = perClass.getDeclaredMethod("doWork", String.class,int.class);
        //把方法的访问权限设为可访问
        way03.setAccessible(true);
        //通过方法对象传入参数，调用方法
        way03.invoke(perClass.newInstance(), "林则徐诗篇朗诵者",100);
    }
}
/**
 * 小结：要记住getMethod和invoke的格式
 */
