//需求：用文件字符流实现文件拷贝
//步骤：（1）创建源文件，目标文件
//（2）建字符输入/出流对象，分别传入上一步的源文件，目标文件
//（3）建char数组作为缓冲区，用read/write进行读/写操作
//（4）由于缓冲区有容量限制，用循环不断写出数据到新文件中，以read方法的返回值做判断条件
//（5）关闭流对象
package file_writer_reader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

public class FileCopyDemo {

    public static void main(String[] args) throws Exception {
        File resFile = new File("D:/20170411/srcFile02.txt");
        // 拷贝文件时，新文件还没被创建，用此构造器给出其父级目录路径，新文件名字
        File destFile = new File("E:/20170411/", "srcFile02.txt");
        Reader in = new FileReader(resFile);
        Writer out = new FileWriter(destFile);
        char[] temp = new char[5];
        // 把原文件数据读入到数组中，把数组数据写出拷贝文件里
        int len = -1;
        while ((len = in.read(temp)) != -1) {
            out.write(temp);
        }
        // 关闭流对象
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