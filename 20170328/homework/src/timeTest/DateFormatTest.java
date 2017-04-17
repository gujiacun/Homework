//需求：把Date类型和String类型互相转换，输出按照自定义格式的时间
package timeTest;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;


//建类
public class DateFormatTest {
    // 主方法
    public static void main(String[] args) throws ParseException {
        // 把Date类型转换为String类型
        Date time = new Date();
        System.out.println(time);
        // String date = time.toString();
        // DateFormat创建对象特殊，等号后要跟DateFormat.方法();
        DateFormat time02 = DateFormat.getInstance();
        // Date没有转换为String的方法，必须先创建DateFormat对象，通过对象调用方法，再输入Date的对象
        String s = time02.format(time);
        System.out.println(s);
        // 把String类型转换为Date类型,必须先通过DateFormat对象调用parse方法，再输入String对象
        Date result = time02.parse(s);
        System.out.println(result);
    }

}
/**
 * 小结：把Date类对象与String对象互相转换，必须通过DateFormat的对象和方法作为中间桥梁，DateFormat对象创建有特殊格式
 */

