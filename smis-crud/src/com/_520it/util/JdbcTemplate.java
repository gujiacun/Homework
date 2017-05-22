package com._520it.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com._520it.handler.IResultSetHandler;

//jdbc crud 操做模板类
public class JdbcTemplate {
	/**
	 * 用于DML(添 删 改) 操作
	 * 
	 * @param sql
	 *            带有占位符的sql模板
	 * @param params
	 *            参数, 有个占位符, 就有几个参数
	 * @return 受影响的行数
	 */
	public static int update(String sql, Object... params) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = JdbcUtil.getConn();
			statement = connection.prepareStatement(sql);
			// 设置参数
			for (int i = 0; i < params.length; i++) {
				statement.setObject(i + 1, params[i]);
			}
			return statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, statement, null);
		}
		return 0;
	}

	/**
	 * 用于DML(添 删 改) 操作
	 * 
	 * @param <T>
	 * @param sql
	 *            带有占位符的sql模板
	 * @param params
	 *            参数, 有个占位符, 就有几个参数
	 * @return 将结果集包装之后得到对象集合:
	 * 
	 * 
	 *         IResultSetHandler 表示 resultset结果集的处理类, 他的泛型, 表示:
	 *         表示这个结果集处理完之后返回的类型
	 * 
	 */
	public static <T> T query(String sql, IResultSetHandler<T> handler,
			Object... params) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		// 1: 贾
		try {
			connection = JdbcUtil.getConn();
			statement = connection.prepareStatement(sql);
			// 设置参数
			for (int i = 0; i < params.length; i++) {
				statement.setObject(i + 1, params[i]);
			}
			// 4: 执
			resultSet = statement.executeQuery();
			// /结果集的操作
			return handler.handle(resultSet);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection, statement, resultSet);
		}
		// 返回一个空list
		return null;
	}
}
