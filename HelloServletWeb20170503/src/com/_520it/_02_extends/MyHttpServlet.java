package com._520it._02_extends;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//专门处理http的请求和响应的类
public class MyHttpServlet extends MyGenericServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    public String getServletInfo() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    @Override
    public String getServletName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ServletContext getServletContext() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Enumeration<String> getInitParameterNames() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        //由于是专门处理http的请求和响应的类，把传进来的普通请求和响应都转为http的
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        service(request, response);

    }

    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // 用getMethod()方法返回请求类型
        String requestType = req.getMethod();
        // 用if-else if判断是什么类型，根据不同类型调用不同的处理方法
        if ("GET".equals(requestType)) {
            //识别出是GET请求，调用doGet方法
            doGet(req, res);
        } else if ("POST".equals(requestType)) {
            //识别出是POST请求，调用doPost方法
            doPost(req, res);
        }
    }
    //处理GET请求
    public void doGet(HttpServletRequest req, HttpServletResponse res) {
        System.out.println("我处理GET请求");
    }

    //处理POST请求
    public void doPost(HttpServletRequest req, HttpServletResponse res) {
        System.out.println("我处理POST请求");

    }
/**
 * 小结：专门处理http请求和响应被抽出来作为一个类，HttpServletRequest有一个对象方法method，返回请求方式的类型的字符串
 * 所以可以用if语句和equals方法区别出是哪一种请求方式，再调用不同的处理方法
 */
}
