//需求：练习文件字节输出流，使用多个构造器，用write方法三种形式
package fileStreamDemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo {

    public static void main(String[] args) throws IOException {
        // (1)先创建文件
        File file = new File("D:/20170411/01.txt");
        // (2)建文件字节输出流对象,传入文件对象，表明要进行操作的文件对象
        FileOutputStream fos = new FileOutputStream(file);
        // (3)用write方法输入内容,注意此时操作的是FileOutputStream的对象
        // 把指定字节写入此文件输出流
        fos.write(65);
        
        //把byte数组元素都写入字节输出流里面
        byte[] array = {66,67,68,69,70};
        //会与上面写入的内容，一同保存在文件中
        fos.write(array);
        
        //把byte数组指定起始位置和长度的元素放进输出流
        byte[] array02 = {71,72,73,74,75};
        fos.write(array02, 1, 4);
        // (4)关闭输出流对象
        fos.close();
    }
}
/**
 * 小结：注意重构方法中的差异，记住使用IO时的代码模板
 */
