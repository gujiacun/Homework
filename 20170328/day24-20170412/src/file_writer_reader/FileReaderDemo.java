//需求：使用文件字符输入流，循环取出文件里面的元素，使用read方法的不同格式
package file_writer_reader;

import java.io.File;
import java.io.FileReader;

public class FileReaderDemo {

    public static void main(String[] args) throws Exception {
        // 创建源文件
        File file  = new File("D:/20170411/0412_05.txt");
        // 创建字符输入流对象
        FileReader in = new FileReader(file);
        // 使用read方法
        // int read()
        // 读取单个字符,返回的是这个字符在ASCII表中对应的数字。
        //System.out.println((char)in.read());
        // int read(char[] cbuf)
        // 将字符读入数组。由于是字符输入流，所以对应的是char数组
        char[] inChar = {'O','K','M'};
        in.read(inChar,1,1);
        System.out.println(new String(inChar,1,1));
        // abstract int read(char[] cbuf, int off, int len)
        // 将字符读入数组的某一部分。
        char[] inChar02 = {'P','C','V'};
        in.read(inChar02,1,1);
        System.out.println(new String(inChar02));
        // int read(CharBuffer target)
        // 试图将字符读入指定的字符缓冲区

        // 读取read，新建char数组，把文件读入到数组中
        char[] array = new char[5];
        // 返回已读入的数据的个数
        int len = in.read(array);
        while (len != -1) {
            //假如文件中最后剩余的元素小于5就会出错，通过String构造器，以len作为变量输出
            System.out.println(new String(array,0,len));
            len = in.read(array);
        }
        in.close();
    }
}
/**
 * 小结：       读取单个字符,返回的是这个字符在ASCII表中对应的数字。
        System.out.println((char)in.read());
        上面经常忘记
 */
