package com._520it._01_hello;
//演示有多个过滤器组成的过滤链在执行时的顺序
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Filter3 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // TODO Auto-generated method stub
        System.out.println("我是过滤器3");
        // 放行
        chain.doFilter(request, response);
        System.out.println("我是放行后的过滤器3");
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

}
