// 需求：在搜索一个表时获取一条数据的主键，分别用Statement/PreparedStatement来演示
package returnKey;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import src.com._520it.pss.util.JdbcUtil;

public class ReturnKey {
    @Test
    public void testName() throws Exception {
        // 建sql语句
        String sql = "INSERT INTO t_member(name,age) VALUES('Haruna',99)";
        // 拿连接对象，
        Connection link = JdbcUtil.getLink();
        // 拿语句对象，
        Statement state = link.createStatement();
        // 执行语句，此时设置为数据库要返回主键
        state.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = state.getGeneratedKeys();
        if (rs.next()) {
            System.out.println(rs.getLong(1));
        }
        JdbcUtil.close(null, state, link);
    }

    @Test
    public void testName02() throws Exception {
     // 建sql语句
        String sql = "INSERT INTO t_member(name,age) VALUES(?,?)";
        // 拿连接对象，
        Connection link = JdbcUtil.getLink();
        // 拿语句对象，
        PreparedStatement state = link.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        state.setString(1, "Sashi");
        state.setInt(2, 24);
        // 执行语句，此时设置为数据库要返回主键
        state.executeUpdate();
        ResultSet rs = state.getGeneratedKeys();
        if (rs.next()) {
            System.out.println(rs.getLong(1));
        }
        JdbcUtil.close(null, state, link);
    }
/**
 * 小结：只有在executeUpdate方法中才能设置数据库是否返回主键，其他不能
 */
}
