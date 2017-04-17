//需求：以匿名内部类形式，通过实现Runnable接口进行线程创建与启动
package threadDemo;

//测试类
public class AnnoymousTest02 {
    // 主方法
    public static void main(String[] args) {
        // 主方法运行20次游戏
        for (int i = 0; i < 50; i++) {
            System.out.println("在打游戏中，勿扰" + i);
            // 当运行到一定时间，同时播放音乐
            if (i == 8) {
                // 用这种方法启动线程，必须借助Thread类中的start方法
                //但由于是Runnable接口的实现类，所以要创建它的对象,接着跟类体，里面重写方法
                new Thread(new Runnable(){
                    public void run(){
                        for (int j = 0; j < 50; j++) {
                            System.out.println("放首嗨歌振奋士气" + j);
                        }
                    }
                }).start();
            }
        }
    
     }
}
/**
 * 小结：写匿名内部类，要注意逻辑参差的递进，注意花括号，注意对象里面包含内部类
 */