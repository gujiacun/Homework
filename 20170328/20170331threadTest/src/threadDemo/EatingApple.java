//需求：3个穆斯林上了天堂，有72个处女等着他们，他们要抢来当老婆，请用线程相关知识(继承Thread类)来实现。
//步骤：（1）72个处女是共享的资源，单独建类(继承Thread类)，3穆斯林是线程，建为资源类的对象
//（2）处女数量随着3个线程的争夺而减少，直至0
package threadDemo;

//新建资源类
class Virgin extends Thread {
    int virgin = 72;

    public Virgin(String name) {
        super(name);
    }

    // 重写父类的run方法
    public void run() {
        // 循环，i只表示循环次数
        for (int i = 0; i < 72; i++) {
            // getName() 实例方法，返回该线程的名称。
            // super表示当前对象的父类对象，通过它来调用父类的方法
            if (virgin > 0) {
                // 括号里的变量要填virgin，因为它才是表示共享的资源，同时由于被线程争夺，所以每次运行都要减少一个，执行自减操作
                System.out.println(super.getName() + "抢了" + "第" + virgin-- + "个处女");
            }
        }
    }
}

// 测试类
public class EatingApple {
    // 主方法
    public static void main(String[] args) {
        // 创建对象，调用start方法
        // 由于想显示对象的具体名称，所以在调用构造方法时用Thread(String name)，传入名字
        Virgin muslim01 = new Virgin("muslim01");
        Virgin muslim02 = new Virgin("muslim02");
        Virgin muslim03 = new Virgin("muslim03");
        muslim01.start();
        muslim02.start();
        muslim03.start();
    }

}
/**
 * 小结：可以看到这种方法下，资源的个数出现了混乱,即使字段加上static或private修饰一样。因为在主方法中创建了三个对象，即在内存空间中有三块不同区域，而字段各属于不同对象，因此从整体看字段的值混乱
 */
