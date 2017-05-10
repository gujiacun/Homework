//需求：模拟登陆邮箱，输入密码，跳到主页面，点击收件箱(35)，跳到邮件列表(显示5条),再点击,跳到某个邮件内容
//由于http协议的无状态,用cookie
//步骤：新建三个servlet，继承HttpServlet类，建登陆.html,三个类重写service方法，设置请求的编码格式，响应的内容类型和编码格式，html文件改action的路径,三个类用注解配置
//在servlet中重写service方法，通过getParameter(XX)拿特定的值
//（1）在login.html中输入名字密码，点击按钮跳到LoginServlet,LoginServlet从中拿username的值
//（2）在LoginServlet中新建cookie，用构造器传入用户名的名称和值
//（3）把cookie放入到响应对象中。
//（4）输出响应语句，记住要用超链接
//(5)输出响应
//(6)为了用户名能输入中文，把username的值先编码塞进cookie，再在接受它的servlet中解码
//(7)修改Cookie(两种方式，都要添加进响应对象里)
//（8）持久化cookie，0表示删除这个cookie，正数表示只维持设定的时间，负数表示它是会话cookie（关闭浏览器后销毁）
package com._520it._03_cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(value="/cookie/login")
public class LoginServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;
    //重写service方法
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求的编码格式，
        req.setCharacterEncoding("UTF-8");
        //响应的内容类型和编码格式
        resp.setContentType("text/html;charset=UTF-8");
        //拿username的值
        String name = req.getParameter("username");
        //新建cookie，把username的值通过构造器传进去,同时为了用户名能输入中文，把username的值先编码塞进cookie，再在接受它的servlet中解码
        // 构造器： Cookie(String name, String value),Constructs a cookie with a specified name and value.
        // 解码URLEncoder.encode(字符串,"编码格式")
        Cookie cookie = new Cookie("username", URLEncoder.encode(name,"UTF-8"));
        //持久化cookie，0表示删除这个cookie，正数表示只维持设定的时间，负数表示它是会话cookie（关闭浏览器后销毁）
        //cookie.setMaxAge(0);
        cookie.setMaxAge(30);
        //cookie.setMaxAge(-3);
        //修改Cookie
        //方法一：新建一个cookie（注意不是重新赋值）,注意name要相同，否则不能形成覆盖效果，然后把它加进去
        Cookie newCookie = new Cookie("username02", "Manaka");
        //方法二:用setValue方法修改cookie里面的值
        //cookie.setValue("xueyou");
        //要用HttpServletResponse对象把cookie添加进去
        resp.addCookie(cookie);
        resp.addCookie(newCookie);
        //写响应页面,先通过响应对象拿打印流对象，再用此调用write方法
        PrintWriter writer = resp.getWriter();
        writer.write("名字："+name);
      //这行是收件箱，点击后可以调到收件箱/ListServlet类，所以用超链接,<font color='red'>
        writer.write("<br><a href='/cookie/list'>收件箱(35)</a>");
    }
}
/**
 * 小结：使用注解的前提：(放在类的上面，不是方法上)
 * 注意：当注解被修改,相当于配置被修改，tomcat也要重启,记住用注解配置初始化参数的格式
 */
