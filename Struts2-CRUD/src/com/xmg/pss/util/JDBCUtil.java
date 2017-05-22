package com.xmg.pss.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class JDBCUtil {

	private JDBCUtil() {
	}

	private static Properties p = new Properties();
	static {
		InputStream in = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("db.properties");
		try {
			p.load(in);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	//获取连接对象
	public static Connection getConnection() throws Exception {
		return DruidDataSourceFactory.createDataSource(p).getConnection();
	}

	//释放资源
	public static void close(Connection conn, Statement st, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null) {
					st.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
