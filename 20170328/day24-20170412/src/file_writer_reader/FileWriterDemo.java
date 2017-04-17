//需求：由于使用字节流操作含有特殊符号的文件时容易出现乱码，所以用操作FileWriter的常用方法
package file_writer_reader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {

    public static void main(String[] args) throws IOException {
        // （1）新建文件对象
        //File file = new File("D:/20170411/0412_01.txt");
        // （2）新建字符输出流对象，传入上一步的对象，注意构造器不同格式
        // 格式一：FileWriter(File file)
        // 根据给定的 File 对象构造一个 FileWriter 对象。
        //FileWriter fw = new FileWriter(file);
        // 格式二：FileWriter(String fileName)
        // 根据给定的文件名构造一个 FileWriter 对象。
        //FileWriter fw02 = new FileWriter("D:/20170411/0412_02.txt");
        
        // 格式三：FileWriter(File file, boolean append)
        // 根据给定的 File 对象构造一个 FileWriter 对象。
        // 格式四：FileWriter(String fileName, boolean append)
        // 根据给定的文件名以及指示是否附加写入数据的 boolean 值来构造 FileWriter
        FileWriter fw02 = new FileWriter("D:/20170411/0412_03.txt",false);

        // （3）调用write方法，5种形式
        char[] array = new char[]{'Q','W','E','R','R','T','Y'};
        // 传入字符
        fw02.write("ABCDE");
         // 换行
        fw02.write("\n");
         // 括号内填int类型，写入单个字符
        fw02.write(65);
         // 表示把某数组里面的数据写入指定的文件里面，指定开始索引及长度
        fw02.write(array, 0, 2);
         // 写入某字符串的某一部分
         String str = "PPOMFJENJ";
         fw02.write(str, 1, 3);
        //(4)关闭流对象
         fw02.close();
    }
}
/**
 * 小结：IO流操作对象格式大同小异，最重要记清楚各自方法的格式及返回值和用法
 */
