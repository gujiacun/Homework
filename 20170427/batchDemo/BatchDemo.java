// 需求：批处理操作，进行性能测试，对比两种不同引擎/Statement和PreparedStatement/有没有批处理/是否加参数的区别，往表中添加3，000条数据
// 步骤：（1）建测试方法，有批处理的Statement/PreparedStatement
//（2）性能测试，System.currentTimeMills(),一前一后相减，添加数据5000次;
//（3）方法一，建sql语句，拿连接对象，拿语句对象，执行sql语句；2353
//（4）方法二，建sql语句，拿连接对象，拿语句对象，执行sql语句；491
package batchDemo;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import org.junit.Test;

import src.com._520it.pss.util.JdbcUtil;

public class BatchDemo {
    @Test
    public void testName() throws Exception {
        // 建sql语句
        String sql = "INSERT INTO t_student(name,age) VALUES('乔峰',30) ";
        long begin = System.currentTimeMillis();
        // 拿连接对象，
        Connection link = JdbcUtil.getLink();
        // 拿语句对象，
        Statement state = link.createStatement();
        // 重复执行用循环，先把要执行的语句放到缓存批处理空间
        for (int i = 0; i < 5000; i++) {
            state.addBatch(sql);
            // 当缓存到一定数量就进行提交
            if (i % 200 == 0) {
                // 执行存储在缓存批处理空间中的sql语句
                state.executeBatch();
                // 清空存储在缓存批处理空间中的sql语句
                state.clearBatch();
            }
        }
        // 由于可能还有残留sql语句，最后在处理一遍
        state.executeBatch();
        // 关闭资源
        JdbcUtil.close(null, state, link);
        System.out.println(System.currentTimeMillis() - begin);
    }

    @Test
    public void testName02() throws Exception {
        // 建sql语句
        String sql = "INSERT INTO t_student(name,age) VALUES(?,?) ";
        long begin = System.currentTimeMillis();
        // 拿连接对象，
        Connection link = JdbcUtil.getLink();
        // 拿语句对象，
        PreparedStatement state = link.prepareStatement(sql);
        // 重复执行用循环，先把要执行的语句放到缓存批处理空间
        for (int i = 0; i < 5000; i++) {
            // 先设置值
            state.setString(1, "乔峰");
            state.setInt(2, 30);
            state.addBatch();
            // 当缓存到一定数量就进行提交
            if (i % 200 == 0) {
                // 执行存储在缓存批处理空间中的sql语句
                state.executeBatch();
                // 清空存储在缓存批处理空间中的sql语句
                state.clearParameters();
            }
        }
        // 由于可能还有残留sql语句，最后在处理一遍
        state.executeBatch();
        // 关闭资源
        JdbcUtil.close(null, state, link);
        System.out.println(System.currentTimeMillis() - begin);
    }
/**
 * 小结：Statement/PreparedStatement在加了参数后性能差距较大，可作为mysql不支持预编译和批处理的弥补
 * 注意记忆Statement/PreparedStatement在进行批处理操作时的格式及方法差异
 */
}
