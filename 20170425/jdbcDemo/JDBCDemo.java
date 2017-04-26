// 需求：获取JDBC的连接对象
package jdbcDemo;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class JDBCDemo {
    // 导进junit包，lysql包，建测试方法
    @Test
    public void testName() throws Exception {
        // 加载注册驱动
        // forName(String className) 返回与带有给定字符串名的类或接口相关联的 Class 对象
        Class.forName("com.mysql.jdbc.Driver");
        // 创建url，user，password都是string类型
        String url = "jdbc:mysql//localhost:3306/";
        String user = "root";
        String password = "73619nine40";
        // 获取连接对象
        Connection link = DriverManager.getConnection(url,user,password);
        //Thread.currentThread().sleep(5000);
        
    }
}
/**
 * 小结：创建JDBC的连接对象，先加载驱动，再用DriverManager类调用getConnection静态方法，获取连接对象
 */

