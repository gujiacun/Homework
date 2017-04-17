//需求：厨师给消费者提供食物，消费者买走食物，把这三样事物抽象为三个类，实现低耦合的架构
//分析：由于两个厨师类和消费者类之间有共享资源（食物类的成员），在多线程共享同一资源时，用实现Runnable接口方式好
//（1）先新建三个类；消费者类和厨师类用实现Runnable接口实现线程
//（2）在测试类主方法中新建食物类的对象，新建Thread类的匿名对象调用start方法启动线程
//在上一步中把厨师类的匿名对象作为参数传入构造器，再在其中传食物类的对象。消费者类同理
//（3）没有食物时，消费者无法买走食物，此时厨师生产食物，食物出现后，此时厨师停止生产，消费者买走食物，
//（4）食物类有两字段，食物名和价格。有cook方法，用于厨师类向实物类存储数据，参数是食物名和价格，用this赋给字段
//（5）食物类有buy方法，用于消费者类购买食品，打印信息
//（6）厨师类通过构造器传入食物类的对象，把它作为字段，在重写的run方法中建循环，通过对象调用实物类中的cook方法
//变量是偶/奇数就传特定的值
//（7）消费者类与上面同理，建循环，通过构造器传入的对象，被用来循环调用实物类的buy方法

//改善：（1）出现混乱，用Lock类解决
//（2）我们希望生产一个食物，消费一个食物，即打印时交替出现，要while循环判断，用Condition接口对象的await和signal来限制线程
package consumerAndProducer_lock;

//测试类
public class Test {
    // 主方法
    public static void main(String[] args) {
        ShareResource food = new ShareResource();
        // Thread cunsumer01 = new Thread();
        // Thread cunsumer02 = new Thread();
        // Thread producer01 = new Thread();
        // Thread producer02 = new Thread();
        new Thread(new Producer(food)).start();
        new Thread(new Consumer(food)).start();
    }

}
/**
 * 小结：（1）若要在A类里，通过B类的对象来调用其实例方法，可以把对象作为A类的字段，通过构造器和this传入B类对象
 * 但是此代码有问题，它只会显示云吞价格为5.0，而不会显示另一个信息，在下面改进。
 * （2）在食物类的cook方法的输入菜名和价格之间令程序休眠10毫秒，再令buy方法的打印语句休眠10毫秒，发生混乱
 */
