//需求：在Java程序中加载properties文件,获取该文件中的数据
//步骤：（1）先创建properties文件，由于它是Map的实现类，在里面写入键值对（模仿用户名和密码）
//（2）用load方法，要读取文件中的数据，用输入流，由于properties的键和值都是String，用字节输入流InputStream
package propertiesDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesTest {

    public static void main(String[] args) throws Exception {
        // 建文件对象
        File file = new File("src/db.properties");
        // 建输入流对象
        InputStream in = new FileInputStream(file);
        // 建properties对象
        Properties p = new Properties();
        // load(InputStream inStream) 从输入流中读取属性列表（键和元素对）。
        // 用properties对象调用load方法，传入InputStream对象，从输入流中读取键值对
        p.load(in);
        // 从输入流中读取键值对后，用getProperty(String key)  用指定的键在此属性列表中搜索属性,返回 String。
        System.out.println(p.getProperty("password"));
        System.out.println(p.getProperty("username"));
    }
}
/**
 * 小结：注意加载properties文件并获取该文件中的数据的步骤
 * （1）建文件对象，建输入流对象
 * （2）建properties对象
 * （3）用properties对象调用load方法，传入输入流对象，从输入流中读取键值对
 * （4）从输入流中读取键值对后，用getProperty(String key)  用指定的键在此属性列表中搜索属性,返回 String
 */
