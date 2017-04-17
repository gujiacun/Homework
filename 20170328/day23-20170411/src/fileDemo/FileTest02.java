//需求：操作File路径和名称，检测File状态的方法

package fileDemo;

import java.io.File;
import java.util.Date;

public class FileTest02 {

    public static void main(String[] args) {
        File file = new File("D:/Skin/789.txt");
        // File getAbsoluteFile() :获取绝对路径，返回File类型
        System.out.println(file.getAbsoluteFile());
        // String getAbsolutePath():获取绝对路径,返回String类型
        System.out.println(file.getAbsolutePath());
        // String getPath() :获取文件路径,把路径名转为String类型
        System.out.println(file.getPath());
        // String getName() :获取文件名称
        System.out.println(file.getName());
        // File getParentFile():获取上级目录文件,如果此路径名没有指定父目录，则返回 null
        System.out.println(file.getParent());
        System.out.println(file.getAbsoluteFile().getParentFile());
        // String getParent() :获取上级目录路径
        System.out.println(file.getParentFile());
        System.out.println(file.getAbsoluteFile().getParent());
        
        
        // 检测File状态的方法:
        // boolean canExecute() :判断是否是可执行文件
        Boolean whether = file.canExecute();
        System.out.println(whether);
        // boolean canRead() :判断该文件是否可读
        Boolean readable = file.canRead();
        System.out.println(readable);
        // boolean canWrite():判断该文件是否可写
        Boolean writable = file.canWrite();
        System.out.println(writable);
        // boolean isHidden():判断该文件是否是隐藏文件
        System.out.println(file.isHidden());
        // long lastModified():判断该文件的最后修改时间
        Long lastTime = file.lastModified();
        System.out.println(new Date(lastTime).toLocaleString());
        // long length():获取该文件的长度大小(单位字节)
        System.out.println(file.length() / 1024 + "kb");
        // to-generated method stub

    }
}
/**
 * 小结：熟练记住File类所有的方法，以此为基础搭建更复杂功能
 */
