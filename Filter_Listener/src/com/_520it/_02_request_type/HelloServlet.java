package com._520it._02_request_type;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//需求：探究servlet与filter一起工作，Filter的过滤的请求类型
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        System.out.println("强闯春晚直播现场");
        //请求转发
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
        //重定向
        //resp.sendRedirect("/index.jsp");
    }
}
