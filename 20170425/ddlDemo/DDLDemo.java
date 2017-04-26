// 需求：利用JDBC操作MySQL，进行DDL操作
// 步骤：（1）加载注册驱动
//（2）获取连接对象
//（3）获取语句对象
//（4）创建sql语句
//（5）执行sql语句
//（6）关闭资源
package ddlDemo;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.junit.Test;

//import com.mysql.jdbc.Statement;


public class DDLDemo {
    @Test
    public void testName() throws Exception {
     // 加载注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 新建sql语句，封装为string类型
        String url = "jdbc:mysql://localhost:3306/dbdemo";
        String user = "root";
        String password = "73619nine40";
        //获取连接对象
        Connection link = DriverManager.getConnection(url, user, password);
        //获取语句对象
        Statement state = link.createStatement();
        // 建表
        String sql = "CREATE TABLE t_member (id INT(10),name VARCHAR(10),age INT(10))";
        String sql02 = "DROP TABLE t_48And46Members";
        // 返回的是在表中影响的行数
        int result = state.executeUpdate(sql02);
        // 
        state.close();
        link.close();
        System.out.println(result);
    }
}
/**
 * 小结：记住在mysql中创建表的格式
 * Statement类用于执行静态SQL语句并返回它所生成的结果对象
 */
