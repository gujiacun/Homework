package com._520it.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

//jdbc操作工具类
public class JdbcUtil {
	private static DataSource ds;
	static{
		//2: 琏
		try {
			InputStream inputStream = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("db.properties");;
			Properties properties = new Properties();
			properties.load(inputStream);
			//通过 DruidDataSourceFactory 工程 加载 连接数据库的4要素, 然后创建DataSource
			ds = DruidDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//返回Connection对象
	public static Connection getConn(){
		//1: 贾
		try {
			//通过数据源获取连接对象
			return ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	//数据库资源的关闭
	public static void close(Connection connection, Statement statement,ResultSet resultSet){
		//5:事
		try {
			if(resultSet != null){
				resultSet.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if(statement != null){
				statement.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if(connection != null){
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


