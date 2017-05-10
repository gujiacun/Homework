//需求：//ScopeServlet把这三个发送到Servlet2，在那里输出到页面
package com._520it_._04_scope;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/scope/s2")
public class Servlet2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求/响应格式
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
       
        //通过响应对象拿打印流
        PrintWriter writer = resp.getWriter();
        //通过打印流对象输出在页面,其中"NUM_IN_REQUEST"要通过请求对象的getAttribute方法拿到(拿共享数据)
        writer.write("request:"+req.getAttribute("NUM_IN_REQUEST"));
        
        
        //拿session里面的值
        writer.write("<br>session："+req.getSession().getAttribute("NUM_IN_REQUEST"));
        
        
        //拿servletContext里面的值
        writer.write("<br>servletContext："+super.getServletContext().getAttribute("NUM_IN_REQUEST"));
        
        
        
        
    }
}
