package com.xmg.pss.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSourceFactory;
//import com.sun.xml.internal.fastinfoset.sax.Properties;

public class JDBCUtil {
    static Properties properties = new Properties();
    static {
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 返回链接对象
    public static Connection getConnection() throws SQLException, Exception {
        return DruidDataSourceFactory.createDataSource(properties).getConnection();
    }

    // 关闭资源
    public static void close(Connection link, Statement state, ResultSet rs) {
        try {
            if (link != null) {
                link.close();
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            try {
                if (state != null) {
                    state.close();
                }
            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
            } finally {
                try {
                    if (rs != null) {
                        rs.close();
                    }
                } catch (Exception e3) {
                    // TODO: handle exception
                    e3.printStackTrace();
                }
            }
        }
    }
}
