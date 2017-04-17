//需求：操作转换流，把字节输入/出流转换为字符输入/出流，并用转换流完成文件的拷贝
package transform;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class TransformDemo {

    public static void main(String[] args) throws Exception {
        // （1）建源文件和目标文件的对象
        File resFile = new File("file/111.txt");
        File destFile = new File("file/222.txt");
        // (2)建字节输入流对象，并通过转换流转换为字符输入流
        InputStream inn=new FileInputStream(resFile);
        Reader in = new InputStreamReader(inn);
        //上面一行 等于InputStream is = new FileInputStream(resFile);
        // Reader in = new InputStreamReader(is);
        
        // (3)建字节输出流对象，并通过转换流转换为字符输出流
        OutputStream os = new FileOutputStream(destFile);
        Writer out = new OutputStreamWriter(os);
        // 上面一行等于 OutputStream os = new FileOutputStream(destFile);
        // Writer out = new OutputStreamWriter(os);
        
        // （4）由于已变为字符流，新建char[],从源文件循环读取数据到char数组,从数组写出到目标文件
        char[] array = new char[10];
        int len = -1;
        while ((len = in.read(array)) != -1) {
            out.write(array,0,len);
        }
        // （5）关闭流对象
        in.close();
        out.close();
    }
}
/**
 * 小结：由于匿名对象能够限制作用域，多熟悉匿名对象的嵌套用法
 */
