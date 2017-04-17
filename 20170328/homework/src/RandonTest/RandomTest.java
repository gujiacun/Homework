//需求：操作java.util.Random类，运用里面的实例方法next基本数据类型(数字)生成伪随机数
package RandonTest;

import java.util.Random;

//建类
public class RandomTest {
    // 主方法
    public static void main(String[] args) {
        //Random是类，next基本数据类型[数字)，括号内可填入种子，但填入后每次生成的数字会相等
        Random number = new Random();
        //只有nextInt有一个重载的方法，表示随机数在从零到该数的范围内生成，其余的只能随机生成，范围是该值的取值范围
        System.out.println(number.nextDouble());
        System.out.println(number.nextInt(20));
        //提供一个“种子”生成随机数
        number.setSeed(13L);
        //由于设置了种子，在后面的语句生成的随机数便固定了下来
        System.out.println(number.nextLong());
    }

}
/** 
 *小结：这都是伪随机数，但在设置种子时要设置不同的，否则生成的随机数会相等
 */
