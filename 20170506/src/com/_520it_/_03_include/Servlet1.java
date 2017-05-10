//需求：运用请求包含，从Servlet1跳转到Servlet2，观察跳转时浏览器的现象。
//(1)建两个servlet，在控制台/浏览器分别打印before/after并观察不同的输出结果
//在s1建请求包含并指向s2的地址，观察控制台/浏览器的输出结果，与上面对比
//（2）在浏览器页面url中拼接name，在s1和s2中获取并syso输出，
//（3）在2个servlet中打印req，观察是否是同一个请求对象
//（5）把路径改为外域网址，回车
//（6）访问WEB-INF下的login.html
package com._520it_._03_include;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/include/s1")
public class Servlet1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设请求/响应格式
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        //通过响应对象拿打印流
        PrintWriter writer = resp.getWriter();
        writer.write("s1before<br>");
        System.out.println("s1before");
        
        //通过响求对象重定向到某个地址
        //req.getRequestDispatcher("/redirect/s2").include(req, resp);
        //无法访问WEB-INF下面的资源文件
        req.getRequestDispatcher("/WEB-INF/hello.html").include(req, resp);
        
        //这页面跳转中,网页url没发生改变
        //拿到网页传进来的值
        String name = req.getParameter("name");
        System.out.println("s1的"+name);
        //-----------------------------------------------
        writer.write("s1after<br>");
        System.out.println("s1after");
        //打印请求对象
        System.out.println(req);
    }
/**
 * 小结：请求包含的响应结果包含了两个servlet的输出内容
 * 而在控制台中的输出结果为按顺序执行，中间是s2
 */
}
