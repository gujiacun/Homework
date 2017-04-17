//需求：自创日期的工具类，把Date类型对象和String类型互相转换
//（1）在主方法建格式化操作方法和 解析操作方法,注意各自的返回值和参数类型
package dateTest;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static void main(String[] args) {
        System.out.println(dateToString(new Date(), "yyyy-MM-dd"));
    }

    // 私有化构造器
    private DateUtil() {

    }

    // 默认的时间格式
    public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

    // 格式化操作方法,由于要转换格式，格式应该由调用者指定/传入
    public static String dateToString(Date date, String pattern) {
        // 创建SimpleDateFormat对象
        SimpleDateFormat sdf = new SimpleDateFormat();
        // 假如调用时没有传入格式，用默认格式
        if (pattern.equals(null)) {
            pattern = DEFAULT_DATE_PATTERN;
        }
        // applyPattern(String pattern) 将给定模式字符串应用于此日期格式。
        sdf.applyPattern(pattern);
        // SimpleDateFormat的对象有format方法，将给定的 Date 格式化为日期/时间字符串
        return sdf.format(date);
    }

    // 重载构造器，假如调用时没有传格式，用默认的时间格式
    public static String dateToString(Date date) {
        // 调用上面的方法
        return dateToString(date, DEFAULT_DATE_PATTERN);
    }

    // 解析操作方法
    public static Date stringToDate(String str, String pattern) throws Exception {
        // 创建SimpleDateFormat对象
        SimpleDateFormat sdf = new SimpleDateFormat();
        return sdf.parse(str);
    }
}
/**
 * 小结：把Date类型对象和String类型互相转换，中间要通过SimpleDateFormat类，分别是format和parse方法
 */
