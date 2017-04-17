//需求：操作线程相关的方法，了解线程的6种状态
package thread_state;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//新建frog类，继承Thread类
class frog extends java.lang.Thread {
    // 用同步锁，确保同一时间只有一个线程对象调用方法，所以总有一个线程处于阻塞状态
    Lock key = new ReentrantLock();

    public void run() {
        try {
            // 获取锁
            key.lock();
            for (int i = 0; i < 50; i++) {
                if (i % 2 == 0) {
                    System.out.println("年轻人要提高自己的姿势水平");
                    // 执行sleep方法，线程进入计时等待状态
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("苟利国家生死以，岂因祸福避趋之");
                }
            }
        } finally {
            // 解锁
            key.unlock();
        }
    }
}

// 测试类
public class ThreadState {
    // 主方法
    public static void main(String[] args) {
        // 新建线程，此时还没被启动，是新建状态
        Thread frog = new frog();
        Thread president = new frog();
        // 调用start方法，线程从新建状态转入就绪状态，当线程对象获得JVM调度的资源时，正式开始运行
        frog.start();
        president.start();
    }

}

/**
 * 小结：线程分为6种状态，注意可以用方法使它们进入新的状态
 */