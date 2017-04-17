//需求：通过自定义日期格式来转换日期
//步骤:（1）先把自定义的格式定为String类型
//（2）创建SimpleDateFormat的对象
//（3）通过对象调用applyPattern()方法，填入第一步的String
//（4）用format方法转换为String类型并输出
//（5）把SimpleDateFormat的对象转为Date类型
package timeTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class SimpleDateFormatTest {

        //主方法
        public static void main(String[] args) throws ParseException {
            String pattern = "yyyy/MM/dd HH:mm";
            SimpleDateFormat time = new SimpleDateFormat();
            time.applyPattern(pattern);
            SimpleDateFormat time02 = new SimpleDateFormat(pattern);
            //格式化，注意format方法括号内要填Date类型的对象，可以用匿名对象
            String a = time.format(new Date());
            String b = time02.format(new Date());
            System.out.println(a);
            System.out.println(b);
            //解析括号内填String对象
            Date dd = time.parse(a);
            System.out.println(dd);
        }

    }
/**
 * 小结：format方法括号内要填Date类型的对象，可以用匿名对象
 * 把SimpleDateFormat的对象转为Date类型,用parse()方法，括号内填String对象
 */