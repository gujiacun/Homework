//需求：做第二和第三题，全面复习循环和运算符知识
package allSoulsDay;

public class LoopTest {

    public static void main(String[] args) {
        // 第2题
        // for循环
        for (int k00 = 1; k00 <= 100; k00++) {
            if (k00 % 3 == 0 || k00 % 5 == 0) {
                System.out.println(k00);
            }
        }
        System.out.println("-----------------------");

        // while循环
        int k01 = 1;
        while (k01 <= 100) {
            if (k01 % 3 == 0 || k01 % 5 == 0) {
                System.out.println(k01);
            }
            k01++;
        }
        System.out.println("-----------------------");
        int k02 = 1;

        // do-while循环
        do {
            if (k02 % 3 == 0 || k02 % 5 == 0) {
                System.out.println(k02);
            }
            k02++;
        } while (k02 <= 100);
        System.out.println("以下是第三题-----------------------");
        // 第3题
        int k03 = 1;
        int counter = 0;
        while (k03 <= 1000) {
            // 用短路与运算，提高运行效率，若运算符左边表达式为假，停止运算
            if (k03 % 5 == 0 && k03 % 2 == 0) {
                System.out.println(k03);
                counter++;
            }
            // 题目要求是前10个，用break终止循环
            if (counter == 10) {
                break;
            }
            // 此处是变量更新，如果没有将无法运行
            k03++;
        }
    }

}
/**
 * 小结：用while和do-while循环时，一定要记住自行在方法内添加循环变量更新语句。
 */
