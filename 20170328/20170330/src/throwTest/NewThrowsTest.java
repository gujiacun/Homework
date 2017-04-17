//需求：操作java7新特性，在方法中抛出异常给其调用者更精准
//(1)新建方法，写可能会出异常的代码，方法内部不对异常进行处理，抛出给方法的调用者
//（2）在主方法中调用方法，捕获处理
package throwTest;

//测试类
public class NewThrowsTest {
    // 主方法
    public static void main(String[] args) {
        // 调用方法
        try {
            // 除数传入不同的值，如0，1
            int result = NewThrowsTest.method(30, 1);
            System.out.println(result);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
    }

    public static int method(int a, int b) throws ArithmeticException {
        try {
            return a / b;
            // 这里是算术异常，方法首行抛出的异常现在可以与这里的保持一致
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        return a / b;
    }

}
/**
 * 小结：现在还没感觉到新特性的功能，我猜在性能上应该上升，因为方法抛出的异常更精准，不必在父类中寻找
 */
