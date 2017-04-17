//需求：操作String常用方法
package homeworkTest;

import java.util.Arrays;

//建类
public class StringTest03 {
    // 主方法
    public static void main(String[] args) {
        // String转换为char数组，byte数组
        // byte[] byteArray = array.getBytes();
        System.out.println(Arrays.toString("ACD".getBytes()));
        // 把String转为char数组
        String array = "ABCDAEFGA";
        char[] charArray = array.toCharArray();
        System.out.println(Arrays.toString(charArray));
        // 获取字符串信息
        // （1）返回此字符串的长度
        int length = array.length();
        System.out.println(length);
        // （2）返回指定索引处的 字符值
        int ind = array.indexOf('G');
        System.out.println(ind);
        // （3）返回指定子字符串在此字符串中第一次出现处的索引。
        int index = array.indexOf("FG", 2);
        System.out.println(index);
        // （4）返回指定子字符串在此字符串中最右边出现处的索引
        int lastIndex = array.lastIndexOf("DA");
        System.out.println(lastIndex);
        // 字符串比较判断
        String compareThing = "ABCDaEFGA";
        System.out.println(array.equals(compareThing));
        System.out.println(array.equalsIgnoreCase(compareThing));
        // 字符串大小写转换
        System.out.println(compareThing.toUpperCase());
        System.out.println(compareThing.toLowerCase());

    }

}
/*
 * 小结：对于类中的实例方法，要先创建对象，用对象调用方法。对于静态方法，用类名.方法(参数有时是对象)来调用。
 */
