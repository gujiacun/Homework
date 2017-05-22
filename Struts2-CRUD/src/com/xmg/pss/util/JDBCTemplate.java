package com.xmg.pss.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.xmg.pss.handler.IResultSetHandler;

public class JDBCTemplate {

	private JDBCTemplate() {
	}

	//执行DML操作
	public static void update(String sql, Object... params) throws Exception {
		//获取连接对象
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		//设置参数
		for (int i = 0; i < params.length; i++) {
			ps.setObject(i + 1, params[i]);
		}
		//执行SQL
		ps.executeUpdate();
		//释放资源
		JDBCUtil.close(conn, ps, null);
	}

	//执行DQL
	public static <T> T query(String sql, IResultSetHandler<T> rsh,
			Object... params) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//获取连接对象
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(sql);
			//设置参数
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
			//执行SQL
			rs = ps.executeQuery();

			//处理结果集对象
			return rsh.handler(rs);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//释放资源
			JDBCUtil.close(conn, ps, rs);
		}
		return null;

	}
}
