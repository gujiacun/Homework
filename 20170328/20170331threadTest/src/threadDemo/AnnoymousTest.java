//需求：以匿名内部类形式实现继承Thread类的线程创建与启动
//步骤：在主方法中通过匿名内部类形式创建对象，并在内部类里重写run方法，编写线程执行体，调用start方法
package threadDemo;
//测试类
public class AnnoymousTest {
    //主方法
    public static void main(String[] args) {
        // 匿名内部类格式
        /**
         * new 父类构造器([实参列表]) 或 接口(){ //匿名内部类的类体部分 }
         */
        // 在主线程运行游戏，在另外的类中播放音乐，由于另外的类只是用一次，所以用匿名内部类
        for (int i = 0; i < 20; i++) {
            // 在主线程运行游戏
            System.out.println("运行游戏" + i);
            // 当主线程运行到某个次数时，开始执行另外的线程
            if (i == 5) {
                // 通过新建Thread对象调用start方法
                // 新建的Thread对象在内部类里重写run方法，在方法里写线程执行体
                new Thread() {
                    // 重写run方法
                    public void run() {
                        // 这里也运用循环，打印播放音乐10次
                        for (int j = 0; j < 10; j++) {
                            System.out.println("播放音乐" + j);
                        }
                    }
                    // 启动线程
                }.start();
            }
        }
    }

}
/**
 * 小结：写内部类时，可以从外到内，一步一步来，着重复习内部类相关知识
 */
