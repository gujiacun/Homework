// 需求：运用JUnit4进行单元测试，运用里面的标签
package unitTesting;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class JUnit5ForTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }
    // 无论何时，都会而且仅会执行一次
    @BeforeClass
    public static void beforeClassWay(){
        System.out.println("闷声发大财");
    }
    // 在每个测试方法前运行，若有多个测试方法而进行所有测试方法的运行，被这标签修饰的会重复运行
    @Before
    public void beforeMethod(){
        System.out.println("看看我在不在测试方法前执行？");
    }
    // 定义测试方法，加上@Test标签，直接按ctrl+F11再选择以JUnit测试，或在旁边的Outlne中选择要测试的方法，Run as
    @Test
    public void testSave() throws Exception{
        System.out.println("水可载舟，亦可赛艇");
    }
    // 显示绿条表示成功，红条显示失败
    @Test
    public void testDelete() throws Exception{
        System.out.println("时间众筹学");
    }
    // 在每个测试方法后运行，若有多个测试方法而进行所有测试方法的运行，被这标签修饰的会重复运行
    @After
    public void afterMethod(){
        System.out.println("看看我在不在测试方法后执行？");
    }
    // 无论何时，都会而且仅会执行一次
    @AfterClass
    public static void afterClassWay(){
        System.out.println("stay young,stay simple,sometimes naive");
    }
/**
 * 小结：@BeforeClass类似于静态代码块，最先执行
 * 而@AfterClass类似finally，最后一定会执行
 */
}
