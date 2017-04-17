//需求：为解决多线程并发访问同一个资源产生的安全性问题，操作synchronized 修饰代码块，进行同步操作
//以下代码原来会有数字混乱问题，先用synchronized修饰
package synchronizedTest;

class VirginLoli implements Runnable {
    private int virginLoli = 72;

    @Override
    public void run() {
        // 循环，i只表示循环次数
        for (int i = 0; i < 72; i++) {
            // 同步代码块，这里的同步锁是当前线程的对象，muslim01，但若语句放在for的上一句，所有资源就会被第一个对象执行完毕
            synchronized (this) {
                if (virginLoli > 0) {
                    // 若打印语句放在sleep后，则程序会出现数字错误
                    System.out.println(Thread.currentThread().getName() + "抢走了" + "第" + virginLoli-- + "个处女");
                    //这里的sleep语句仅仅是让程序缓慢执行，在这里与主程序无关
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

public class SynchronizedBlockDemo {

    public static void main(String[] args) {
        //创建Runnable的实现类的对象
        VirginLoli goat = new VirginLoli();
        new Thread(goat, "muslim01").start();
        new Thread(goat, "muslim02").start();
        new Thread(goat, "muslim03").start();
    }

}
/**
 * 小结：我们把当前并发访问的共同资源作为同步监听对象，同步锁能令在同一时刻，拿到锁的只有一个线程，其余线程只能在外面等待
 */
