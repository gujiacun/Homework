//需求：操作try catch 语句，认清及理解捕获异常的格式及用法
//步骤：（1）新建两个double类型，进行除法运算
//（2）用try语句包围它们，用catch子句捕获他们可能产生的一场
//（3）在不同位置打印信息，验证try catch 语句的执行顺序
package handle;

//建类
public class TryCatchTest {
    // 主方法
    public static void main(String[] args) {
        double a;
        double b;
        // 在下面给两个变量赋值，根据不同情况赋不同的值
        // （1）传10.0和2.0；（2）传10.0和B，出现Exception in thread "main" java.lang.Error:
        // Unresolved compilation problem
        // （3）假如传'B',系统自动把字符转为int类型数字；（4）传10.0和0.0/0，在double中没出现异常，假如是int类型则会报错
        a = 10.0;
        b = 0;
        int a1 = 10;
        int b1 = 0;
        // 创建两个String对象,分别传不同的值：（1）传10和5；（2）传10和5b；（3）传10和0
        String a2 = "10";
        String b2 = "0";
        // 进行除法运算，，以下两行代码可能产生异常，包围捕获错误语句
        try {
            double c = a / b;
            System.out.println(c);
            int c1 = a1 / b1;
            // int类型数字相除，不允许除数为0，此处产生算术异常，跳转到第一个catch语句块并执行里面语句
            System.out.println(c1);
            // 记住catch是一个方法，后跟参数列表
        } catch (ArithmeticException e) {
            System.out.println("别他妈老往老子身上扔算术异常");
            // 要获取异常信息,用Throwable类的方法，都是实例方法
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("别他妈老往老子身上扔数字格式异常");
            e.printStackTrace();
        }
        // 会，因为try-catch捕获异常后程序并没有停止运行
        System.out.println("你猜猜上面有异常我还会不会执行？");
        // int s1 = Integer.parseInt(a2);
        // 实验可知，若转换格式的语句在try语句块外面，出现错误时程序直接报错并终止运行
        // int s2 = Integer.parseInt(b2);
        try {
            int s1 = Integer.parseInt(a2);
            int s2 = Integer.parseInt(b2);
            int result = s1 / s2;
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("又他妈扔算术异常给我");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("又他妈扔数字格式异常给我");
            e.printStackTrace();
        }
    }

}
/**
 * 小结：理解try语句，可以和throw一起用，它本身不处理异常，而是捕获，比较影响性能
 */
