//需求：操作InetAddress类，获取其对象，在给定主机名的情况下确定主机的 IP 地址，并直接打印该对象
//通过对象调用方法获取主机名和IP地址。返回本机IP.检查是否可以连接访问。
package _01_ip;

import java.net.InetAddress;

public class InetAddressDemo {

    public static void main(String[] args) throws Exception {
        // 新建InetAddress对象,此类没有构造器，但包含大量实例方法，一般有静态方法返回其对象
        InetAddress ip = InetAddress.getByName("java");
        System.out.println(ip.toString());
        // getLocalHost() 返回本地主机 此为静态方法
        //InetAddress ip = InetAddress.getLocalHost();
        //System.out.println(ip);
        
        //通过对象调用方法获取主机名和IP地址
        System.out.println(ip.getHostName());
        System.out.println(ip.getHostAddress());
        
        //检查是否可以连接访问
        System.out.println(ip.isReachable(1000));
        //检查本地主机是否可以连接
        //System.out.println(InetAddress.getLocalHost().isReachable(1000));
    }
}
/**
 * 小结：InetAddress类表示IP地址，UDP和TCP协议都是在她基础上构建
 */
