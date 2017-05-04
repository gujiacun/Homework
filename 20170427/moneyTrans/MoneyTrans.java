// 需求：爸爸给儿子转账3,000元，用数据库，jdbc，preparedStatement模拟
//（1）在数据库建表，存储两人的银行余钱，名字
//（2）用jdbc操作数据库，先检测爸爸账户还剩多少钱，少于3,000报错，大于则执行下面的语句
//（3）从表中，爸爸数据的字段余钱的值减3，000，儿子加3，000
//（4）关闭资源
//(5)在第三步的两部分操作中模拟断电
package moneyTrans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import src.com._520it.pss.util.JdbcUtil;

public class MoneyTrans {
    @Test
    public void testBank() throws Exception {
        // TODO Auto-generated method stub
        // (1)在数据库建表，存储两人的银行余钱，名字
        // （2）检测爸爸账户余额
        String sql = "SELECT money FROM t_bank WHERE name= ? AND money >= ?";
        Connection link = JdbcUtil.getLink();
        PreparedStatement state = link.prepareStatement(sql);
        state.setString(1, "father");
        state.setInt(2, 3000);
        // 爸爸的账户钱在检索后返回的结果集
        ResultSet rs = state.executeQuery();
        // 如果结果集里面那没有内容，则抛出异常，不能执行下一步的转账操作
        if (!rs.next()) {
            throw new RuntimeException("余额不足，无法转账");
        }
        // 上一步检测通过，把爸爸的钱减去3000，数据库的修改操作
        sql = "UPDATE t_table SET money = money - ? WHERE name = ?";
        state = link.prepareStatement(sql);
        state.setInt(1, 3000);
        state.setString(2, "father");
        state.executeUpdate();
        // (3)同时，儿子的钱多了3000，也是数据库的修改操作
        sql = "UPDATE t_table SET money =  money + ? WHERE name = ?";
        state = link.prepareStatement(sql);
        state.setInt(1, 3000);
        state.setString(2, "son");
        state.executeUpdate();
        JdbcUtil.close(rs, state, link);
    }
/**
 * 小结：这里用了同一个PreparedStatement和Connection对象，最后可以只用一个关闭方法关闭所有
 * 以后要注意这种方法，而不是经常创建新对象，浪费系统资源
 */
}
