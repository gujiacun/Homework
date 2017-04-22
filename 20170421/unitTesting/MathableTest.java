package unitTesting;

import org.junit.Test;

import org.junit.Assert;

public class MathableTest {
    Imathable number = new MathTest();

    @Test(expected = AssertionError.class)
    public void testMultiply() {
        int ret = number.multiply(3, 5);
        Assert.assertEquals("年轻人，提高自己姿势水平", 14, ret);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivide() {
        int ret = number.divide(3, 5);
        Assert.assertEquals("年轻人，提高自己姿势水平", 0, ret);
    }

    @Test(timeout = 300)
    public void testDivide02() throws Exception {
        //Thread.currentThread().sleep(500);
        int ret = number.divide(3, 5);
        Assert.assertEquals("年轻人，提高自己姿势水平", 0, ret);
    }
}
