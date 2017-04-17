package funfunfun;

public class LoopDemo {

    public static void main(String[] args) {
        // 打印菱形
        for (int i = 1; i <= 19; i++) {
            for (int j = 0; j < Math.abs(10 - i); j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 19 - 2 * Math.abs(10 - i); j++) {
                System.out.print("X");
            }
            System.out.println();
        }
        System.out.println("-----------割割割-------------");
        // 打印等腰三角形
        for (int i = 1; i <= 10; i++) {
            for (int j = 0; j < 10 - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i - 1; j++) {
                System.out.print("X");
            }
            System.out.println();
        }
    }

}
