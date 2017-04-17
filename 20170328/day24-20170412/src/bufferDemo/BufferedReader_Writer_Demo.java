// 需求：操作字符缓冲输出/入流，掌握新方法
package bufferDemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Arrays;

public class BufferedReader_Writer_Demo {

    public static void main(String[] args) throws Exception {
        // 新建字符缓冲输出流对象
        File file = new File("D:/20170411/789.txt");
        Writer os = new FileWriter(file);
        BufferedWriter out = new BufferedWriter(os);
        out.write("我跟你们说");
        // newLine(),写入一个行分隔符
        out.newLine();
        out.write("中国有句古话");
        out.newLine();
        out.write("叫‘闷声发大财’");
        out.newLine();
        out.write("叫识得唔识得？");
        out.newLine();

        // void write(char[] cbuf, int off, int len)
        char[] array = { '美', '国', '华', '莱', '士', '比', '你', '们', '不', '知', '高', '到', '哪', '里', '去', '我', '跟', '他', '谈',
                '笑', '风', '生' };
        // 写入字符数组的某一部分。
        out.write(array, 0, 15);
        out.newLine();
        // void write(int c)
        // 写入单个字符。
        out.write(65);
        out.newLine();
        // void write(String s, int off, int len)
        // 写入字符串的某一部分。
        String str = new String("我今天是作为一个长者，教给你们一些人生的经验");
        out.write(str, 4, 18);
        // 关闭缓冲流对象
        out.close();

        // 新建字符缓冲输入流对象
        File file02 = new File("D:/20170411/101112.txt");
        Reader reader = new FileReader(file02);
        BufferedReader br = new BufferedReader(reader);

        // int read()
        // 读取单个字符。
         //System.out.println(br.read());
        // int read(char[] cbuf, int off, int len)
        // 将字符读入数组的某一部分。
         char[] arr = new char[20];
         br.read(arr, 0, 7);
         System.out.println(Arrays.toString(arr));
        // String readLine()
        // 读取一个文本行。
        //System.out.println(br.readLine());
        //System.out.println(br.readLine());
        // boolean ready()
        // 判断此流是否已准备好被读取。
        System.out.println(br.ready());
      
        // long skip(long n)
        // 跳过字符。
        br.skip(3);
        br.read(arr,7,6);
        System.out.println(Arrays.toString(arr));
        br.close();
        
        //读取文件的三行内容并打印
        //步骤：（1）新建缓冲字符输入流对象
        //（2）建string类型的行，表示读取的行
        //（3）while循环，流对象逐行读取源文件，当行不等于null，输出该行
        File file03 = new File("D:/20170411/131415.txt");
        Reader in = new FileReader(file03);
        BufferedReader br02 = new BufferedReader(in);
        String line = null;
        while ((line = br02.readLine()) != null) {
            System.out.println(line);
        }
        br02.readLine();
        
    }
}
/**
 * 小结：掌握字符缓冲输入/出流的常用方法
 */
