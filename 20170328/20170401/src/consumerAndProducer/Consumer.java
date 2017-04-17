//需求：厨师给消费者提供食物，消费者买走食物，把这三样事物抽象为三个类，实现低耦合的架构
//分析：由于两个厨师类和消费者类之间有共享资源（食物类的成员），在多线程共享同一资源时，用实现Runnable接口方式好
//（1）先新建三个类；消费者类和厨师类用实现Runnable接口实现线程
//（2）在测试类主方法中新建厨师类和消费者类的对象
//（3）没有食物时，消费者无法买走食物，此时厨师生产食物，食物出现后，此时厨师停止生产，消费者买走食物，
//（4）食物类有两字段，食物名和价格。有cook方法，用于厨师类向实物类存储数据，参数是食物名和价格，用this赋给字段
//（5）食物类有buy方法，用于消费者类购买食品，打印信息
package consumerAndProducer;

// 消费者类
public class Consumer implements Runnable {
    //声明食物类的对象，先不创建，等待构造器作为参数传入
    private ShareResource food = null;

    // 构造器作为参数传入食物类的对象
    public Consumer(ShareResource food) {
        this.food = food;
    }

    // 要调用食物类的buy方法，要通过其对象，把其对象作为本类字段
    @Override
    public void run() {
        // 重复打印
        for (int i = 0; i < 100; i++) {
            //通过对象food调用其所在类的buy方法
            food.buy();
        }
    }

}
/**
 * 小结：若要在A类里，通过B类的对象来调用其实例方法，可以把对象作为A类的字段，通过构造器和this传入B类对象
 */