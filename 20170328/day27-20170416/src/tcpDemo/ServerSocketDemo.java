//需求：探讨TCP协议在Java中的应用，掌握与其有关的ServerSocket类和Socket类，由服务端向客户端输出数据并打印
//步骤：（1）新建两个文件，模拟服务器和手机
//（2）在服务器类创建服务端对象（指定端口为8888），在手机类创建客户端对象（指定连接到服务端的主机和端口）
//（3）在服务器类，用accept方法接收链接了这个服务端的客户端，打印该客户端的地址
//（4）获取该客户端对象的输出流对象，包装成打印流，打印输出客户端的数据
//(5)打印流，客户端对象关闭
//（6）在手机类，获取客户端对象的输入流对象，包装成扫描器类并循环打印
package tcpDemo;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//服务端，用于接收来自客户端的连接请求和相应客户端，实现服务器套接字
public class ServerSocketDemo {

    public static void main(String[] args) throws Exception {
        // 新建字符串，是服务端要传输给客户端的内容
        String string = "亲爱的玩家，我是你爸爸"
                + "真是一颗赛艇啊";
        ServerSocket server = new ServerSocket(8888);
        System.out.println("服务端已连接好");
        boolean online = true;
        // 由于這是死循环，要手动关闭文件
        while (online) {
            // 表示接收链接了这个服务端的客户端
            Socket mobile = server.accept();
            // 返回这个客户端所连接的地址
            System.out.println("这个客户端所连接的地址" + mobile.getInetAddress());
            // 获取该客户端对象的输出流对象，包装成打印流
            OutputStream out = mobile.getOutputStream();
            out.write(string.getBytes());
            // 关闭流对象
            out.close();
        }
        // 关闭服务端对象
        server.close();
    }
}
    /**
     * 小结：由于要在两台主机中传送文件，客户端与服务端的构造器的端口要相同
     * 注意，ServerSocket类中没有getInoutStream和getOutputStream方法
     */
