//需求：创建一个类的字节码对象
//创建Class类的对象,如何来表示一个字节码对象
//Class类的实例:   在JVM中的一份份字节码
package class_instance;

public class ClassInstanceDemo {

    public static void main(String[] args) throws Exception {
        // 方法一：所有的数据类型都有class属性,使用class属性
        Class<java.util.Date> clz01 = java.util.Date.class;
        // 方法二：先创建某个类的对象，由于此对象继承于Object类，再通过此对象调用getClass() 返回此 Object 的运行时类
        java.util.Date time = new java.util.Date();
        //Class getClass();
        Class<?> d = time.getClass();
        // 方式三：通过Class类中的forName(String className) 返回与带有给定字符串名的类或接口相关联的 Class 对象。
        Class<?> dd = Class.forName("java.util.Date");
    }
}
/**
 * 小结：第三种方式要求给出该类的路径，返回该类的字节码对象，常用于自定义类的加载
 * 方式二，如果已经存在该类的对象，用getClass返回该类的字节码对象
 */
