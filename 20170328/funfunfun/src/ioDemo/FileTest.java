package ioDemo;

import java.io.File;

public class FileTest {

    public static void main(String[] args) {
        // 此时two文件夹在one文件夹下面
        File folder = new File("text.txt");
        // 判断文件是否存在
        System.out.println(folder.exists());
        // 读取文件名称 ,即使在浏览器中更改，输出的也是创建文件时指定的名称
        System.out.println(folder.getName());
        // 读取文件路径 
        System.out.println(folder.getPath());
        // 读取文件绝对路径 
        System.out.println(folder.getAbsolutePath());
        // 获取文件父级路径 ，第一种可能会返回null,用第二种
        System.out.println(folder.getParent());
        System.out.println(new File(folder.getAbsolutePath()).getParent());
        // 获取文件大小
        System.out.println(folder.length() + "bytes");
        // 判断文件是否被隐藏
        System.out.println(folder.isHidden());
        // 文件是否可读
        System.out.println(folder.canRead());
        // 文件是否可写
        System.out.println(folder.canWrite());
        // 判断文件是否为文件夹
        System.out.println(folder.isDirectory());
    }
}
