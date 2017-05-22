package com.xmg.pss.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.sun.org.apache.regexp.internal.recompile;
import com.xmg.pss.domain.Employee;
import com.xmg.pss.handler.BeanListHandler;
import com.xmg.pss.handler.IResultSetHandler;

import javafx.css.PseudoClass;

public class JDBCTemplate {
    public static void update(String sql, Object... params) throws SQLException, Exception {
        Connection link = JDBCUtil.getConnection();
        PreparedStatement state = link.prepareStatement(sql);
        for (int i = 0;i<params.length;i++) {
            state.setObject(i+1, params[i]);
        }
        state.executeUpdate();
        JDBCUtil.close(link, state, null);
    }
    public static <T>T query(String sql,IResultSetHandler<T> handler,Object... params){
        Connection link=null;
        PreparedStatement state=null;
        ResultSet rs=null;
        try {
            link = JDBCUtil.getConnection();
            state = link.prepareStatement(sql);
            for (int i = 0;i<params.length;i++) {
                state.setObject(i+1, params[i]);
            }
            rs = state.executeQuery();
            return handler.handle(rs);
        }  catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            JDBCUtil.close(link, state, rs);
        }
        return null;
        
    }

}
