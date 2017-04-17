//需求：操作java7新特性，catch语句的参数列表可以写多个异常，中间用|连接
package throwTest;

//测试类
public class NewCatchTest {
    // 主方法
    public static void main(String[] args) {
        // 写能产生错误的代码，捕获，catch语句用新特性
        String num01 = "160";
        String num02 = "0B";
        try {
            // 转换格式，可能产生数字格式异常
            int a = Integer.parseInt(num01);
            int b = Integer.parseInt(num02);
            int c = a / b;
            System.out.println(c);
            // 假设b为0，是算术异常，若b为0B，是数字格式化异常,同一时间只能产生一个异常，注意格式，变量名要放在最后
        } catch (ArithmeticException | NumberFormatException e) {
            // 打印异常类型名和异常信息，以及程序中异常出现的位置
            e.printStackTrace();
        }
    }
}
/**
 * 小结：catch语句的参数列表可以写多个异常，中间用|连接，变量名要放在最后
 * 这与以前的用多个catch语句来捕获多个异常实质是一样的。
 */
