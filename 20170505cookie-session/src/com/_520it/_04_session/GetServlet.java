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

@WebServlet(value = "/session/get")
public class GetServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // 重写service方法
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求的编码格式，
        req.setCharacterEncoding("UTF-8");
        // 响应的内容类型和编码格式
        resp.setContentType("text/html;charset=UTF-8");
        // 通过请求对象创建session对象
        HttpSession session = req.getSession();
        // 获取里面的值
        Object attribute = session.getAttribute("USERNAME_IN_SESSION");
        String username = (String) attribute;
        // 在响应中输出新页面，先通过响应对象拿打印流，再调用write方法
        PrintWriter writer = resp.getWriter();
        // writer.write("<form action='/param/login' method='post'
        // enctype='application/x-www-form-urlencoded>");
        // 用户名
        writer.write("名字：" + username+"<br>");
        // 具体的某封邮件
        writer.write(username+"约吗？");
        // writer.write("</form>");
    }
}
/**
 * 小结：@WebServlet(value="/路径")里面填的路径是本servlet的路径，而不能是别的
 * //响应的内容类型和编码格式
        resp.setContentType("text/html;charset=UTF-8");
     上面格式要记牢
 */