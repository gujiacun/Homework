package com._520it._02_request_type;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.sun.net.httpserver.Filter.Chain;

public class HelloFilter implements Filter {

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        // 把请求对象转为HttpServletRequest类型
        //HttpServletRequest request = (HttpServletRequest) req;
        // 输出，由于在server.xml中删除了根路径,所以这里只输出/
        //System.out.println(request.getRequestURI());
        System.out.println("过滤器");
        chain.doFilter(req, resp);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub

    }

}
