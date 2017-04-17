//需求：做第一题，全面复习基本数据类型的知识点
package allSoulsDay;

//测试类
public class NumbersTest {
    // 主方法
    public static void main(String[] args) {
        // 第一题
        // （1）没有错误
        int i0 = 1;
        int j;
        System.out.println(i0);
        // （2）把第一行的数字后加f/F，因为java默认小数是double类型
        float f1 = 0.1f;
        float f2 = 123;
        // 把第三行的float改成double，因为数字后面加上了d，是double类型
        double f3 = 34d;
        // （3）把第三行的数据类型改为short，因为129已经超出byte类型的范围
        byte b1 = 1;
        byte b2 = -128;
        short b3 = 129;
        //（4）把第三行的右边结果转为int类型，或左边的数据类型转为int，因为系统默认运算结果为int类型
        byte b001 = 10;
        byte b002 = 11;
        byte b003 = (byte) (b1 + b2); 
        // （5）在前面强转为byte类型，因为byte变量加上int常量得出结果为int类型
        byte b11 = 10;
        byte b22 = (byte) (b11 + 3);
        // （6）把num01通过Integer包装类的toString方法转为String类型
        int num01 = 2;
        int num02 = 3;
        // String ret = num01 > num02 ? num02+"" : num01 ;
        String ret = num01 > num02 ? num02 + "" : Integer.toString(num01);
        // （7）合法，因为任何类型数据与String类型合并都是String类型
        int a1 = 2;
        int b = 3;
        System.out.println(a1 > b ? b + "" : a1);
        // （8）强转的格式非法
        String ret1 = Integer.toString(20) + "AAA";

    }

}
/**
 * 小结：特别留意String类型和基本数据类型相互转换的格式
 */
