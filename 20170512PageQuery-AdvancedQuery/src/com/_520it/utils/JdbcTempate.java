package com._520it.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com._520it.domain.Product;
import com._520it.handler.BeanListHandler;
import com._520it.handler.IResultSetHandler;

public class JdbcTempate {
public static void update(String sql,Object...params){
    Connection link = null;
    PreparedStatement state = null;
    try {
        link = JdbcUtils.getLink();
        state = link.prepareStatement(sql);
        for (int i=0; i<params.length;i++) {
            state.setObject(i+1, params[i]);
        }
        state.executeUpdate();
    } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
    }finally {
        JdbcUtils.close(link, state,null);
    }
}
//public static <T>T query(String sql,IResultSetHandler<T>(),Object...params){
//    
//}

public static <T>T query(String sql, IResultSetHandler<T> handler, Object...params) {
    Connection link = null;
    PreparedStatement state = null;
    try {
        link = JdbcUtils.getLink();
        state = link.prepareStatement(sql);
        for (int i=0; i<params.length;i++) {
            state.setObject(i+1, params[i]);
        }
        ResultSet rs = state.executeQuery();
        return handler.handle(rs);
    } catch (Exception e) {
        e.printStackTrace();
        // TODO: handle exception
    }finally {
        JdbcUtils.close(link, state,null);
    }
    return null;
    // TODO Auto-generated method stub
    
}}
