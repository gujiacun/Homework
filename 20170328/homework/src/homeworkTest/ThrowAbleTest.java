//需求：验证Java7的异常新特性：自动资源关闭
package homeworkTest;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class ThrowAbleTest {
    // 以下为普通的实现异常捕获
    public static void main(String[] args) {
        int result;
        try {
            result = 10 / 0;
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("由getMessage方法为您服务，错误为：" + e.getMessage());
            e.printStackTrace();

        } finally {
            System.out.println("改bug是不可能改bug的，一辈子都不可能改bug的");
        }
    }
}

// 手动关闭资源
class xxxx {
    private static void test1() {
        //在语句块外面创建对象
        OutputStream out = null;
        // 打开文件，并捕获异常
        try {
            //打开文件
            out = new FileOutputStream("D:\12345.txt");
            // 操作文件
            out.write(1);
            // 若有错误就抓住并打印跟踪栈的信息
        } catch (Exception e) {
            e.printStackTrace();
            // 手动关闭资源，一定会执行
        } finally {
            try {
                //如果文件没被关闭，就手动用close方法关闭
                if (out != null) {
                    out.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

// 自动关闭资源
class YYYY {
    private static void test1() {
        // 在try后面跟一个括号，括号里写打开资源对象的代码，括号里的资源会被自动关闭
        try (OutputStream out = new FileOutputStream("D:\12345.txt")) {
            out.write(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // finally {
        // try {
        // if (out != null) {
        // out.close();
        // }
        // } catch (Exception e) {
        // e.printStackTrace();
        // }
        // }
    }
}
/**
 * 小结：普通的try catch语句中，try后面没有(),但要用自动关闭资源，在try后面跟一个括号，括号里写打开资源对象的代码
 */
