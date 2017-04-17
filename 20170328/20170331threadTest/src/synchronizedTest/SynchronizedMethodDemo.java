//需求：为解决多线程并发访问同一个资源产生的安全性问题，操作synchronized 修饰方法，进行同步操作
package synchronizedTest;

class VirginGirl implements Runnable {
    private int virginGirl = 72;

    @Override
    public void run() {
        // 循环，i只表示循环次数
        for (int i = 0; i < 72; i++) {
            // 同步代码块，这里的同步锁是当前线程的对象，muslim01，但若语句放在for的上一句，所有资源就会被第一个对象执行完毕
            // this表示调用此方法的对象，由此对象调用另外的实例方法get
            this.get();

        }
    }

    // 把要用来同步的代码块另外包装成另外一个方法，在原来的方法中调用它
    // 记得要在方法前加上synchronized修饰符
    synchronized public void get() {
        if (virginGirl > 0) {
            // 若打印语句放在sleep后，则程序会出现数字错误
            System.out.println(Thread.currentThread().getName() + "抢走了" + "第" + virginGirl-- + "个处女");
            // 这里的sleep语句仅仅是让程序缓慢执行，在这里与主程序无关
            try {
                Thread.sleep(100);
                // 捕获异常
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class SynchronizedMethodDemo {

    public static void main(String[] args) {
        // 创建Runnable的实现类的对象
        VirginGirl goat = new VirginGirl();
        new Thread(goat, "muslim01").start();
        new Thread(goat, "muslim02").start();
        new Thread(goat, "muslim03").start();
    }

}
/**
*小结：由于synchronized的性能较低，应该尽量减少它的作用域
*/