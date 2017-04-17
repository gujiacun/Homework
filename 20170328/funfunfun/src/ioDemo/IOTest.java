package ioDemo;

import java.io.File;
import java.io.IOException;

public class IOTest {

    public static void main(String[] args) {
        // 创建文件对象，新建出来，但其实不存在
        // 只指定文件名，没指定路径，这是相对路径
        // 若写为bin/hello.txt 会建在bin文件夹下，写../hello.txt,建在上一级文件中
        // 写../../hello.txt,建在上一级的上一级文件中
        File file = new File("hello.txt");
        //文件是否存在
        if (file.exists()) {
            //文件的重新命名
            //(1)创建新文件，命名，新文件可以是空的，不指向任何文件
            File newFile = new File("new Hello.txt");
            //(2)用旧文件调用renameTo方法，传入新文件对象
            file.renameTo(newFile);
        } else {
            System.out.println("文件不存在");
            try {
                // 创建新文件
                file.createNewFile();
                System.out.println("文件已成功被创建");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("文件无法被创建");
            }
        }

        System.out.println(file.exists());
        // file.delete();
    }

}
