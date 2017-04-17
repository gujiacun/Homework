//操作BigInteger和BigDecimal,掌握它们的两种传入值的方法，把普通数值转为大数值的方法，加减乘除方法
package MathTest;

//import java.io.PrintWriter;
//import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
class LoggerTest{
    
    private static final Logger myLogger = Logger.getLogger("com.company.maapp");
}
//建类
public class BigTest {
    // 主方法
    public static void main(String[] args) {
        Logger.getGlobal().info("File->Open menu item selected");
        Logger logger = Logger.getLogger("com.mycompany.myapp");
        logger.setLevel(Level.FINE);
        logger.setUseParentHandlers(false);
        Handler handler = new ConsoleHandler();
        handler.setLevel(Level.FINE);
        logger.addHandler(handler);
        // 通过新建对象传入值
        BigDecimal number01 = new BigDecimal(3.5);
        BigDecimal number02 = new BigDecimal(2.4);
        // 两个大数值相加，用add方法
        System.out.println(number01.add(number02));
        // 得到结果不精确，用调用构造方法传入值时，优先使用String构造方法
        BigDecimal number03 = new BigDecimal("3.5");
        BigDecimal number04 = new BigDecimal("2.4");
        // 得到结果精确
        System.out.println(number03.add(number04));
        // 用valueOf传值,这方法是静态方法,用类名调用，更节省资源。
        BigDecimal num = BigDecimal.valueOf(200.05);
        System.out.println(num);
        // 减
        System.out.println(num.subtract(number01));
        // 乘
        System.out.println(num.multiply(number02));
        // 除
        MathContext mc = new MathContext(2, RoundingMode.HALF_DOWN);
        System.out.println(num.divide(number02, mc));
        // Throwable t = new Throwable();
        // StringWriter out = new StringWriter();
        // t.printStackTrace(new PrintWriter(out));
        // String description = out.toString();
        
    }

}
/**
 * 小结：还有很多方法，这也要求我以后学习离散数学，实现算法，记住BigDecimal和BigInteger都是类，推荐通过valueOf传值
 */
