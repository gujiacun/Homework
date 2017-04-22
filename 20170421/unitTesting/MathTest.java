package unitTesting;

public class MathTest implements Imathable{

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    // 由IDE自动重写接口中的抽象方法
    @Override
    public int multiply(int a, int b) {
         int ret = a * b;
         return ret;
    }

    @Override
    public int divide(int a, int b) {
        int ret = a / b;
        return ret;
    }

}
