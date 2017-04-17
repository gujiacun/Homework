package ioDemo;

import java.io.File;

public class FileScanner {

    public static void main(String[] args) {
        //也可以写为printFiles(new File("绝对路径"));
        printFiles(new File("../需要遍历的文件夹名"));
        //  ../表示当前路径的上一级路径，"../需要遍历的文件夹名"表从更高一层获得文件夹
    }
    public static void printFiles(File dir){
        //传入的对象，判断，如果是文件夹，将里面所有文件列出来
        //如果不是文件夹，不输出数据
        if (dir.isDirectory()) {
            File[] array = dir.listFiles();
            for (int i = 0; i < array.length; i++) {
                // 无论是文件/文件夹，都输出名称
                System.out.println(array[i].getName());
                //由于listFiles可能返回文件或文件夹，还要判断
                if (array[i].isDirectory()) {
                    //假如数组中此元素为文件夹，再调用这方法自身，打印内部文件
                    printFiles(array[i]);
                }
            }
        }
    }
}
