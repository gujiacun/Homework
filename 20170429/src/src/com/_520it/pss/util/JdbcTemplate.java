// 需求：一。对DML进行方法的抽取（MemberDAOImpl的save方法和update方法和delete方法）
//（1）把共同代码抽取出来
//（2）sql语句各个方法不同，由调用者传入。剩下设置参数一部分，由于参数是由sql语句决定
//也由调用者传入。由于参数个数/类型不定，用Object[]的可变参数
//二。对DQL方法（查询单个/全部）进行抽取(2b青年版本)
//以上的版本在jdbc模板里固定了要进行数据操作的实体类，无法操作另一个实体类，为增加通用性，
//把操作结果集的部分(while循环)定义为接口
package src.com._520it.pss.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import src.com._520it.pss.member.handler.IResultSetHandler;

public class JdbcTemplate {
    // 对DML的抽取,save方法和update方法同属于DML方法，都要拿连接对象，拿语句对象，执行sql语句，关闭资源，把他们抽象到这里
    // 由于参数类型不定，用Object，个数不定，用数组的可变参数
    public static void saveAndUpdate(String sql, Object... array) {
        // 拿连接对象
        Connection link = null;
        // 拿语句对象
        PreparedStatement state = null;
        try {
            // 拿连接对象
            link = JdbcUtil.getLink();
            // 拿sql的预编译语句对象
            state = link.prepareStatement(sql);
            // (3.1)语句对象赋值，添加参数,
            //由于参数的类型/数量不定，由调用者传入,用循环把所有的参数由语句对象添加
            for (int i = 0; i < array.length; i++) {
             // 表中的列数由1开始
                state.setObject(i + 1, array[i]);
            }
            // (4)执行sql语句,此时不要传入sql语句
            state.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // (5)关闭资源
            JdbcUtil.close(null, state, link);
        }
    }

    // 对DQL的抽取,单/多个查询都要把结果放到List集合里
    // 建sql语句，由于单个查询和全部查询的语句不同，无法整合，所以sql语句有调用者传入
    public static <T> T query(String sql, IResultSetHandler<T> handler, Object... array) throws Exception {
        Connection link = null;
        PreparedStatement state = null;
        ResultSet rs = null;
        try {
            // 拿连接对象
            link = JdbcUtil.getLink();
            // 拿语句对象
            state = link.prepareStatement(sql);
            // 循环设置参数，参数由sql语句决定，无法确定类型/数量，由调用者传入
            for (int j = 0; j < array.length; j++) {
                // 表中的列数由1开始
                state.setObject(j + 1, array[j]);
            }
            // 执行语句，返回ResultSet对象
            rs = state.executeQuery();
            // 循环把结果添加至list集合,已经在实现类中创建处理结果集的内部类，调用
            return handler.handle(rs);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            JdbcUtil.close(rs, state, link);
        }
        return null;
    }

}
/**
 * 小结：DML插入/更新/删除数据。DDL创建/删除表。DQL查询数据。老是忘记，加强记忆。
 * Object... array是方法的数组可变参数，Object代表传入参数的数据类型， array是数组的名字
 */
