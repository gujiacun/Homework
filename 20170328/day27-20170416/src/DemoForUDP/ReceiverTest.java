//（4）在接收端，新建DatagramPacket对象，接收端对象用receive接收数据报包，打印数据报包，关闭接收端对象
package DemoForUDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

public class ReceiverTest {

    public static void main(String[] args) throws Exception {
        // 创建对象,指定端口
        DatagramSocket receiver = new DatagramSocket(10010);
        byte[] buf = new byte[1024];
        // 构造 DatagramPacket，把长度为 length 的数据包传到数组中
        DatagramPacket data = new DatagramPacket(buf, buf.length);
        // 接收者接收数据报包
        receiver.receive(data);
        System.out.println(new String(Arrays.toString(buf)));
        // 关闭
        receiver.close();
    }

}
