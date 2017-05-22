package com._520it.core.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com._520it.oa.web.action.DepartmentAction;
import com._520it.oa.web.action.EmployeeAction;

//前端控制器
public class ActionFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // 转格式
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;
        
        // 拿资源
        String requestURI = req.getRequestURI().substring(1);
        // 根据不同的请求资源做不同的请求分发
        if ("employee".equals(requestURI)) {
            EmployeeAction action = new EmployeeAction();
            action.execute();
        } else if("department".equals(requestURI)){
            DepartmentAction action = new DepartmentAction();
            action.execute();
        }
        //做到在浏览器访问localhost/employee和localhost/department,经过前端控制器,能跑到各自的类里面
        System.out.println(requestURI);
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        
    }

}
