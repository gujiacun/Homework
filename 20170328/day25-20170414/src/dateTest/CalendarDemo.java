//需求:计算起止时间，查询最近一周.......的信息
//步骤：（1）新建Date对象，返回此时时间；把当前系统时间作为Calendar类的日历时间
//(2)设置完结时间，先把日增加1天，再把时分秒设置为0
//（3）根据结束时间减去7天，得到开始时间
package dateTest;

import java.util.Calendar;
import java.util.Date;

public class CalendarDemo {

    public static void main(String[] args) {
        //新建Date对象
        Date date = new java.util.Date();
        //新建Calendar对象,返回此时的系统时间
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        System.out.println(c);
        //设置完结时间，先把日增加1天,注意Calendar.DAY_OF_MONTH是静态字段
        c.add(Calendar.DAY_OF_MONTH, 1);
        //再把时分秒设置为0，set(int field, int value)  将给定的日历字段设置为给定值。
        //直接用set方法最方便
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        //得到结束时间
        Date endTime = c.getTime();
        //据结束时间用add方法设置开始时间
        c.add(Calendar.DAY_OF_MONTH, -7);
        Date beginTime = c.getTime();
        //打印两者
        System.out.println("开始时间：" + beginTime);
        System.out.println("结束时间：" + endTime);
    }
}
/**
 * 小结：
 * add方法与set方法注意区分，set(int field, int value) 将给定的日历字段设置为给定值
 * add(int field, int amount) 根据日历的规则，为给定的日历字段添加或减去指定的时间量
 */
