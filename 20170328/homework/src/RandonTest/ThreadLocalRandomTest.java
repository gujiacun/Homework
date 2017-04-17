//需求：操作ThreadLocalRandom生成伪随机数
package RandonTest;
//建类
public class ThreadLocalRandomTest {
    // 主方法
    public static void main(String[] args) {
        ThreadLocalRandomTest a = new ThreadLocalRandomTest();
        //以下方法已经过时，运用ThreadLocalRandomTest时请直接创建对象
        //ThreadLocalRandomTest b = ThreadLocalRandomTest.current();
        System.out.println(a.toString());
    }

}
/**
 * 小结：版本更新换代，一些方法会被抛弃，改变，一定要会英语，阅读官方文档
 */
