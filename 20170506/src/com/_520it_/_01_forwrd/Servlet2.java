//需求：从Servlet1跳转到Servlet2，观察跳转时浏览器的现象。
package com._520it_._01_forwrd;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forward/s2")
public class Servlet2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设请求/响应格式
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        //通过响应对象拿打印流
        PrintWriter writer = resp.getWriter();
        writer.write("s2before<br>");
        System.out.println("s2before");
        
        
        //-----------------------------------------------
        //通过请求对象获取浏览页面传入的值
        String name = req.getParameter("name");
        System.out.println("s2的"+name);
        writer.write("s2after<br>");
        System.out.println("s2after");
        //打印请求对象
        System.out.println(req);
    }
}
/**
 * 小结：当两个servlet间要进行数据交换/servlet1要跳转到2时,通过请求转发可达到
 * 
 */
