//需求：打印一个文件夹中所有的子文件夹及文件的名字
//步骤：（1）创建文件夹对象，自定义方法并传入对象
//（2）用list方法，能返回此路径名的文件和目录，类型为String[]，再把数组打印
//(3)但上一步只能列一级目录中的所有文件和目录，要列出子文件夹中的文件，即进入下一级
//（4）用isFile是否为文件判断/或用isDirectory是否为文件夹，若是文件夹就再次调用自身方法（递归）
//（5）为做成上一步，必须把list方法改为ListFile方法，返回File类型数组
package fileDemo;

import java.io.File;

public class FileRecursion {

    public static void main(String[] args) {
        // 这里传入的是文件夹的绝对路径
        File file = new File("D:/20170411");
        // 自定义方法，把遍历文件夹内所有内容都封装为一个方法
        FileRecursion.listAllFiles(file);
    }

    public static void listAllFiles(File file) {
        // 返回File数组,返回此目录中所有的文件和文件夹
        File[] array = file.listFiles();
        // 循环，判断
        for (File file2 : array) {
            // 打印数组中的元素（文件夹内某一层的文件和文件夹
            System.out.println(file2);
            // 假如在数组中的某个元素是文件夹，再次调用此方法
            if (file2.isDirectory()) {
                listAllFiles(file2);
            }
        }
    }
}
/**
 * 掌握递归，理解好每一步的含义，仔细分析
 */
