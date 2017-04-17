//需求：操作Files类的copy方法把旧文件拷贝到新文件，注意copy方法的不同格式
//Path是接口，要返回其对象，要用其工具类Paths的get方法，里面填文件的路径名
package nioDemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
//File类的工具类，封装了各种方法
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NIOTest {

    public static void main(String[] args) throws Exception {
        // 用Files类的copy方法把旧文件拷贝到新文件
        Path p = Paths.get("11111/Untitled 3.txt");
        // 当知道源文件的路径而不知目录文件路径时用这种
        Files.copy(p, new FileOutputStream("xx.txt"));
        // 当知道目录文件路径而不知源文件的路径时用这种
        Path p02 = Paths.get("11111/Untitled 4.txt");
        Files.copy(new FileInputStream("11111/Untitled 3.txt"), p02);
    }
}
/**
 * 小结：在Files工具类中，操作的是File文件的对象
 */
