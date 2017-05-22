package com._520it._04_checkLogin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//需求：利用过滤器进行登陆验证过滤，限制某些资源文件只有登陆后才能访问,若未登录就访问重定向至登陆页面
//建登陆页面的jsp;在servlet中通过请求对象拿用户输入的用户名和密码,封装为用户对象(建实体用户类)，把它扔进session，重定向至登陆后的主页面的jsp
//在主页面的jsp中建超链接2个，指向不同的子页面，此时分别访问这几个页面
//限制页面只有登陆后才能访问，在所有的jsp中加上java代码,判断在session中是否存在用户对象，没有就返回登陆页面,直接结束方法
//假如有多个页面，每个页面都要重复写上一步的java代码，所以建过滤器，把上一步的代码拷进里面
//此时出现问题,localhost 将您重定向的次数过多。解决方案：设置一些东西不需要被检测
//在web.xml中设置初始化参数，参数名/以及其值,设置的是不受检查的URI地址
//在过滤器里获取这些不受检查的URI地址，包装为数组，再转为list集合；拿请求的资源名称，比较，若请求的资源名称补板焊在数组里，执行下一步部
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        //只有这个用户才能登陆进去
        if ("techi".equals(username)&&"keyaki".equals(password)) {
            req.getSession().setAttribute("USER_IN_SESSION",user);
            resp.sendRedirect("/main.jsp");
        }
    }
    
//    <% User user = (User)session.getAttribute("USER_IN_SESSION");
//    if(user == null){
//        response.sendRedirect("/login.jsp");
//        return;
//    }
//    %>
/**
 * 小结：把数据扔进session的格式：
 * req.getSession().setAttribute(XXXXXX)
 */
}
