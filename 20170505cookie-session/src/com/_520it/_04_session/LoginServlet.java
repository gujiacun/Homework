//需求：模拟登陆邮箱，输入密码，跳到主页面，点击收件箱(35)，跳到邮件列表(显示5条),再点击,跳到某个邮件内容
//由于http协议的无状态,用session
//步骤：新建三个servlet，继承HttpServlet类，建登陆.html,三个类重写service方法，设置请求的编码格式，响应的内容类型和编码格式，html文件改action的路径,三个类用注解配置
//在servlet中重写service方法，通过getParameter(XX)拿特定的值
//（1）在login.html中输入名字密码，点击按钮跳到LoginServlet,LoginServlet从中拿username的值
//（2）在LoginServlet中新建cookie，用构造器传入用户名的名称和值
//（3）把cookie放入到响应对象中。
//（4）输出响应语句，记住要用超链接
//(5)输出响应
//从session 删除数据：
//       session.removeAttribute(String name);   ： 删除指定name值得数据
//       session.invalidate()   删除session中所有的数据
//Session的超时管理 /存活周期  session.setMaxInactiveInterval(int seconds)
//URL重定向
package com._520it._04_session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(value="/session/login")
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
        //通过请求对象新建HttpSession对象，
        HttpSession session = req.getSession();
        //把username的值通过setAttribute方法传进去
        session.setAttribute("USERNAME_IN_SESSION", name);
        session.setAttribute("USERNAME_IN_SESSION02", name);
        //删除session中某个指定的值
        session.removeAttribute("USERNAME_IN_SESSION02");
        //Session的超时管理/存活周期
        //session.setMaxInactiveInterval(3);
        //由于session是服务端的技术，在这里会被存储在tomcat里，不用有一个servlet发送到另一个servlet
        System.out.println(session.getId());
        String url = resp.encodeURL("/session/list");
        System.out.println(url);
        
        //写响应页面,先通过响应对象拿打印流对象，再用此调用write方法
        PrintWriter writer = resp.getWriter();
        writer.write("名字："+name);
      //这行是收件箱，点击后可以调到收件箱/ListServlet类，所以用超链接,<font color='red'>
        writer.write("<br><a href='/session/list'>收件箱(35)</a>");
    }
}
/**
 * 小结：@WebServlet(value="/路径")里面填的路径是本servlet的路径，而不能是别的
 * //响应的内容类型和编码格式
        resp.setContentType("text/html;charset=UTF-8");
     上面格式要记牢
 */
