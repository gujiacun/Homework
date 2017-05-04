package util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class JdbcUtil {
    // 拿连接对象
    public static Connection getConn() {
        // 从配置文件获取数据库四要素，先建properties对象
        Properties properties = new Properties();
        // 从配置文件获取输入流
        // "D:\\classtest\\20170328\\20170501\\sources\\db.properties"
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");
        try {
            // 加载
            properties.load(in);
            // 通过配置文件的对象建连接池对象
            DataSource ds = DruidDataSourceFactory.createDataSource(properties);
            // 通过连接池对象拿连接对象
            Connection link = ds.getConnection();
            return link;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 关闭资源
    public static void close(Connection link, PreparedStatement state, ResultSet rs) {
        try {
            if (link != null) {
                link.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (state != null) {
                state.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
