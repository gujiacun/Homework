//需求：练习文件字节输入流，使用多个构造器，用read方法三种形式
//步骤：（1）创建File类对象
//（2）建文件输入字节流对象，把上步对象传入
//（3）用read方法，从此输入流中读取数据

//需求：把文件所有数据都读取到程序的byte数组中，并打印
//步骤：（1）建File类对象
//（2）建字节输入流对象，把上一步对象传入此
//（3）要把文件的数据读入到byte数组中，动态建byte数组，用read方法，表示把文件读入到数组中
//（4）通过string构造方法，把数组转为字符串输出
//（5）由于byte数组有容量限制，而文件数据量未知，用while循环重复打印，直至穷尽文件数据
//（6）read方法会返回已读取的数据字节（int），当文件数据全部读完后，返回-1，以此作为循环判断条件
package fileStreamDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class FileInputStreamDemo {

    public static void main(String[] args) throws IOException {
        File file = new File("D:/20170411/02.txt");
        FileInputStream fis = new FileInputStream(file);
        
        //读取输入流中的一个字节，返回int类型,每一次都读取下一个元素，当没有元素可读时返回-1
//        System.out.println(fis.read());
//        System.out.println(fis.read());
//        System.out.println(fis.read());
//        System.out.println(fis.read());
//        System.out.println(fis.read());
//        System.out.println("----");
        //把输入流读取到byte数组中
//        byte[] array = new byte[6];
//        fis.read(array);
        //打印数组以验证
//        for (int i = 0; i < array.length; i++) {
//            System.out.println(array[i]);
//        }
//        System.out.println("----");
        //把输入流读取到byte数组中,从数组的指定索引位置开始存储，和读取长度
//        byte[] array02 = new byte[10];
//        //返回的是读取了的元素个数
//        int ret = fis.read(array02,2,6);
//        System.out.println(ret);
//        System.out.println("----");
//        //打印数组以验证
//        for (int i = 0; i < array02.length; i++) {
//            System.out.println(array02[i]);
//        }
        
        //一次只能读取5个字节 ，所以用循环
        byte[] array03 = new byte[5];
        //表示当前读取到的总字符数量
        fis.read(array03);
        System.out.println(Arrays.toString(array03));
        //当len不等于-1时，表示文件中的数据还没读入完
        //read返回的是读取了的元素个数
        int len = -1;
        while ((len = fis.read(array03)) != -1) {
            //用String的构造方法把byte数组转为string类型，第二个为要解码的第一个 byte 的索引
            //len为要解码的 byte 数
            String string = new String(array03, 0, len);
            System.out.println(string);
        }
        fis.close();
    }
}
/**
 * 小结：String构造器能把byte数组转为string类型
 * FileInputStream对象调用read方法，返回已读进缓存区的数据数量
 */
