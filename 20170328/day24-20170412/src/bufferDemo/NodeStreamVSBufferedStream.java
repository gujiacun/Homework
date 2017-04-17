//需求：比较在拷贝文件中，字节输入/出流与字节缓冲输入/出流的性能差别
package bufferDemo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.management.BadBinaryOpValueExpException;

public class NodeStreamVSBufferedStream {

    public static void main(String[] args) throws Exception {
        // 字节输入/出流
        test1();
        // 字节缓冲输入/出流
        test2();

    }

    private static void test1() throws Exception {
        // 建源文件对象，目标文件对象
        long begin = System.currentTimeMillis();
        File file01 = new File("D:/20170411/161718.txt");
        File file02 = new File("E:/20170411/161718.txt");
        //建字节输入/出流对象
        InputStream in = new FileInputStream(file01);
        OutputStream out = new FileOutputStream(file02);
        //建byte数组作为缓冲
        byte[] arr01 = new byte[10];
        //把原文件数据循环读入到数组，把数组中的数据写出到目标文件
        int len = -1;
        while ((len = in.read(arr01)) != -1) {
            out.write(arr01);;
        }
        // 关闭两个流对象
        out.close();
        in.close();
        long end = System.currentTimeMillis();
        long time = end - begin;
        System.out.println(time);
    }
    private static void test2() throws Exception {
        // 建源文件对象，目标文件对象
        long begin = System.currentTimeMillis();
        File file03 = new File("D:/20170411/192021.txt");
        File file04 = new File("E:/20170411/192021.txt");
        // 建字节缓冲输入/出流对象
        InputStream in = new FileInputStream(file03);
        BufferedInputStream bis = new BufferedInputStream(in);
        OutputStream out = new FileOutputStream(file04);
        BufferedOutputStream bos = new BufferedOutputStream(out);
        // 建byte数组作为缓冲
        byte[] arr02 = new byte[10];
        //把原文件数据循环读入到数组，把数组中的数据写出到目标文件
        int len = -1;
        while ((len = bis.read(arr02)) != -1) {
            bos.write(arr02);
        }
        bos.close();
        bis.close();
        long end = System.currentTimeMillis();
        long time = end - begin;
        System.out.println(time);
        // 关闭两个流对象
        
    }

}
/**
 * 小结：运用缓冲流，同时用char数组/byte数组作为另一个缓冲区，及大加快程序运行速速
 */
