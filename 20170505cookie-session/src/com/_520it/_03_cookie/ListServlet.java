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

@WebServlet(value = "/cookie/list")
public class ListServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // 重写service方法
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求的编码格式，
        req.setCharacterEncoding("UTF-8");
        // 响应的内容类型和编码格式
        resp.setContentType("text/html;charset=UTF-8");
        // 请求对象中传入cookie，要拿它里面的值
        Cookie[] cookies = req.getCookies();
        String name = "";
        // （1）判断cookie是否为空
        // （2）由于cookie里面有很多值，要找到名为username的值
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    name = cookie.getValue();
                }
            }
        }
        //对传进来的东西进行解码
        name = URLDecoder.decode(name,"UTF-8");
        // 由于下一个页面还要用cookie，所以再创建一个新的cookie并把name值送进去，把它发到响应中，有GetServlet接收
        //Cookie cookie = new Cookie("username", name);
        //resp.addCookie(cookie);
        // 在响应中输出新页面，先通过响应对象拿打印流，再调用write方法
        PrintWriter writer = resp.getWriter();
        // 用户名
        writer.write("名字：" + name);
        // 登陆邮箱及邮件总数,这里显示所有邮件，所以用循环
        for (int i = 1; i < 6; i++) {
            writer.write("<br><a href='/cookie/get' >" + "邮件" + i + "</a>");
        }
    }
}
/**
 * 小结：@WebServlet(value="/路径")里面填的路径是本servlet的路径，而不能是别的
 * //响应的内容类型和编码格式
        resp.setContentType("text/html;charset=UTF-8");
     上面格式要记牢
 */