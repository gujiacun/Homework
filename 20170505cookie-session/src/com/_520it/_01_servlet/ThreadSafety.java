//需求：当两个客户端同时请求同一个servlet时，会有线程安全问题
//（1）建类，继承HttpServlet类，重写service方法
//（2）设置请求的编码格式为UTF-8，设置响应的编码格式一致，返回内容是text/html
//（3）在同一浏览器开两个网页，用/st?name=hirate和/st?name=manaka向此servlet请求
//（5）从请求拿到name的值，沉睡5秒延时，再用响应输出name，观察结果
//（6）为解决出现的线程安全问题，让此类实现SingleThreadModel接口，让此类变为单线程形式,输出结果正常
//也可以不用成员变量，此时把name移到service方法中，不实现SingleThreadModel接口。结果正常
package com._520it._01_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.SingleThreadModel;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//public class ThreadSafety extends HttpServlet implements SingleThreadModel{
public class ThreadSafety extends HttpServlet {
    private static final long serialVersionUID = 1L;
    //成员变量
    //String name;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求的编码格式为UTF-8，
        req.setCharacterEncoding("UTF-8");
        //设置响应的编码格式一致，返回内容是text/html,下面用简写
        resp.setContentType("text/html;charset=UTF-8");
        //从请求拿到name的值，http://localhost/st?name=hirate和http://localhost/st?name=manaka
        String name = req.getParameter("name");
        //沉睡5秒延时，
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //再用响应输出name
        //(1)先通过HttpServletResponse对象拿响应流PrintWriter
        PrintWriter writer = resp.getWriter();
        //（2）通过响应流向客户端输出内容
        writer.write(name);
    }
/**
 * 小结：hirate先执行，manaka后执行，hirate进入程序赋值在name，
 * 但有了沉睡后，manaka也进入程序，占据了name，等到hirate苏醒后，输出的name值是manaka
 */
}
