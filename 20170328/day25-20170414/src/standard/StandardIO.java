//需求：操作System类中的标准输入/出流对象，重定向标准输入/出流到文件
//static PrintStream          err “标准”错误输出流。 
//static InputStream          in  “标准”输入流,即键盘输入。 
//static PrintStream          out “标准”输出流，即屏幕输出。 
// 以上三个都是System类的常量，返回对应的类的对象，所以要有变量来接受

package standard;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class StandardIO {

    public static void main(String[] args) throws Exception {
        // 返回System类三个常量的对应类的对象，但可以直接用常量调用类中的方法
        PrintStream err = System.err;
        InputStream is = System.in;
        PrintStream out = System.out;
        System.out.println("请输入一个数字");
        //is.read();
        // 上句等价于下句
        System.in.read();
        // 输出语句就是一直在调用PrintStream里的方法
        //System.out.println("年轻人，要提高自己的姿势水平，识得唔识得？");
        out.println("年轻人，要提高自己的姿势水平，识得唔识得？");
        
        //标准流的重定向操作
        // static void         setIn(InputStream in)
        // 重新分配“标准”输入流,此文件就是输入的源泉，现在可以从这文件读入数据。
        System.setIn(new FileInputStream("11111/Untitled 2"));
        int word = System.in.read();//从文件读入数据
        // static void         setOut(PrintStream out)
        // 重新分配“标准”输出流,此文件就是输出的目标，现在可以写出数据到这文件。
        System.setOut(new PrintStream("11111/Untitled 3"));
        System.out.println(word);//把读入的数据写出到Untitled 3中
        System.out.println("姿势水平很高");
    }
}
/**
 * 输入流和输出流可以重定向到某文件，此时打印出的语句在指定文件中显示
 */
