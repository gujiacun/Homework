//需求：练习Calendar类。创建日历对象，直接打印，用get方法返回给定日历字段的值，注意月份从0算起，要加1
//Calendar对象转为Date对象。为指定的日历字段加/减特定的时间值
package dateTest;

import java.util.Calendar;
import java.util.Date;

public class Calendar01 {

    public static void main(String[] args) {
        // 创建日历对象,格式特殊
        Calendar diary = Calendar.getInstance();
        System.out.println(diary);
        // get(int field) 返回给定日历字段的值,实例方法。
        System.out.println(diary.get(Calendar.YEAR));
        System.out.println(diary.get(Calendar.MONTH) + 1);
        System.out.println(diary.get(Calendar.DAY_OF_MONTH));
        System.out.println(diary.get(Calendar.HOUR_OF_DAY));
        System.out.println(diary.get(Calendar.MINUTE));
        System.out.println(diary.get(Calendar.SECOND));
        // 其中YEAR，MONTH，DAY_OF_MONTH，HOUR_OF_DAY，MINUTE，SECOND均为字段
        // Calendar对象转为Date对象,由Calendar对象调用getTime()方法
        Date date = diary.getTime();
        System.out.println(date);
        
        //一千年以后,括号第一个要填Calendar里的字段
        diary.add(Calendar.YEAR, 1000);
        System.out.println(diary);
        Date date02 = diary.getTime();
        System.out.println(date02);
    }
}
/**
 * 小结：以后多用Calendar类里的方法，记住用法，特别是其字段。
 */
