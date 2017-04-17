//需求：模仿Tomcat做出网页
//步骤：（1）先建静态网页
//（2）建服务端对象，获取链接到此服务端的客户端对象，
//（4）建立管道，读取客户端的数据，用扫描类
//（3）通过客户端对象获得其输出流，打印数据
package tomcatDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TomcatTest {

    public static void main(String[] args) throws Exception {
        // 静态网页的绝对地址
        File file = new File("D:/classtest/20170328/day27-20170416/pageForTest/NewFile.html");
        // 建服务端对象
        ServerSocket server = new ServerSocket(19888);
        while (true) {
            // 获取链接到此服务端的客户端对象
            Socket user = server.accept();
            // 由于这里只是模拟，没有网络连接，所以用文件的绝对路址代替
            Scanner scanner = new Scanner(new FileInputStream(file));
            PrintStream print = new PrintStream(user.getOutputStream());
            while (scanner.hasNextLine()) {
                print.println(scanner.nextLine());
            }
            print.close();
            
            scanner.close();
        }
        //server.close();
    }
}
/**
 * 小结：Scanner与PrintStream混合使用，当Scanner还有内容时，PrintStream对象调用println方法输出Scanner的一行内容
 */
