//需求：拿用户名字，输出响应页面
package com._520it._02_params;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(value="/param/get")
public class GetServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;
    // 重写service方法
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求的编码格式
        req.setCharacterEncoding("UTF-8");
        //设相应的内容类型和编码格式
        resp.setContentType("text/html;charset=UTF-8");
        // 从请求中拿指定属性名的值
        String username = req.getParameter("username");
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
