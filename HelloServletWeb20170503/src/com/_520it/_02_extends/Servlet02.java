package com._520it._02_extends;

import java.io.IOException;
import java.util.Enumeration;

//import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Servlet02 extends MyHttpServlet{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    //ServletConfig config = null;
    @Override
    public void init(ServletConfig config) throws ServletException {
     // 要覆写父类的方法，否则报空指针
        super.init(config);
    }
   
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // 在此拿这个Servlet的初始属性
        // 由于父类中的service方法是对象的，要调用就先拿父类中ServletConfig的对象，要在父类建能返回此对象的方法
        //用super关键字
        String name = super.getInitParameter("name");
        System.out.println(name);
    }

    @Override
    public ServletConfig getServletConfig() {
        // TODO Auto-generated method stub
        return null;
    }


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

}
