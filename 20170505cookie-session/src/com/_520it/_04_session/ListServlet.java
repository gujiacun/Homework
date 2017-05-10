//需求：拿到传进来的cookie里的值，再输出页面
package com._520it._04_session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value = "/session/list")
public class ListServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // 重写service方法
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求的编码格式，
        req.setCharacterEncoding("UTF-8");
        // 响应的内容类型和编码格式
        resp.setContentType("text/html;charset=UTF-8");
        // 首先要从请求对象获取session
        HttpSession session= req.getSession();
        // 从session中提取数据
        Object attribute = session.getAttribute("USERNAME_IN_SESSION");
        String name = (String)attribute;
        // 在响应中输出新页面，先通过响应对象拿打印流，再调用write方法
        PrintWriter writer = resp.getWriter();
        // 用户名
        writer.write("名字：" + name);
        // 登陆邮箱及邮件总数,这里显示所有邮件，所以用循环
        for (int i = 1; i < 6; i++) {
            writer.write("<br><a href='/session/get' >" + "邮件" + i + "</a>");
        }
    }
}
/**
 * 小结：@WebServlet(value="/路径")里面填的路径是本servlet的路径，而不能是别的
 * //响应的内容类型和编码格式
        resp.setContentType("text/html;charset=UTF-8");
     上面格式要记牢
 */