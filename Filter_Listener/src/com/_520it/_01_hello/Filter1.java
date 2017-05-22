package com._520it._01_hello;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
//@WebServlet("/")
public class Filter1 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // 由于没有执行放行操作，只会输出Filter1的语句
        System.out.println("我是过滤器1");
        // 放行
        chain.doFilter(request, response);
        System.out.println("我是放行后的过滤器1");
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }
/**
 * 小结：过滤器的执行顺序由web.xml中的<filter-mapping>的先后顺序决定
 * 执行请求`放行前是按照这个顺序，执行响应`放行后倒过来
 */

}
