package com._520it.dao;

import com._520it.domain.User;

public interface IUserDAO {
/**
 * @param username 用户登录名
 * @param password 用户密码
 * @return 返回用户对象
 */
public User checkLogin(String username,String password);
}
