// 需求：给statement和PreparedStatement各加5000条数据，测试运行速度
package statementVSPreparedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import src.com._520it.pss.util.JdbcUtil;

public class StatementVSPreparedStatement {

    public static void main(String[] args) {
//        // 建sql语句
//        String sql = "INSERT INTO t_table(name,age) VALUES('乔峰',40)";
//        // 建连接对象
//        // 建语句对象
//        Connection link = null;
//        Statement state = null;
//        // 由于已经有工具类，可以直接拿链接对象
//        long begin = System.currentTimeMillis();
//        try {
//            // 拿连接对象
//            link = JdbcUtil.getLink();
//            // 拿语句对象
//            state = link.createStatement();
//            // 执行sql语句
//            for (int i = 0; i < 5000; i++) {
//                int ret = state.executeUpdate(sql);
//            }
//            // System.out.println("执行成功"+ret);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            // 关闭资源
//            JdbcUtil.close(null, state, link);
//        }
//        System.out.println(System.currentTimeMillis() - begin);

        System.out.println("=====================");
        // 建sql语句
        String sql02 = "INSERT INTO t_table(name,age) VALUES(?,?)";
        // 建连接对象，建PreparedStatement语句对象
        Connection link02 = null;
        PreparedStatement state02 = null;
        long begin02 = System.currentTimeMillis();
        try {
            // 拿连接和语句对象
            link02 = JdbcUtil.getLink();
            state02 = link02.prepareStatement(sql02);
            // 添加元素，循环执行添加的sql语句
            for (int i = 0; i < 5000; i++) {
                state02.setString(1, "段誉");
                state02.setInt(2, 23);
                state02.executeUpdate();

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            JdbcUtil.close(null, state02, link02);
        }
        System.out.println(System.currentTimeMillis() - begin02);
    }
/**
 * 小结：这两者在执行同一个操作时，时间相差无几，因为mysql不支持PreparedStatement，但其他数据库支持
 */
}
