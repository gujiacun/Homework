//需求：3个穆斯林上了天堂，有72个处女等着他们，他们要抢来当老婆，请用线程相关知识(实现Runnable接口)来实现。
//步骤：（1）72个处女是共享的资源，单独建类(实现Runnable接口)，
//（2）先建一个自定义类的对象，再调用Thread类带参构造器传入对象，新建3个Thread类的muslim对象，通过此调用start方法
//（3）处女数量随着3个线程的争夺而减少，直至0
package threadDemo;

class VirginLoli implements Runnable {
    private int virginLoli = 72;

    @Override
    public void run() {
        //循环，i只表示循环次数
        for (int i = 0; i < 72; i++) {
            if (virginLoli > 0) {
                //括号里的变量要填virginLoli，因为它才是表示共享的资源，同时由于被线程争夺，所以每次运行都要减少一个，执行自减操作
                //在这里若要获取调用线程的对象的名称，用currentThread() ，返回对当前正在执行的线程对象的引用。是静态方法
                //从上一步拿到Thread对象后，通过它调用getName方法
                System.out.println(Thread.currentThread().getName() + "抢走了" + "第" + virginLoli -- + "个处女");
            }
        }
    }
}

// 测试类
public class EatingApple02 {
    // 主方法
    public static void main(String[] args) {
        VirginLoli goat = new VirginLoli();
        // 这里调用的构造器为Thread(Runnable target, String name)
        new Thread(goat,"muslim01").start();
        new Thread(goat,"muslim02").start();
        new Thread(goat,"muslim03").start();

    }

}
/**
 * 小结：本次没有出现数字混乱，因为实现Runnable接口，建了一个VirginLoli实现类的对象，三个Thread类的对象在创建时都调用了同一个对象，即多线程共享同一个资源
 */
