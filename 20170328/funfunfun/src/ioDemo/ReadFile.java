package ioDemo;
/**
 * 文件输入步骤：
 * （1）创建File类的对象
 * （2）创建文件输入流的对象（FileInputStream），构造器传入上一步对象
 * （3）创建文件输入流的Reader（InputStreamReader），构造器传入上一步对象，同时指定字符集
 * （4）创造一个带有缓冲区的Reader（如BufferedReader），构造器传入上一步对象
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;


//import javax.xml.soap.Text;

public class ReadFile {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        File file = new File("text.txt");
        if (file.exists()) {
            System.out.println("文件存在");
            try {
                // 要读取文件内容，首先要创建文件输入流，fis是字节流
                FileInputStream fis = new FileInputStream(file);
                //获取文件输入流后，把输入流包装成InputStreamReader
                try {
                    // isr是字符流，把字节流转为字符流，要指定字符编码
                    // 在传入输入流时，指定字符集，如UTF-8，字符编码就会已UTF-8来编码
                    InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
                    //创造一个带有缓冲区的reader
                    BufferedReader br = new BufferedReader(isr);
                    //临时存放读取到的数据
                    String line;
                    while ((line = br.readLine()) != null) {
                        System.out.println(line);
                    }
                    // 打印循环结束后，要关闭流。先开后关，后开先关
                    br.close();
                    isr.close();
                    fis.close();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

}