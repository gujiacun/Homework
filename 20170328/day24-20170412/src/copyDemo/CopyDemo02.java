//需求：对CopyDemo01进行正确的资源关闭
//步骤：（1）方式一，资源的自动关闭，try(写需要自动关闭的资源){可能出现异常的执行代码}catch(){}
//(2)方式二，资源的手动关闭
package copyDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyDemo02 {
    // 主方法
    public static void main(String[] args){
        // 由于作用域有限定范围，所以文件对象的创建要放在try-cach语句前面
        File resFile = new File("D:/20170411/srcFile03.txt");
        File destFile = new File("E:/20170411/srcFile03.txt");
        try (
                // 括号内填入打开资源，需要被自动关闭的代码
                InputStream in = new FileInputStream(resFile); OutputStream out = new FileOutputStream(destFile);) {
            // 可能出现异常的代码，读入/写出操作
            // 建缓冲区
            byte[] temp = new byte[10];
            // 表示已经读取的字节数
            int len = -1;
            while ((len = in.read(temp)) != -1) {
                // 从数组中写入到目标文件中，注意方法要写索引开始位置和长度，否则会出现元素重复及覆盖现象
                out.write(temp,0,len);
            }
            //由于是自动关闭资源，不需写finally语句和close方法
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        //手动关闭资源
        //声明资源对象
        InputStream in02 = null; 
        OutputStream out02 = null;
        try {
            //创建源和目标
            File resFile02 = new File("D:/20170411/srcFile04.txt");
            File destFile02 = new File("E:/20170411/srcFile04.txt");
            //建字节输入/出流对象
            in02 = new FileInputStream(resFile02); 
            out02 = new FileOutputStream(destFile02);
         // 建缓冲区
            byte[] temp = new byte[10];
            // 表示已经读取的字节数
            int len = -1;
            while ((len = in02.read(temp)) != -1) {
                // 从数组中写入到目标文件中，注意方法要写索引开始位置和长度，否则会出现元素重复及覆盖现象
                out02.write(temp,0,len);
            }
        }catch (Exception e) {
            e.printStackTrace();
        } 
        finally {
            // 在finally语句中写关闭资源的语句，保证这些代码一定会被执行
            try {
                if (out02 != null) {
                    out02.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (in02 != null) {
                    in02.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
/**
 * 小结：手动关闭资源要学会，因为可能工作时用的java版本较低
 */
