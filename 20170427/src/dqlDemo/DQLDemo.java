// 需求：利用JDBC操作mysql，操作DQL（查询）

package src.dqlDemo;

import static org.junit.Assert.*;

import java.awt.RadialGradientPaint;
import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class DQLDemo {
    @Test
    public void testName() throws Exception {
        //(1)加载注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //(2)新建连接对象及其三个参数，sql语句对象，sql语句
        Connection link = null;
        String url = "jdbc:mysql:///dbdemo";
        String user = "root";
        String password = "73619nine40";
        Statement state = null;
//        需求1: 查询 t_student 表中所有人个数  COUNT()
//        需求2: 查询id 为2 的学生信息
//        需求3: 查询t_student所有学生信息
        String sql01 = "SELECT COUNT(id) FROM  t_member";
        String sql02 = "SELECT id,name,age FROM  t_member WHERE id=2";
        String sql03 = "SELECT * FROM  t_member";
        ResultSet rs = null;
        //(3)try-catch-finally，获取以上两个对象内容
        try {
            link = DriverManager.getConnection(url,user,password);
            state = link.createStatement();
            //(4)执行sql语句
            rs = state.executeQuery(sql03);
            // 打印返回的结果集，while循环，用next()做判断条件
            // 注意，由于executeQuery(sql)返回的是数据库结果集的数据表，ResultSet类的对象
            while (rs.next()) {
                // get类型("string类型")，返回此ResultSet对象当前行的指定列的值
                System.out.println(rs.getInt("id"));
                System.out.println(rs.getString("name"));
                System.out.println(rs.getInt("age"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //(5)关闭资源
            rs.close();
            state.close();
            link.close();
        }
        //(1)
    }
}
/**
 * 小结：表示数据库结果集的数据表，通常通过执行查询数据库的语句生成。 
ResultSet 对象具有指向其当前数据行的光标。最初，光标被置于第一行之前。
next 方法将光标移动到下一行；因为该方法在 ResultSet 对象没有下一行时返回 false，
所以可以在 while 循环中使用它来迭代结果集。
get类型("string类型")，返回此ResultSet对象当前行的指定列的值
 */
