//需求：操作Scanner类，在控制台输入string，int，boolean类型数据，操作方法打印出对应的值
package scannerDemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerTest {

    public static void main(String[] args) throws FileNotFoundException {
        // 提示用户输入不同数据
        System.out.println("姓名:");
        // 建Scanner类的对象,System.in返回的是InputStream的对象
        Scanner sc = new Scanner(System.in);
        // 输入后，打印出对应的值
        System.out.println(sc.nextLine()); 
        System.out.println("年龄:");
        System.out.println(sc.nextInt()); 
        System.out.println("是否结婚:");
        System.out.println(sc.nextBoolean()); 
        
        //扫描文件中的数据，当还有下一行数据时，把它打印（while循环）
        // 创建文件对象
        File file = new File("11111/Untitled 2");
        // 指定扫描器要扫描的文件
        Scanner scanner = new Scanner(file);
        // 如果在此扫描器的输入中存在另一行，则返回 true
        while (scanner.hasNextLine()) {
            // 此扫描器执行当前行，并返回跳过的输入信息，返回String类型
            System.out.println(scanner.nextLine());;
        }
        // 由于Scanner属于IO流，所以要关闭
        scanner.close();
        sc.close();
    }
}
/**
 * 小结：扫描器可以用于人机交互输入窗口
 */
