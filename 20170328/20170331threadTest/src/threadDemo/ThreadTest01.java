//需求：线程的创建和启动，方法一：继承Thread类
//步骤：（1）创建一个类，继承Thread类（extends）
//（2）在自定义类中重写run方法，在方法内编写线程执行体
//（3）在主方法内创建自定义类的对象
//（4）通过对象调用start方法，启动线程
package threadDemo;
class Son extends Thread{
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("我说无可奉告，你们又不高兴，我说资茨，今天就明确告诉你们这一点");
        }
    }
}
//测试类
public class ThreadTest01 {
    //主方法
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Son dick = new Son();
            System.out.println("江主席，林郑月娥当特首，中央支持不支持");
            dick.start();
        }
    }
}
/**
 * 小结：假如Thread对象直接调用run方法，就是普通的通过对象调用实例方法，只有通过start方法才是启动线程
 */
