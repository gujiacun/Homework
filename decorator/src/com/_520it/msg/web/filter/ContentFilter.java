package com._520it.msg.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//需求：对网页输入的内容进行过滤，但getParameter只能拿输入的真实数据，建一个类继承这方法所在的类，重写这方法，增强功能
public class ContentFilter implements Filter {

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // TODO Auto-generated method stub
        //转换请求/响应对象
        HttpServletRequest req = (HttpServletRequest)request;
        //HttpServletResponse resp = (HttpServletResponse)response;
        //把原始的请求对象转为自定义的请求对象
        MyHttpServletRequestWrapper requestWrapper = new MyHttpServletRequestWrapper(req);
        chain.doFilter(requestWrapper, response);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub

    }

}
