// 需求：在上一个MoneyTrans作业中，为解决转账时扣钱和价钱之间可能发生的错误，把这两个操作当成一个事务
//当两个动作有失败，整个事务失败，表回滚到原来的状态，成功则去到新状态
package transactionDemo;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Test;

import src.com._520it.pss.util.JdbcUtil;

public class TransactionDemo {
    // 建测试方法
    @Test
    public void testName() throws Exception {
        // 拿连接和事务对象
        String sql = "UPDATE t_table SET money = money - ? WHERE name = ?";
        Connection link = JdbcUtil.getLink();
        PreparedStatement state = link.prepareStatement(sql);
        // 先设置为手动提交事务
        link.setAutoCommit(false);
        try {
            // 设置值
            state.setInt(1, 3000);
            state.setString(2, "father");
            // 执行sql语句
            state.executeUpdate();
            // 发生故障
            System.out.println(1 / 0);
            // 儿子的钱增加，用修改数据的方式修改表中某个数据的值
            // sql语句发生变化
            sql = "UPDATE t_table SET money = money + ? WHERE name = ?";
            // 重新拿语句对象
            state = link.prepareStatement(sql);
            // 设置值
            state.setInt(1, 3000);
            state.setString(2, "son");
            // 执行sql语句
            state.executeUpdate();
            // 若没有故障，提交事务
            link.commit();
        } catch (Exception e) {
            // 若上面代码发生故障，不仅打印跟踪栈信息，还把事务回滚到原来状态
            link.rollback();
            e.printStackTrace();
        } finally {
            // 最后确保关闭资源
            state.close();
            link.close();
        }
    }
    /**
     * 小结：这里运用try catch
     * finally，确保资源最后关闭，记住手动设置提交事务权限/提交事务/滚回原状态都是Connection对象来操作完成
     */
}
