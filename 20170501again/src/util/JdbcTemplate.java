package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import handler.IResultSetHandler;

public class JdbcTemplate {

    public static void update(String sql, Object...array) {
        // 设置连接对象和语句对象
        // try-catch-finally,用工具类拿连接对象,用工具类关闭资源
        // 拿连接对象/语句对象，用for循环给语句对象赋值，执行语句
        Connection link = null;
        PreparedStatement state = null;
        try {
            link=JdbcUtil.getConn();
            state=link.prepareStatement(sql);
            for (int i = 0; i < array.length; i++) {
                state.setObject(i+1, array[i]);
            }
            state.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.close(link, state, null);
        }
    }
    public static <T>T query(String sql, IResultSetHandler<T> handler, Object...array) {
     // 设置连接对象和语句对象
        // try-catch-finally,用工具类拿连接对象,用工具类关闭资源
        // 拿连接对象/语句对象，用for循环给语句对象赋值，执行语句
        Connection link = null;
        PreparedStatement state = null;
        try {
            link=JdbcUtil.getConn();
            state=link.prepareStatement(sql);
            for (int i = 0; i < array.length; i++) {
                state.setObject(i+1, array[i]);
            }
            ResultSet rs = state.executeQuery();
            return handler.handle(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.close(link, state, null);
        }
    return null;
    }
}
