//需求：掌握finally关键字用法，注意它与return和System.exit(0);之间的执行关系
package finallyTest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

//建类
public class FinallyDemo {
    // 主方法
    public static void main(String[] args) {
        // finally不能单独用，要与try连用或try-catch连用
        int num01 = 10;
        int num02 = 2;
        try {
            int ret = num01 / num02;
            System.out.println(ret);
        } catch (ArithmeticException e) {
            e.getStackTrace();
        } finally {
            System.out.println("有bug就改，改着改着就习惯了");
        }
        try {
            int ret = num01 / num02;
            System.out.println(ret);
        } finally {
            System.out.println("有bug就改，改着改着就习惯了");
        }
        // 在catch子句或try语句中用关闭JVM方法，finally语句块不会执行
        OutputStream output = null;
        try {
            // 打开一个资源对象
            output = new FileOutputStream("d:/12345.txt");
            // 一般，当我们在try语句中打开物理资源，会在finally语句中关闭资源
        } catch (FileNotFoundException e) {
            // 如果有找不到文件的异常，打印异常类型名和异常信息，以及程序中异常出现的位置
            e.printStackTrace();
            // 用getMessage方法，返回异常信息
            System.out.println(e.getMessage());
        } finally {
            try {
                // 关闭前面打开的资源
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("我在这里运行啦！");
        }
        // 调用mathTest方法，观察返回结果.返回64，证明mathTest中最终执行了finally中的returm语句，执行了+1
        System.out.println(FinallyDemo.mathTest());

        // 调用mathTest02方法，观察返回结果.返回z+1,但若把finally语句的return删去，则返回2，即没有+1
        System.out.println(FinallyDemo.mathTest02());

    }

    public static int mathTest() {
        // 在catch子句中用return方法，finally语句块一定会执行，当两者都存在return值 时，观察结果
        int i = 63;
        try {
            return 63;
        } finally {
            return ++i;
        }
    }

    public static int mathTest02() {
        // 用debug观察，在语句块外定义int变量，在try语句和finally语句分别return变量，观察结果
        int z = 2;
        try {
            return z;
        } finally {
            ++z;
            // return z;
        }
    }
}
/**
 * 小结：finally一般用于关闭前面打开的资源，里面代码一定会执行，除非前面用了关闭JVM的方法
 */
