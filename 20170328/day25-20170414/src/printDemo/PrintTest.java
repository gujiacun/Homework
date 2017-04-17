//需求：操作字节/字符打印流，都是输出流
//字节打印流PrintStream，创建对象，用write的几种格式写出
//字符打印流PrintWriter,使用println,flush,close方法，在前面构造器启动自动刷新
package printDemo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

public class PrintTest {

    public static void main(String[] args) throws Exception {
        // 新建文件对象
        File file = new File("11111/out");
        // 创建字节打印流对象
        PrintStream ps = new PrintStream(file);
        // 把程序中的数据写入文件中
        // write(byte[] buf, int off, int len)
        // 将 len 字节从指定的初始偏移量为 off 的 byte 数组写入此流。
        byte[] arr01 = { 'a', 's', 'd', 'f', 'g' };
        ps.write(arr01, 2, 2);
        // void write(int b)
        // 将指定的字节写入此流。
        ps.write('A');
        ps.write(66);
        ps.write("tooyoubgtoosimple".getBytes());
        // 打印方法,这里print方法把内容打印在指定的文件中
        ps.print("excited!");
        ps.print(100L);
        ps.close();

        // File file02 = new File("11111/out02");
        // 创建字节打印流对象
        // PrintWriter(Writer out, boolean autoFlush) 创建新 PrintWriter。
        PrintWriter pw = new PrintWriter(new FileOutputStream(new File("11111/out02")), true);
        String str = "ASDFGHJKL";
        pw.write(str, 2, 2);
        // void write(int b)
        // 将指定的字节写入此流。
        pw.write('A');
        pw.write(66);
        pw.write("tooyoubgtoosimple");
        // 打印方法,这里print方法把内容打印在指定的文件中
        pw.print("excited!");
        pw.print(100L);
        // 虽然在构造器打开了自动刷新的true，但那里只限定于println、printf 或 format 方法将刷新输出缓冲区
        // 若没有进行刷新，要手动刷新，用flush()或close
        pw.flush();
        pw.close();
    }
}
/**
 * 小结：PrintStream和PrintWriter的write方法各有不同，前者允许打印byte数组，后者可打印string
 * 这两个打印流的print方法都是打印到文件内
 */
