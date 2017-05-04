// 需求：研究HttpServletRequest中的常用方法
//继承HttpServletRequest类，重写service方法
package com._520it._03_http;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpServletRequestDemo extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // 重写service方法
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 一。注意把自带的super语句删去
        // 利用方法中传入的HttpServletRequest对象，获取请求行信息
        // 01.getMethod:返回请求方式：如GET
        String requestWay = req.getMethod();
        //System.out.println(requestWay);
        
        // 02.String getRequestURI:返回请求行中的资源名字（上下文路径+资源名）:如/pss/req
        String requestURI = req.getRequestURI();
       // System.out.println(requestURI);
        
        // 03.StringBuffer req.getRequestURL() 返回的url： http://localhost/pss/req
        StringBuffer requestURL = req.getRequestURL();
        //System.out.println(requestURL);
        
        
        // 04.getContextPath:返回请求URL所属Web应用的路径。路径以"/"开头
        String contextPath = req.getContextPath();
        //System.out.println(contextPath);
        // 05.getRemoteAddr:返回发出请求的客户机的IP地址
        String remoteAddr= req.getRemoteAddr();
        //System.out.println(remoteAddr);
        //System.out.println(req.getRemotePort());
        //System.out.println(req.getRemoteHost());
        // 二。获取请求头信息
        // 06.getHeader:返回指定名称的头字段的值。
        System.out.println(req.getHeader("Accept-Encoding"));
        // 07.getHeaders:返回指定名称的头字段的多个值所组成的Enumeration对象。
        
    }
    /**
     * 小结：要处理http的请求和响应，要把该类继承HttpServlet类，再重写service方法
     * 注意：service方法有两个，一个是处理ServletRequest和ServletResponse的，
     * 另一个重载方法是处理HttpServletRequest和HttpServletResponse的
     * 在IDE中直接写service然后选择，注意把自带的super语句删去
     * 在chrome拿请求头/响应头信息的步骤：
     * （1）按F12，选network，在左边的Name栏目中选第一项（与资源名字相同），选headers
     */
}
