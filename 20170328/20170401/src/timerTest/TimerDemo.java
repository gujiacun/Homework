//需求：操作定时器的构造方法和方法

package timerTest;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

//测试类
public class TimerDemo {
    // 主方法
    public static void main(String[] args) {
        // 新建Timer类对象,并赋予名字
        Timer clock = new Timer();
        try {
            // 想要调用schedule方法，但里面需要TimerTask类的对象
            clock.schedule(new task(), 1000);
            //做一个电子时钟，输出当前时间
            //整个方法是调用schedule方法，其中在TimerTask的对象中运用了内部类
            clock.schedule(new TimerTask(){
                public void run(){
                    System.out.println(new Date().toString());
                }
            }, 3000, 1000);
            //用try-finally是想保证必须执行cancel方法
        } finally {
            // 要想让方法结束，必须用cancel方法
            try {
                // 由于cancel后程序执行太快，这里让程序先休眠，效果更明显
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clock.cancel();
        }
    }

}

// 由于TimerTask是抽象类，所以要先创造它的子类，再在主方法中创建子类的对象并调用其中方法
class task extends TimerTask {
    // 子类必须重写抽象类中的抽象方法
    @Override
    public void run() {
        // 模仿电影画面，十秒后炸弹爆炸
        for (int i = 10; i >= 0; i--) {
            try {
                // 希望在每一次打印语句之间间隔一段时间
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i + "......");
            if (i == 1) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("安拉胡阿克巴！");
            }
            if (i == 0) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Boom!!!!!!!!!!");
            }
        }
    }

}
/**
 * 小结：内部类的用法还不熟悉，要加强练习
 */
