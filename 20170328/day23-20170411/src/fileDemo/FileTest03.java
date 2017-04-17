//需求：File类中方法-文件/文件夹操作
package fileDemo;

import java.io.File;
import java.io.IOException;

public class FileTest03 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        File file = new File("D:/20170411/456.txt");
        // boolean isFile() :是否是文件
        System.out.println(file.isFile());
        // boolean createNewFile() :创建新的文件
        try {
            //只有制定的路径没有文件时才能创建成功，若返回失败，说明此路径下已有同名文件
            System.out.println(file.createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
        // static File createTempFile(String prefix, String suffix) :创建临时文件
        try {
            //前缀名和后缀名都是string，加双引号
            File.createTempFile("frog", ".tmp");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // boolean delete() :删除文件
        //file.delete();
        // void deleteOnExit() :在JVM停止时删除文件
        //file.deleteOnExit();
        // boolean exists():判断文件是否存在
        System.out.println(file.exists());
        // boolean renameTo(File dest) :重新修改名称
        // 括号内填入File对象
        File newFile = new File("D:/20170411/789.txt");
        file.renameTo(newFile);
        // ---------------------------------------------------------------------
        System.out.println("-----------------");
        // File类中方法-目录操作
        File directory = new File("D:/20170411");
        // boolean isDirectory() :判断是否是目录
        System.out.println(directory.isDirectory());
        // boolean mkdir() :创建当前目录
        // 已经存在此目录，创建失败
        System.out.println(directory.mkdir());
        // boolean mkdirs() :创建当前目录和上级目录
        File newDirectory = new File("D:/excited");
        newDirectory.mkdirs();//创建成功
        // String[] list() :列出所有的文件名
        String[] files = directory.list();
        for (String str : files) {
            System.out.println(str);
        }
        // File[] listFiles() :列出所有文件对象
        File[] newFiles = directory.listFiles();
       for (File file2 : newFiles) {
           //返回的是所有元素的绝对路径名（File对象）
        System.out.println(file2);
    }
        // static File[] listRoots() :列出系统盘符
       File[] xxx = directory.listRoots();
       for (File file2 : xxx) {
        System.out.println(file2);
    }
    }
}
/**
 * 小结：创建文件夹和文件的mkdir和createNewFile方法都不许传入参数
 */
