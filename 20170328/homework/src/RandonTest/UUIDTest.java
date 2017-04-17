//需求：操作UUID
package RandonTest;

import java.util.UUID;

//建类
public class UUIDTest {
    // 主方法
    public static void main(String[] args) {
        //格式为 UUID 变量名 = UUID.randomUUID();
        UUID number = UUID.randomUUID();
        System.out.println(number);
    }

}
/**
 * 小结：UUID在日后会有大用途，记住其使用格式
 */