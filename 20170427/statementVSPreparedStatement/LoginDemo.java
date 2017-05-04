// 需求：模拟进行登录测试，用SQL注入来比较Statement和PreparedStatement的优坏
//步骤：（1）在数据库建表，填id，name，password三列
//（2）既然是登陆，就要输入名字和密码，用查询操作来模拟，若登陆成功，返回ResultSet对象
// 即若对象不为空，输出登陆成功，否则失败
package statementVSPreparedStatement;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import src.com._520it.pss.util.JdbcUtil;


public class LoginDemo {
    @Test
    public void testName() throws Exception {

        // 在数据库建表t_login
        // 查询操做，名字和密码
        // String user = "Hirate1";
        String user = "' OR 1 = 1 OR '";
        String password = "000000";
        // 查询操做，先建sql语句
        String sql = "SELECT COUNT(id) AS count FROM t_login WHERE name= '" + user + "' AND password= '" + password
                + "' ";
        // 再拿连接对象
        Connection link = null;
        // 拿语句对象
        Statement state = null;
        try {
            link = JdbcUtil.getLink();
            state = link.createStatement();
            // 执行sql语句
            ResultSet rs = state.executeQuery(sql);
            long count = 0;
            if (rs.next()) {
                count = rs.getLong("count");
            }
            if (count == 1) {
                System.out.println("登陆成功");
            } else {
                System.out.println("登录失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            state.close();
            link.close();
        }
        // 关闭资源
    }
    
    @Test
    public void testName02() throws Exception {
        // 利用PreparedStatement回避SQL注入
        //登陆密码，登陆名字
//        String name = "' OR 1 = 1 OR '";
//        String password = "000000";
        String name = "Hirate";
        String password = "center";
        //建sql语句，里面的值用占位符
        String sql = "SELECT COUNT(id) AS count FROM t_table WHERE nam e= ? AND password = ?";
        // 拿连接对象
        Connection link = JdbcUtil.getLink();
        // 拿语句对象
        PreparedStatement state = link.prepareStatement(sql);
        // 设置值
        state.setString(1, name);
        state.setString(2, password);
        // 执行sql语句
        ResultSet rs = state.executeQuery();
        long count = 0;
        if (rs.next()) {
            count = rs.getLong("count");
        }
        if (count == 1) {
            System.out.println("登陆成功");
        } else {
            System.out.println("登录失败");
        
        }
        // 关闭资源
        state.close();
        link.close();
    }
/**
 * 占位符PreparedStatement的占位符有效解决SQL注入问题,注意总结Statement和PreparedStatement的格式差别
 */
}
