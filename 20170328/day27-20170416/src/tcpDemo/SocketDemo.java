package tcpDemo;

import java.net.Socket;
import java.util.Scanner;

//客户端，实现客户端套接字
public class SocketDemo {

    public static void main(String[] args) throws Exception {
        // 获取客户端的对象
        Socket mobile = new Socket("localhost", 8888);
        // 获取客户端的输入流对象，用Scanner类扫描并循环打印
        Scanner scanner = new Scanner(mobile.getInputStream());
        // 循环打印
        while (scanner.hasNext()) {
            String string = (String) scanner.next();
            System.out.println(string);
        }
        //关闭流对象和客户端对象
        scanner.close();
        mobile.close();
    }

}
