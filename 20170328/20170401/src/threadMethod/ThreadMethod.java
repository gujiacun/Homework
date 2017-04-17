//需求：操作线程类中的几种方法
package threadMethod;

//新建类，继承Thread类
class SonOfBitch extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("他是狗娘养的，但他是我们的狗娘养的");
            try {

                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        super.run();
    }

}

// 测试类
public class ThreadMethod {
    // 主方法
    public static void main(String[] args) {
        // 创建线程对象并运行
        SonOfBitch duck = new SonOfBitch();
        // duck.start();
        // join方法
        // 在主线程运行程序时让SonOfBitch类的线程对象加入并执行到该线程死亡为止
        for (int i = 0; i < 50; i++) {
            System.out.println("你才是狗娘养的，你们全家都是狗娘养的");
            if (i == 20) {
                // 要想使用join方法。前提是先使该线程开始运行（start方法）
                duck.start();
                try {
                    duck.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        // 后台线程
        // 测试主线程是否守护线程,先得到当前运行线程的对象
        System.out.println(Thread.currentThread().isDaemon());
        // 创建一个新线程，并把它设为后天线程
        SonOfBitch dick = new SonOfBitch();
        dick.setDaemon(true);
        dick.start();
        System.out.println(dick.isDaemon());
       // 线程优先级
        DaughterOfBitch whore = new DaughterOfBitch("whore");
        DaughterOfBitch bitch = new DaughterOfBitch("bitch");
//        DaughterOfBitch whore = new DaughterOfBitch();
//        DaughterOfBitch bitch = new DaughterOfBitch();
//        whore.setName("whore");
//        whore.setName("bitch");
        
        whore.setPriority(1);
        bitch.setPriority(10);
        whore.start();
        bitch.start();
       
    }

}

class DaughterOfBitch extends Thread {
    String name;

    public DaughterOfBitch(String string) {
        this.name = string;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
           System.out.println(name + "日了狗了");
//           System.out.println(Thread.currentThread().getName() + "日了狗了");
        }
        super.run();
    }

}