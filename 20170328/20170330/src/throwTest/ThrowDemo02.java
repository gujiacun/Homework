//需求：操作throw，掌握它的格式和应用场景
package throwTest;

//测试类
public class ThrowDemo02 {
    // 主方法
    public static void main(String[] args) throws Exception {
        // 在主方法内调用test方法
        System.out.println("调用test方法前");
        // 在这里把由test方法传来的异常捕获并处理，代码块后面的语句可以执行
        try {
            ThrowDemo02.test();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("调用test方法后");
        // 把String对象传给money方法
        String price = "9k";
        ThrowDemo02.money(price);
        System.out.println("lll");
    }

    public static void test() throws Exception {
        // 新建方法，查看String类的charAt方法源代码
        String str = "QWERASD";
        // 如果传入的值不符要求，会抛出StringIndexOutOfBoundsException
        char word = str.charAt(3);
        int a = 10;
        // System.out.println(c);
        // 格式为throw new 异常类名("异常信息");
        if (a == 10) {
            // 这里在方法内部手动抛出一个具体的异常对象，若没有向方法的调用者抛出异常，程序执行到这里会终止
            // 若在test方法首行加throws ArithmeticException，程序会在此行停止，因为
            // ArithmeticException是非受检异常，出现时java编译器不会检查它，但一旦出现异常程序会停止
            // 若想此方法的调用者处理这个抛出的异常，在方法首行写throws
            // Exception，此时方法调用者将被强制要求处理（try-catch）或继续抛出，直至JVM接受异常
            throw new ArithmeticException("搞这种异常出来还怎么成为大牛啊？");
        }
    }

    // 由于NumberFormatException是RuntimeException的子类，方法调用者可以不处理，所以改为Exception
    public static void money(String money) throws Exception {
        // 把传进来的String对象转换为int类型变量，同时用try-catch包围处理，并在catch子句中用throw抛出具体异常类对象，用throws把异常返回给方法调用者
        try {
            int num = Integer.parseInt(money);
            // NumberFormatException
        } catch (NumberFormatException e) {
            e.printStackTrace();
            throw new NumberFormatException("不要犯低级错误，这是送分题");
        }

    }

}
/**
 * 小结：运用于方法内部,给方法的调用者返回具体的异常对象,和return一样会结束当前方法，可以与try-catch合用
 */
