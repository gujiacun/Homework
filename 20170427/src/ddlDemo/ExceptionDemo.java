// 需求：在数据库中创建新表的基础上，正确处理异常
package src.ddlDemo;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class ExceptionDemo {
    @Test
    public void testName() throws Exception {

        // （1）加载注册驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // （2）建连接对象
        // url格式：jdbc:mysql://装有数据库的服主机ip:端口/数据库名字
        String url = "jdbc:mysql://localhost:3306/dbdemo";
        String user = "root";
        String password = "73619nine40";
        Connection link = null;
        Statement state = null;
        try {
            link = DriverManager.getConnection(url, user, password);
            // （3）建sql语句对象
            state = link.createStatement();
            // （4）建sql语句
            String sql = "CREATE TABLE t_student (id INT(10),name VARCHAR(10),age INT(10))";
            // （5）执行sql语句
            boolean whether = state.execute(sql);
            System.out.println(whether);
         
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // （6）关闭资源
            try {
                if (state != null) {
                    state.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                if (link != null) {
                    link.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
/**
 * 小结：记住关闭资源的格式，很重要
 */
