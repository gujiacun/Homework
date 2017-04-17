//需求：清明节复习题目
//（1）掌握instanceof用法
package allSoulsDay;

class Father {
    public static final int a = 10;
    static int score = 10;

    public static void method() {
        switch (score) {
        case a:
            System.out.println(a);
            break;
        default:
            System.out.println("请重新输入");
        }
    }
}

class Son extends Father implements Grandfather {

}

interface Grandfather {

}

public class AllSoulsDay {

    public static void main(String[] args) {
        Son sonOfBitch = new Son();
        boolean whether = sonOfBitch instanceof Father;
        boolean whether02 = sonOfBitch instanceof Son;
        boolean whether03 = sonOfBitch instanceof Grandfather;

        System.out.println(whether);
        System.out.println(whether);
        System.out.println(whether03);
        Father f = new Father();
        f.method();

        SwitchTest weekday = SwitchTest.Monday;
        switch (weekday) {
        case Monday:
            System.out.println("周末结束咯，周一上班咯");
            break;
        case Tuesday:
            System.out.println("周二继续上班咯");
            break;

        default:
            System.out.println("惜时");
            break;
        }
        String name = SwitchTest.Tuesday.name();
        int index = SwitchTest.Tuesday.ordinal();
        System.out.println(name);
        System.out.println(index);
        SwitchTest[] array = SwitchTest.values();
        int i = 1;
        while (i <= 10) {
            System.out.println(i);
            i++;
        }
        for (double j = 25.3; j < 36.4; j += 0.5) {
            System.out.println("我要做大牛，我要肉身翻墙！" + j);
        }
        int a = 1;
        while (a <= 5) {
            if (a == 4) {
                break;
            }
            System.out.println(a);
            a++;
        }

   
        // 第2题

        for (int k00 = 1; k00 <= 100; k00++) {
            if (k00 % 3 == 0 || k00 % 5 == 0) {
                System.out.println(k00);
            }
        }
        System.out.println("-----------------------");
        int k01 = 1;
        while (k01 <= 100) {
            if (k01 % 3 == 0 || k01 % 5 == 0) {
                System.out.println(k01);
            }
            k01++;
        }
        System.out.println("-----------------------");
        int k02 = 1;
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
            if (k03 % 5 == 0 && k03 % 2 == 0) {
                System.out.println(k03);
                counter++;
            }
            if (counter == 10) {
                break;
            }
            k03++;
        }
    }

}

enum SwitchTest {
    Monday, Tuesday, Wednesday
}
/**
 * 小结：在枚举中的所有常量都是对象，生成数组格式为枚举类名[] 数组名 = 枚举类名.values();
 */