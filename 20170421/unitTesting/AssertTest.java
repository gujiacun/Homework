// 需求：使用断言及其方法，类为Assert
// 步骤：（1）建接口IMath,建乘除的抽象方法，在方法上生成文档注释来解释方法中的参数
//（2）建接口的实现类，重写接口的方法
//（3）建测试类，先选中接口，new-单元测试实例，改对应名字，next，选需要被测试的方法
//（4）用多态建对象，建测试方法，在测试方法里调用实现类的被测试的实例方法，在测试方法上加@Test
//（5）在方法下用Assert类比较期望值与真实值，期望该方法报错，测试方法是否超时
package unitTesting;

public class AssertTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
}
/**
 * 小结：断言成功，即期望值与真实值相等，在JUnit显示绿条
 * 断言失败，即期望值与真实值不等，在JUnit显示红条
 */
