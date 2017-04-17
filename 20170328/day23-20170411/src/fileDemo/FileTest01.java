//需求：File类用于描述计算机上的文件和文件夹，操作路径分隔符和属性分隔符
package fileDemo;

import java.io.File;
import java.io.IOException;


public class FileTest01 {

    public static void main(String[] args) {
        // 获取此系统中的路径分隔符,这是静态字段,一个是string类型，一个是char类型
        String pathSeparator = File.pathSeparator;
        char pathSeparatorChar = File.pathSeparatorChar;
        // 获取此系统中的名称（属性）分隔符，这也是静态字段
        String separator = File.separator;
        char separatorChar = File.separatorChar;
        System.out.println(pathSeparator + " " + separator);
        System.out.println(pathSeparatorChar + " " + separatorChar);
        
        //由于在不同系统中路径分隔符和属性分隔符不同，而java提供本系统默认的分隔符
        File file = new File("d:" + File.separator + "Skin" + File.separator + "123.txt");
        // 文件存在
        System.out.println(file.exists());
        //创建文件,在java中，\表示转义符，\\表示原来的反斜杠含义
        File file02 = new File("D:\\Skin\\456.txt");
        System.out.println(file02.exists());
        File file03 = new File("D:/Skin/789.txt");
        System.out.println(file03.exists());
        
        //File类的构造方法
        File father = new File("D:/20170411/d");
        // 前面填上级路径名，后面填要创建的文件的名字
        File son = new File(father, "9876.txt");
        try {
            System.out.println(son.createNewFile());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        File girl = new File("D:/20170411/d","54321.txt");
        try {
         // 前面填上级路径名，后面填要创建的文件的名字
            System.out.println(girl.createNewFile());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
/**
 * 小结：windows系统中，分隔符支持/和\，UNIX只支持/，以后统一写/
 */
