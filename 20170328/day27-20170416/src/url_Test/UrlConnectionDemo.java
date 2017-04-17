//需求：把在浏览器中打开的网页文件打印在控制台，把服务器上的某图片保存在本地
//步骤：（1）根据指定的协议，本机号，端口和文件创建URL对象，即服务器上的资源定位符
//（2）根据URL对象获取URLConnection的对象，表示应用程序和URL之间的通信连接，这对象可用于读写URL引用的资源
//（3）通过URLConnection对象，返回字节输入流，再建Scanner类对象（传入字节输入流对象）
//（4）用while循环，以hasNext作条件，以next循环输出，关闭扫描器类对象
//(5)把资源定位符由网页改为图片，用Files的copy方法保存在本地
package url_Test;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class UrlConnectionDemo {

    public static void main(String[] args) throws Exception {
        // url表示在服务器上的某文件资源,String file前面要加/,否则报错
        //URL url = new URL("http","localhost",8080,"/index.jsp");
        //根据指定的协议，本机号，端口和文件创建URL对象
        URL url = new URL("http","localhost",8080,"/tomcat.png");
        //打开应用程序和URL之间的通信连接
        URLConnection way = url.openConnection();
        //由于要把服务器资源下载到本地，用getInputStream打开文件的字节输入流对象
        InputStream in = way.getInputStream();
        //扫描
        Scanner scanner = new Scanner(in);
        while (scanner.hasNext()) {
            System.out.println(scanner.nextLine());
        }
        Files.copy(in,Paths.get("xx.png"));
    }
/**
 * 小结：URL是统一资源定位符，是一个路径，URLConnection的对象，表示应用程序和URL之间的通信连接
 */
}
