//需求：模拟网络延迟，当多个线程共用同一个公共资源时，用sleep方法使其陷入短暂休眠，观察打印结果
//（1）原来的代码并没有出现数字异常问题，在其中加上sleep观察
package sleepDemo;

class VirginLoli implements Runnable {
    private int virginLoli = 72;

    @Override
    public void run() {
        // 循环，i只表示循环次数
        for (int i = 0; i < 72; i++) {
            if (virginLoli > 0) {
                // 括号里的变量要填virginLoli，因为它才是表示共享的资源，同时由于被线程争夺，所以每次运行都要减少一个，执行自减操作
                // 在这里若要获取调用线程的对象的名称，用currentThread() ，返回对当前正在执行的线程对象的引用。是静态方法
                // 从上一步拿到Thread对象后，通过它调用getName方法
                try {
                    // 用sleep方法使其陷入短暂休眠，观察打印结果
                    Thread.sleep(333);
                    // 在这里只能使用捕获异常，因为父类Runnable的Run方法中没有抛出异常
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "抢走了" + "第" + virginLoli-- + "个处女");
            }
        }
    }
}

public class SleepTest {

    // 主方法
    public static void main(String[] args) {
        VirginLoli goat = new VirginLoli();
        // 这里调用的构造器为Thread(Runnable target, String name)
        new Thread(goat, "muslim01").start();
        new Thread(goat, "muslim02").start();
        new Thread(goat, "muslim03").start();

    }
}
/**
 * 小结：数字出现异常，因为三个线程抢着运用同一个公有资源，当一个线程抢到资源准备打印时可能被强制休眠，后面的线程再次拿到同一个资源并打印，使总数减少
 */
