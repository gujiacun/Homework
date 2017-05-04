// 需求：建工具类，封装DAO中常用的数据及方法
package src.com._520it.pss.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class JdbcUtil {
    static Connection connection = null;
    static Properties properties = new Properties();
//    static {
//        // 注册驱动
//        try {
//            // 读取配置文件里的数据,先创建数据输入流，通过线程获得加载器对象，调用getResourceAsStream把配置文件化作输入流
//            InputStream in = Thread.currentThread().getContextClassLoader()
//                    .getResourceAsStream("D:\\classtest\\20170328\\Bday-07-20170428\\resources2\\db.properties");
//            // 用配置文件对象加载输入流
//            properties.load(in);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public static Connection getLink() throws Exception {
        InputStream in = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("db.properties");
        //D:\\classtest\\20170328\\Bday-07-20170428\\resources2\\db.properties
        // 用配置文件对象加载输入流
        properties.load(in);
        return DruidDataSourceFactory.createDataSource(properties).getConnection();
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
