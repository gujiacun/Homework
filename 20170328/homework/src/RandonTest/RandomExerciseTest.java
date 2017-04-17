//需求：生成一个五位的随机验证码
//步骤：（1）随机验证码应该包含大小写字母及数字
//（2）由于UUID不生成大写英文字母，用java.util.Random
//由于强制要求5位数，每次生成1位数，循环5次
package RandonTest;

import java.util.Random;

public class RandomExerciseTest {

    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm0123456789");
        for (int i = 0; i < 5; i++) {
            // Random是一个类，要生成随机数，要用它的实例方法next基本数据类型()，括号里填数字x，表示生成范围是[0,x),下面用了匿名对象
            System.out.print(str.charAt(new Random().nextInt(str.length())));
        }
    }

}
/**
 * 小结：要自如运用匿名对象传递数值，注意几种方法嵌套在一起时的逻辑关系
*/
