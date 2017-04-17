//需求：操作String的两种对象创建方式，记住它们两者的区别
//操作两种比较字符串方式，理解它们的区别
package homeworkTest;

//建类
public class StringTest {
    // 主方法
    public static void main(String[] args) {
        // 第一种方法，通过双引号直接赋值，在方法区的运行常量池里直接存储常量
        String name = "江主席";
        // 第二种方法，新建对象，在堆空间开辟空间
        String behavior = new String("为心上人强闯春晚直播现场");
        System.out.println(name);
        System.out.println(behavior);
        // 比较两个字符串，用双等号，比较引用地址
        String name2 = "江主席";
        // 由于这两个变量的值都存储在运行常量池，而且是同一个，所以相等
        System.out.println(name == name2);
        String name3 = new String("江主席");
        // name3开辟了新的内存空间，所以不相等
        System.out.println(name2 == name3);
        // 用equals方法比较，比较的是内容
        System.out.println(name2.equals(name3));
    }

}
/**
 * 小结：String创建对象方式的区别，里面隐藏着比较两个字符串的不同方式差异的联系，可见软件层面的不同知识点往往藏着联系，而且与底层硬件有关。
 */
