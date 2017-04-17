//需求：操作throws，掌握它的格式和应用场景
//新建一个类，在里面新建方法，用throws抛出异常给主方法的调用者（方法）
package throwTest;

// 测试类ThrowDemp
public class ThrowDemp {
    // 主方法
    public static void main(String[] args) {
        // 此句用于验证语句是否被执行
        System.out.println("哈哈，这里应该有被执行吧");
        // 调用静态方法Test02
        ThrowDemp.Test02();
        System.out.println("这里有被执行吗？");
    }

    // 新建静态方法
    public static void Test02() throws ArithmeticException {
        // 调用Test类里的say方法
        System.out.println("报告首长，这里是Test02");
        // Test类中的say方法把异常抛来此处，若这里没有try-catch或throws,程序执行到这里就会结束
        // 但被try-catch包围后，传递到这里的异常被捕获并处理，处理后不影响后面语句的执行
        // try {
        // Test.say();
        // } catch (ArithmeticException e) {
        // e.printStackTrace();
        // }
        // 但若这里继续用throws，异常会被抛给主方法，JVM，JVM会把异常的跟踪栈信息打印到console上
        Test.say();
        System.out.println("你猜会执行到这里吗？");
    }

}

// 新建类，Test
class Test {
    // 使用throws把异常抛给方法的调用者
    public static void say() throws ArithmeticException {
        int a = 9;
        int b = 0;
        // 若用throws，有异常时，程序会在这里处理异常，若不想在方法内处理异常，可以把异常抛出，扔给方法的调用者
        // try {
        // System.out.println(a / b);
        // } catch (ArithmeticException e) {
        // e.getStackTrace();
        // System.out.println("哥们又有异常啦，你真的有两年工作经验吗？还是说你是培训机构出来的？");
        // }
        System.out.println(a / b);

    }

    // 验证子类方法抛出的异常小于等于父类方法抛出的异常
    class Father {
        // 可直接改父类方法的抛出异常类，也可以直接增加一个异常类
        public void say() throws ArithmeticException, Exception {
            int num01 = 10;
            int num02 = 0;
            System.out.println(num01 / num02);
        }
    }

    class Son extends Father {
        public void say() throws Exception {

        }
    }
}
/**
 * 小结：运用于方法首行，它所在的方法不处理异常，把异常抛给方法的调用者，此时调用者可以选择捕获并处理，也可以继续抛出并传递
 */