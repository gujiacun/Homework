package com._520it.dao.impl;

import com._520it.dao.IUserDAO;
import com._520it.domain.User;
import com._520it.handler.BeanHandler;
import com._520it.utils.JdbcTempate;

public class UserDAOImpl implements IUserDAO{
    @Override
    public User checkLogin(String username,String password) {
        // TODO Auto-generated method stub
        String sql = "SELECT * FROM t_user WHERE username = ? and password = ?";
        
        return JdbcTempate.query(sql, new BeanHandler<>(User.class), username,password);
    }
/**
 * 小结：在DAO中建方法，返回User对象（内含用户名和密码）
 */
}
