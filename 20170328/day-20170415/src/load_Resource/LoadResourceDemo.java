//需求：用反射加载资源文件，路径
//步骤：（1）创建资源文件；
//（2）在主方法建三个方法，分别用三种形式测试
//方法一：使用绝对路径的方式加载.
//方法二：使用相对路径-相对于classpath的根路径(字节码输出目录).
//方法三：使用相对路径-相对于当前加载资源文件的字节码路径
package load_Resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadResourceDemo {

    public static void main(String[] args) throws Exception {
        //test1();
        //test2();
        test3();
    }
    //方法一：使用绝对路径的方式加载.
    private static void test1() throws Exception {
        // (1)新建文件对象，新建字节输入流对象，建Properties对象
        File file = new File("D:/classtest/20170328/day-20170415/resources/db.properties");
        InputStream in = new FileInputStream(file);
        Properties p = new Properties();
        // (2)用Properties对象调用load方法，用getProperty输出指定的key对应的value
        p.load(in);
        System.out.println(p.getProperty("username"));
        
    }
  //方法二：使用相对路径-相对于classpath的根路径(字节码输出目录)
    private static void test2() throws Exception {
        // (1)建Properties对象
        Properties p = new Properties();
        // (2)要用ClassLoader加载资源文件，默认从classpath路径寻找资源文件
        
        // 返回该类的字节码对象，以此返回该类的类加载器对象，用ClassLoader的对象接受
        // 等于ClassLoader cl = Thread.currentThread().getContextClassLoader();
        ClassLoader cl = LoadResourceDemo.class.getClassLoader();
        // 建字节输入流对象，用类加载器把资源文件转换为输入流,由于是相对路径，文件名简写
        InputStream in = cl.getResourceAsStream("db.properties");
        // 用Properties对象调用load方法，加载输入流
        p.load(in);
        System.out.println(p.getProperty("password"));
    }

    // 方法三：使用相对路径-相对于当前加载资源文件的字节码路径
    private static void test3() throws Exception {
     // (1)建Properties对象
        Properties p = new Properties();
        // (2)建字节输入流对象，用类加载器把资源文件转换为输入流,由于是相对路径，文件名简写
        InputStream in = LoadResourceDemo.class.getResourceAsStream("db.properties");
        // 用Properties对象调用load方法，加载输入流
        p.load(in);
        System.out.println(p.getProperty("password"));
        //输出空指针异常，因为现在资源文件存在resources包中，在这里使用的是LoadResourceDemo的字节码路径去寻找db.properties文件.
        //也就是从bin/com/_520i/_06_load_resource路径去寻找. 

    }
}
/**
 * 小结：以后把资源文件放进source Folder包中，资源文件会被自动加载进bin文件夹里
 * 用相对路径，相对于classpath的根路径来加载资源文件
 */
