package consumerAndProducer_lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//食物类
public class ShareResource {
    // 两字段，用String类型和double来存储食物的名称和价格
    private String name;
    private double price;
    // 用boolean来表达食物是否为空，以此做判断条件，限制生产者/消费者是否该生产/消费
    private boolean isEmpty = true;
    // 用lock限制线程访问
    Lock key = new ReentrantLock();
    // 创建Condition对象，调用其中的await和signal方法
    Condition locker = key.newCondition();

    // 在Producer类中会调用此方法，被传入name和price
    public void cook(String name, double price) {
        // 判断条件是否成立一般用if，但由于这里被循环调用，用while，表示当食物不空，厨师休息
        // 获取锁
        key.lock();
        // 用try-finally包围，保证最后一定会解锁，避免死锁
        try {
            // 判断食物非空时，厨师线程进入等待池
            while (!isEmpty) {
                try {
                    // 食物存在时，厨师线程进入等待池
                    locker.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 假如食物空了，厨师开始生产食物
            this.name = name;
            // 在厨师调用cook方法，向这里输入菜名和价格中间令程序休眠10毫秒，可能会出现菜名和价格混乱情况
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.price = price;
            // 食物满了，唤醒消费者线程来消费（调用buy方法）
            locker.signal();
            // 生产完毕后，食物满了，更改isEmpty的状态
            isEmpty = false;

        } finally {
            // 解锁
            key.unlock();
        }
    }

    // 在Consumer类中会调用此方法，那里是循环语句，所以此方法会重复执行
    public void buy() {
        // 用try-finally包围，保证最后一定会解锁，避免死锁
        key.lock();
        try {
            while (isEmpty) {
                try {
                    locker.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 买食物
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.name + "价格为" + this.price);

            // 当食物为空，消费者进入等待池，等待另外线程唤醒
            locker.signal();
            // 买完食物后，食物状态更改，唤醒厨师线程
            isEmpty = true;
        } finally {
            // 解锁
            key.unlock();
        }
    }
}
/**
 * 小结：若要在A类里，通过B类的对象来调用其实例方法，可以把对象作为A类的字段，通过构造器和this传入B类对象
 */