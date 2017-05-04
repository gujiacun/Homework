package com._520it._02_extends;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

abstract public class MyGenericServlet implements Servlet,ServletConfig,Serializable{
    

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private ServletConfig config;
    @Override
    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
        this.config = config;
        init();
    }
    public void init(){
        //这里不会执行，因为被子类的同名方法重写
        //System.out.println("...");
    }
    @Override
    abstract public void service(ServletRequest req, ServletResponse res) throws ServletException,IOException;
//         //TODO Auto-generated method stub
////        String encodingType = config.getInitParameter("encoding");
////        String name = config.getInitParameter("name");
////        String lover = config.getInitParameter("lover");
////        System.out.println(encodingType);
////        System.out.println(name);
////        System.out.println(lover);
////    }
//
    @Override
    public ServletConfig getServletConfig() {
        // TODO Auto-generated method stub
        return this.config;
    }
    public String getInitParameter(String name){
        return this.config.getInitParameter(name);
    }
//
//
//    @Override
//    public String getServletInfo() {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    public void destroy() {
//        // TODO Auto-generated method stub
//        
//    }
//
/**
 * 小结：专门处理http请求和响应被抽出来作为一个类，HttpServletRequest有一个对象方法method，返回请求方式的类型的字符串
 * 所以可以用if语句和equals方法区别出是哪一种请求方式，再调用不同的处理方法
 */
}
