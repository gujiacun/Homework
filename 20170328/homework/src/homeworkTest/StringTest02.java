//需求：操作String的两道面试题，理解String对象之间的区别
package homeworkTest;

//建类
public class StringTest02 {
    // 主方法
    public static void main(String[] args) {
        // 给String创建对象，用双引号和new的区别
        // 前者在方法区的运行常量池里直接存储常量
        // 最多创建一个String对象,最少不创建String对象.
        // 如果常量池中,以及存在"续1秒",那么age直接引用,此时不创建String对象.
        // 否则,先在常量池先创建"续1秒"内存空间,再引用.
        String age = "续1秒";

        // 后者新建对象，在堆空间开辟空间
        // 最多创建两个String对象,至少创建一个String对象.
        // new关键字:绝对会在堆空间,创建内存区域，所以至少创建一个String个对象.
        String life = new String("时间众筹学");

        // 题目二：比较以下字符串是否相等
        String a = "AB";
        String a1 = "A" + "B";
        //经过编译优化，a和a1在常量池引用同一块区域
        System.out.println(a == a1);
        String a2 = new String("AB");
        //a2的值存储在堆空间，a的值在方法区，引用地址不同
        System.out.println(a == a2);
        String temp = "A";
        String a3 = temp + "B";
        //一个是变量，一个是引号创建，整个表达式的值在运行时在堆空间创建
        System.out.println(a3 == a);

    }

}
/**
 * 小结：需要补充硬件及计算机系统的姿势水平。
 */
