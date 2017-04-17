//需求：拷贝指定源目录的指定类型文件到指定目录文件，同时重命名
//步骤：（1）创建源目录的对象，先用listFiles获取指定源目录下的所有文件夹和文件，同时用文件名过滤器和isFile方法把指定类型文件存到File[]中
//（2）拷贝操作，建输出/入流对象，建缓冲区，循环操作，以read方法是否返回-1作为是否读到文件末尾的循环判断条件
//（3）重命名，先得到新文件夹下所有的文件对象，再用string定义新名字，用renameTo替换旧名字
package copyDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyDemo03 {

    public static void main(String[] args) throws Exception {
        // 创建源目录的对象
        File resDir = new File("D:/java从零开始视频及电子书教程/极客学院/01/01");
        File destDir = new File("D:/java从零开始视频及电子书教程/极客学院/02");
        resDir.setReadable(true,true);
        destDir.setWritable(true,true);
        // 获取所有的文件夹和文件,同时用文件名过滤器和isFile方法把指定类型文件存到File[]中
        File[] array = resDir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir, name).isFile() && name.endsWith(".mp4");
            }
        });
        // 建输出/入流对象
        InputStream in = new FileInputStream(resDir);
        OutputStream out = new FileOutputStream(destDir);
        // 建缓冲区
        byte[] arr = new byte[1024];
        int len = -1;
        while ((len = in.read(arr)) != -1) {
            out.write(arr);
        }
        out.close();
        in.close();
        File[] array02 = destDir.listFiles();
        for (int i = 0; i < array02.length; i++) {
            String newName = String.valueOf(i);
            array02[i].renameTo(new File(destDir,newName));
        }
    }
}
/**
 * 小结：复杂操作往往是由多个简单单操作拼合而成，要一开始先了解需求，设计出步骤，每次只思考同一个平面上的步骤
 */
