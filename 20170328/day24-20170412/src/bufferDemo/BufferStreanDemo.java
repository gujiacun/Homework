//需求：操作字节缓冲输出流与字节缓冲输入流 ，注意建流对象时的格式和步骤
package bufferDemo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferStreanDemo {

    public static void main(String[] args) throws Exception {
        // 字节缓冲输出流 
        File file = new File("D:/20170411/123.txt");
        OutputStream ots = new FileOutputStream(file);
        BufferedOutputStream bos = new BufferedOutputStream(ots);
        // write(byte[] b) 此方法属于OutputStream，BufferedOutputStream是其子类
        bos.write("excited!".getBytes());
        // 关闭流对象
        bos.close();
        // 字节缓冲输入流 
        File file02 = new File("D:/20170411/456.txt");
        InputStream is = new FileInputStream(file02);
        BufferedInputStream bis = new BufferedInputStream(is);
        // 建byte数组作为内存里的缓冲区，又有缓冲流，速度最快
        byte[] array = new byte[1024];
        int len = -1;
        while ((len = bis.read(array)) != -1) {
            System.out.println(new String(array,0,len));
            
        }
        // 关闭流对象
        bis.close();
    }
}
/**
 * 小结：字节缓冲输入/出流的操作格式与字节输入/出流的步骤大同小异，只是在创建流对象时多了一步
 */
