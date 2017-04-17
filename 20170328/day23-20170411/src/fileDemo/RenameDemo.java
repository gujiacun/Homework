//需求：批量修改一批前缀名共同的文件的名称
//步骤：（1）首先进入这批文件所在的文件夹，返回所有文件的File对象，组合成File数组
//（2）用String定义需要删除的部分（共同的前缀名）
//（3）用for-each循环，把里面包含需要删除部分的每个元素的名字修改(用renameTo)
package fileDemo;

import java.io.File;

public class RenameDemo {

    public static void main(String[] args) {
        // 创建File对象,进入所修改的文件所在的文件夹
        File dir = new File("D:/20170411");
        // 得到在此文件夹下的所有文件
        File[] files = dir.listFiles();
        //需要删除的部分（共同的前缀名）
        String deleteStr = "wallace-frog-talk-";
        //用for-each取出每个元素，再修改其名字
        for (File file : files) {
            //由于文件夹内可能有一些文件不包含要删除的字符串，先判断，包含才进行删除
            if (file.getName().contains(deleteStr)) {
                //创建字符串接收新名字，把旧名字用replace方法替换
                //用renameTo重命名，填入匿名对象，构造器再传上一级的文件夹路径，新名字
                String newName = file.getName().replace(deleteStr, "");
                file.renameTo(new File(dir,newName));
            }
        }
        
    }
}
/**
 * 小结：几种方法混合使用，最重要记住他们各自的用法和返回值类型
 */
