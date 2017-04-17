//需求：操作java.lang.Math.random(),生成一个在[0.0,1.0)的数
package RandonTest;

//建类
public class MathRandonTesy {
    // 主方法
    public static void main(String[] args) {
        System.out.println(Math.random());
        // 用round方法把小数的小数点后一位四舍五入,返回结果为long类型
        long num = Math.round(3.568);
        System.out.println(num);
        // 此方法存在重载，输入float，返回int
        int a = Math.round(3.468F);
        System.out.println(a);
        // 比较并输出两个数中的较大值
        System.out.println(Math.max(num, a));
    }

}
/**
 * 小结：Math类中存在很多方法，在平时要多加练习，这样才能在需要用到时节省时间。
 */
