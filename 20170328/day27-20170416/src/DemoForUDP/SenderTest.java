//需求：UDP在Java中的运用，掌握DatagramSocket类，由于UDP传输数据靠数据报包，用DatagranPacket包装数据
//由发送端向接收端传输数据
//步骤：（1）创建两个java文件，表示接收端和发送端，分别创建对象
//（2）新建要传输的数据字符串
//（3）在发送端，新建DatagramPacket对象，分别传入要输送的字符串（化为数组），包的长度，指定IP,指定端口，
//发送端对象用send方法发送数据报包，关闭发送端对象
//（4）在接收端，新建DatagramPacket对象，接收端对象用receive接收数据报包，打印数据报包，关闭接收端对象
package DemoForUDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SenderTest {

    public static void main(String[] args) throws Exception {
        // 创建对象,指定端口
        DatagramSocket sender = new DatagramSocket(10086);
        String string = "我说无可奉告，你们又不高兴";
        DatagramPacket data = new DatagramPacket(string.getBytes(), string.getBytes().length, InetAddress.getLocalHost(), 10010);
        sender.send(data);
        sender.close();
    }
}
/**
 * 小结：TCP中的服务端和客户端分别由两个不同的类表示，UDP中都由DatagramSocket类表示
 * 在TCP协议中，客户端要连接某服务端，客户端的端口必须与服务端的端口保持一致，然后借此传输数据
 * 在UDP协议中，发送端和接收端的端口一定要不同。当发送端要传数据给接收端，建数据报包时要指定接收端的端口作为目标
 * 即在TCP协议中，客户端与服务端地位不等。在UDP中，发送端和接收端地位相等。
 * 无论是什么协议，两个端要进行文件传输，端口相同。
 */
