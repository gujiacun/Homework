// 需求：建工具类，封装DAO中常用的数据及方法
package src.com._520it.pss.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
 
    static {
        // 注册驱动
        try {
            // 读取配置文件里的数据,先创建数据输入流，通过线程获得加载器对象，调用getResourceAsStream把配置文件化作输入流
            InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");
            // 创建配置文件对象
            Properties properties = new Properties();
            // 用配置文件对象加载输入流
            properties.load(in);
            // 读取配置文件对象里的数据（键值对形式）
            String mysqlDriver = properties.getProperty("mysqlDriver");
            Class.forName(mysqlDriver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getLink() throws Exception {
        // 加载注册驱动
        // 读取配置文件数据，创建文件输入流
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");
        // 用Properties对象加载输入流
        Properties properties = new Properties();
        properties.load(in);
        // 通过键值对读取Properties对象里的某些特定数据
        String url = properties.getProperty("url");
        String userName = properties.getProperty("userName");
        String password = properties.getProperty("password");
        // 拿连接对象
        Connection link = DriverManager.getConnection(url, userName, password);
        return link;

    }

    // 关闭资源
    // (5)关闭资源
    public static void close(ResultSet rs, Statement state, Connection link) {
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
