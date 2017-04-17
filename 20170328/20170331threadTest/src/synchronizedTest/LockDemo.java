//需求：操作Lock类，新建Lock对象，操作加锁和解锁方法，配合try-catch-finally方法使用
package synchronizedTest;

import java.util.concurrent.locks.ReentrantLock;

class VirginWoman implements Runnable {
    private int virginWoman = 72;

    @Override
    public void run() {
        // 循环，i只表示循环次数
        for (int i = 0; i < 72; i++) {
            ReentrantLock key = new ReentrantLock();
            // 在这里加锁
            key.lock();
            if (virginWoman > 0) {
                // 若打印语句放在sleep后，则程序会出现数字错误
                System.out.println(Thread.currentThread().getName() + "抢走了" + "第" + virginWoman-- + "个处女");
                // 这里的sleep语句仅仅是让程序缓慢执行，在这里与主程序无关
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    // 在finally解锁，是因为程序一定会执行里面的语句，保证能解锁，但不放在finally里面也可以，但放更好
                } finally {
                    key.unlock();
                }
            }
        }
    }
}

public class LockDemo {

    public static void main(String[] args) {
        // 创建Runnable的实现类的对象
        VirginGirl goat = new VirginGirl();
        //调用带参数构造器，新建Thread对象，调用start方法
        new Thread(goat, "muslim01").start();
        new Thread(goat, "muslim02").start();
        new Thread(goat, "muslim03").start();
    }

}
/**
 * 小结：可重入锁与try-finally搭配效果得到保证
*/
