package com._520it.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 在list.jsp(登陆成功后的主页面)里，建超链接安全退出，跳转至LogoutServlet
        // 既然是退出，把session中存储的用户对象清除
        req.getSession().invalidate();
        // 重定向至登陆页面
        resp.sendRedirect("/login.jsp");
    }
}
