//需求：操作进程中的两个方法，方式1:Runtime类的exec方法，方式2:ProcessBuilder的start方法
//方法一：（1）新建Runtime类的对象，（2）通过对象调用exec打开记事本程序
//方法二：（1）通过带参构造器新建ProcessBuilder的对象，传入记事本程序的缩写，（2）通过对象用start方法打开记事本程序
package threadTest;

import java.io.IOException;

//测试类
public class ThreadDemo {
    //主方法
    public static void main(String[] args) {
        //此类创建对象方法特殊
        Runtime a = Runtime.getRuntime();
        try {
            //打开记事本程序notepad,成功,可换为calc
            a.exec("calc");
        } catch (IOException e) {
            e.printStackTrace();
        }
        ProcessBuilder p = new ProcessBuilder("notepad");
        try {
            p.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
/**
 * 小结：创建某类的对象，要先记清该类的构造方法
 */
