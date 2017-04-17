//需求：在一个文件夹中有许多各种类型的文件，打印出格式为".docx"的所有文件的名字
//步骤：（1）创建文件夹对象，填入该文件夹绝对地址
//（2）用listFiles得到文件夹内所有文件和文件夹，存为File[]
//（3）在上一步中传入过滤器FilenameFilter的匿名内部类，判断规则为是文件而且以".docx"结尾
package fileDemo;

import java.io.File;
import java.io.FilenameFilter;

public class FileNameFilterDemo {

    public static void main(String[] args) {
        // 建文件夹
        File dir = new File("D:/20170411");
        //listFiles(FilenameFilter filter),传入过滤器，返回符合过滤规则的文件和文件夹
        File[] files = dir.listFiles(new FilenameFilter(){
            //用匿名内部类，重写方法时记得方法的返回类型和参数类型
            public boolean accept(File dir,String name){
                return new File(dir,name).isFile() && name.endsWith(".docx"); 
            }
        });
        //输出结果
        for (File file : files) {
            System.out.println(file);
        }
    }
}
/**
 * 小结：匿名内部类适用于只使用一次的场合，记住常用方法
 */
