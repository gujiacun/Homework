package com._520it.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com._520it.dao.IUserDAO;
import com._520it.dao.impl.UserDAOImpl;
import com._520it.domain.User;

public class UserDAOTest {
    IUserDAO userDAO = new UserDAOImpl();

    @Test
    public void testCheckLogin() throws Exception {
        User user = userDAO.checkLogin("张宝华", "111");
        if (user == null) {
            System.out.println("登录失败");
        } else {
            System.out.println("登录成功");
        }
    }
}
