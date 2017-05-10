//需求：模拟登陆邮箱的操作，登陆界面，邮箱主页，收件箱，邮件具体内容
//步骤：（1）建登陆页面的html文件，这是开始，在里面<form>标签的属性 action="要跳转到的页面"
//（2）上面新建三个servlet，继承HttpServlet类,当各个页面的按钮被按下后，就会跳转到这些servlet，执行完操作后再输出新页面
//（3）用注解在每个servlet上标注url-pattern
//由于邮箱操作时每个页面都要有登陆名字存在，所以每个servlet要读取登陆名字
//（4）由于http的无状态，所以后来的几个页面无法拿username的值，在请求url中拼接参数解决
package com._520it._02_params;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(value="/param/login")
public class LoginServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    //读取login.html文件中的用户名，先重写service方法
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求的编码格式
        req.setCharacterEncoding("UTF-8");
        //设相应的内容类型和编码格式
        resp.setContentType("text/html;charset=UTF-8");
        // 从请求中拿指定属性名的值
        String username = req.getParameter("username");
        // 在响应中输出新页面，先通过响应对象拿打印流，再调用write方法
        // 登陆页面后，是邮箱主页
        PrintWriter writer = resp.getWriter();
        //writer.write("<form action='/param/login' method='post' enctype='application/x-www-form-urlencoded");
        //writer.write("enctype='application/x-www-form-urlencoded'>");
        writer.write("名字：" + username);
        //这行是收件箱，点击后可以调到收件箱/ListServlet类，所以用超链接,<font color='red'>
        writer.write("<br><a href='/param/list'>收件箱(35)</a>");
        //writer.write("<input type='submit' value='朕要登陆'>");
        //writer.write("</form>");
    }
}
/**
 * 小结：一定要设定请求的编码格式，否则会乱码。也要设定响应的内容类型，否则只会输出字符串，填写的html语句无法识别     
 */
                
                
                
