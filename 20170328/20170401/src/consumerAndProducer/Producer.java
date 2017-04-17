package consumerAndProducer;

// 厨师类
public class Producer implements Runnable {
    // 声明食物类的对象，先不创建，等待构造器作为参数传入
    private ShareResource food = null;

    // 构造器作为参数传入食物类的对象
    public Producer(ShareResource food) {
        this.food = food;
    }

    @Override
    public void run() {
        // 循环，变量是偶/奇数就传特定的值
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                // 通过对象food调用其所在类的cook方法
                food.cook("人肉叉烧包", 10.0);
            } else {
                // 循环的出的结果不同，传入不同的值
                food.cook("云吞", 5.0);
            }
        }
    }

}
/**
 * 小结：若要在A类里，通过B类的对象来调用其实例方法，可以把对象作为A类的字段，通过构造器和this传入B类对象
 */