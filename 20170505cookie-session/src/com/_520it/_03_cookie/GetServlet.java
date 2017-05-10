//需求：拿到传进来的cookie里的值，再输出页面
package com._520it._03_cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/cookie/get")
public class GetServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // 重写service方法
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求的编码格式，
        req.setCharacterEncoding("UTF-8");
        // 响应的内容类型和编码格式
        resp.setContentType("text/html;charset=UTF-8");
        // 有cookie传入，获取里面的东西
        Cookie[] cookies = req.getCookies();
        String username = "";
        //先判断cookie是否为空
        if (cookies != null) {
            //循环拿出每一个值
            for (Cookie cookie : cookies) {
                //判断，根据值的名字只拿某一个特别的值
                if ("username".equals(cookie.getName())) {
                    //把该值的实际值赋给外面的变量username
                    username = cookie.getValue();
                }
            }
        }
      //对传进来的东西进行解码
        username = URLDecoder.decode(username,"UTF-8");
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
