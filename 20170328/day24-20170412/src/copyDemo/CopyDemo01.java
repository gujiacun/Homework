//需求：用字节输出流和字节输入流实现文件拷贝
//步骤：（1）创建源文件，目标文件
//（2）由于拷贝文件要经过java程序，即从源文件输入数据，把数据输出到目标文件，分别创建字节输出/入流对象
//（3）为使程序速度更快，将byte数组做缓冲区，read方法写入，write方法写出
//（4）由于缓冲区有容量限制，所以用循环写出，用read方法返回值是否等于-1作为判断条件
//（5）关闭流对象
package copyDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Inet4Address;

public class CopyDemo01 {

    public static void main(String[] args) throws Exception {
        // 创建两个文件
        File resFile = new File("D:/20170411/srcFile01.txt");
        // 由于在这步时，拷贝后的新文件尚未被创建，所以用此构造器
        // 注意，此时具体文件可以没被创建，但父级目录一定要存早
        File destFile = new File("E:/20170411","srcFile01.txt");
        // 传入参数，表示输入源头
        InputStream in = new FileInputStream(resFile);
        // 表示输出源头
        OutputStream out = new FileOutputStream(destFile);    
        byte[] temp = new byte[10];
        // 从源文件写入到数组中
        int len = -1;
        // 表示源文件还有数据
        while((len = in.read(temp)) != -1){
            // 从数组中写入到目标文件中
            out.write(temp);
        }
        // 记住关闭两个流对象
        out.close();
        in.close();
    }
}
/**
 * 小结： // 由于在这步时，拷贝后的新文件尚未被创建，所以用此构造器
        // 注意，此时具体文件可以没被创建，但父级目录一定要存早
        File destFile = new File("E:/20170411","srcFile01.txt");
        整理进笔记
 */
