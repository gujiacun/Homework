// 需求：建工具类，封装DAO中常用的数据及方法
package src.com._520it.pss.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.Properties;


import com.alibaba.druid.pool.DruidDataSourceFactory;

public class JdbcUtil {

    /**
     * @return 返回Connection对象
     * @throws Exception
     */
    public static Connection getLink() throws Exception {
        try {
            // 从配置文件中获取输入流
            InputStream in = Thread.currentThread().getContextClassLoader()
                    .getResourceAsStream("db.properties");
            // 新建Properties对象
            Properties properties = new Properties();
            // 用配置文件对象加载输入流
            properties.load(in);
            // 通过Druid连接池拿连接对象
            Connection connection =DruidDataSourceFactory.createDataSource(properties).getConnection();
            // 拿连接对象
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 关闭资源
    // (5)关闭资源
    public static void close(ResultSet rs, Statement state, Connection link) {
        // 假如这三个对象不为空，才执行关闭资源，所以用if判断
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (state != null) {
                state.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (link != null) {
                link.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
/**
 * 小结：记住每一次重构时，都要对程序进行测试，以确保每次对代码的调整都是无误的 ，
 * 既然已经把连接对象放在工具类里，静态字段就没必要暴露，因为他们现在只在工具类里被getLink方法调用
 */
