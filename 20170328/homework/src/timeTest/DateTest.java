//需求：操作Date类中一些方法
package timeTest;

import java.util.Date;

//建类
public class DateTest {
    //主方法
    public static void main(String[] args) {
        //使用匿名对象，输出当前时间
        System.out.println(new Date());
        //比较两个日期的顺序
        Date a = new Date(20160710);
        Date b = new Date(20160708);
        int i = a.compareTo(b);
        //若a晚于b，返回1，若a早于b，返回-1
        System.out.println(i);
        //测试此日期是否在指定日期之后
        Date c = new Date(20160728);
        //此方法只能输入Date的对象，所以要先创建对象，返回boolean
        boolean num = a.after(c);
        System.out.println(num);
    }

}
/**
 * 小结：此类方法大部分已过时，在使用方法时要先记住填入的和返回的是什么样的数据类型
 */
