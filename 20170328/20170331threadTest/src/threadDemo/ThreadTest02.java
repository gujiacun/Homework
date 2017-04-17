//需求：线程的创建和启动，方法二：实现Runnable类
//（1）创建一个类，实现Runnable接口（implements）
//（2）在自定义类内重写run方法，在方法内写线程执行体
//（3）在主方法创建自定义的对象（普通创建或多态创建）
//（4）在主方法调用Thread类的构造器，并把自定义类的对象作为参数传入
//（5）通过Thread类的对象调用start方法，启动线程
package threadDemo;

class Daughter implements Runnable {

    @Override//表示判断方法是否被重写
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("AKB:君の心にも 川が流れる,汗と涙の川だ!失敗してしまっても,流されてしまっても" + i);
        }
    }
}

// 测试类
public class ThreadTest02 {
    // 主方法
    public static void main(String[] args) {
        //此句可以放在for循环里面或外面，可以写为Daughter hongkongReporter = new Daughter(); 
        Runnable hongkongReporter = new Daughter();
        for (int i = 0; i < 10; i++) {
            //此句只能放在循环里
            Thread wallace = new Thread(hongkongReporter);
            System.out.println("平手：歩道橋を駆け上がると,夏の青い空がすぐそこにあった" + i);
            //通过Thread类的对象调用start方法，启动线程
            wallace.start();
        }
    }
}
/**
 * 小结：此方法较为麻烦，但核心就是调用Runnable类的带参数构造器，再通过对象调用方法
 */