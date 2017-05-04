// 需求：研究HttpServletResponse中的常用方法
//继承HttpServlet类
package com._520it._03_http;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpServletResponseDemo extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置输出的数据以UTF-8方式显示。
        // resp.setCharacterEncoding("UTF-8");
        // 注意：必须在获取响应流之前设置,否则无效
        // resp.setCharacterEncoding("UTF-8");
        // 获取响应流： 字节跟字符
        // OutputStream outputStream = resp.getOutputStream();
        // 输出,注意这里是会输出到跳转的新页面上
        // outputStream.write("excited".getBytes());
        //
        // 上面获取响应流是互斥的， 也就是说一个service 中只能获取其中一个
        // 设置输出的数据以UTF-8方式显示。
        resp.setCharacterEncoding("UTF-8");
        // 设置响应内容类型(浏览器嫩格式别的类型)
        resp.setContentType("text/html");
        // 获取字符流
        PrintWriter writer = resp.getWriter();
        // 打印语句"年轻人，你懂得生命的宝贵吗？从今天开始，你的一分钟只有59秒了"
        writer.write("年轻人，你懂得生命的宝贵吗？从今天开始，你的一分钟只有59秒了");
        //
        //
        // 同时设置编码及内容类型，等于上面两部
        // resp.setContentType("text/html; charset=UTF-8");

    }
/**
 * 小结：同时设置内容类型及编码的setContentType()方法，中间要用;分割
 */
}
