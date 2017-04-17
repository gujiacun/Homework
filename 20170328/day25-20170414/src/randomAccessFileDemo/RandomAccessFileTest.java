//需求：操作RandomAccessFile，先写出，后读入
//步骤：（1）在主方法新建文件对象，建read和write方法，进行先写出，后读入的操作
//（2）在write方法中新建RandomAccessFile对象，在构造器中写入"rw","rw" 打开以便读取和写入。如果该文件尚不存在，则尝试创建该文件 
//先写close，在中间用write写入几种格式数据
//（3）在read方法中新建RandomAccessFile对象，在构造器中写入"r",以只读方式打开,此时不能向文件写入数据，所以先关闭write方法
//（4）用read方法读取数据
//（5）在不同位置，打印文件指针位置getFilePointer，再设置文件指针的偏移量seek，尝试跳过输入的 n个字节skipBytes，
package randomAccessFileDemo;

import java.io.File;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {

    public static void main(String[] args) throws Exception {
        File file = new File("11111/randomAccessFileTest");
        // 写出数据到指定文件
        //write(file);
        // 从指定文件读入数据
        read(file);
    }

    private static void read(File file) throws Exception {
     // 新建RandomAccessFile对象,模式是string类型，用双引号保围，"rw" 打开以便读取和写入 
        RandomAccessFile raf = new RandomAccessFile(file, "r");
        // 打印文件指针位置
        System.out.println("文件指针位置"+raf.getFilePointer());
        // 从文件中读取一个数据
        System.out.println(raf.read());
        System.out.println("文件指针位置"+raf.getFilePointer());
        System.out.println(raf.readByte());
        System.out.println("文件指针位置"+raf.getFilePointer());
        System.out.println("------------");
        // 此时设置文件指针为0，再读取
        raf.seek(0);
        System.out.println("文件指针位置"+raf.getFilePointer());
        System.out.println(raf.read());
        System.out.println("文件指针位置"+raf.getFilePointer());
        System.out.println("------------");
        //此时跳过2个字节
        raf.skipBytes(2);
        System.out.println("文件指针位置"+raf.getFilePointer());
        System.out.println(raf.read());
        System.out.println("文件指针位置"+raf.getFilePointer());
        // 此时已经读完文件中的所有数据，返回-1
        System.out.println(raf.read());
    }

    private static void write(File file) throws Exception {
        // 新建RandomAccessFile对象,模式是string类型，用双引号保围，"rw" 打开以便读取和写入 
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        // 用write写出数据到文件
        raf.write(65);
        // 用write写出byte数组的某部分数据到文件，
        raf.write("qwertyuiop".getBytes(),2,3);
        // 关闭流对象
        raf.close();
    }
}
/**
 * 小结：RandomAccessFile在网络下载与上传中应用广泛，注意常用方法
 * seek(x)为设置文件指针位置到x这个数字上，skipBytes(y)为跳过y个字节
 */
