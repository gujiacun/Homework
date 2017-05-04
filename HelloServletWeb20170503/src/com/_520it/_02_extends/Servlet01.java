//需求：探讨Servlet继承体系的设计，这里研究得到初始参数
//(1)实现Servlet接口，重写方法，把ServletConfig的对象作为成员变量，得到配置文件的初始参数得值
//（2）但若有多个Servlet类就要多写相同的代码，把共同代码抽取，放到新类MyGenericServlet，实现Servlet接口
//两个Servlet类继承它即可
//（3）要令子类的调用方法变得更简洁，把.getServletConfig()去掉，既然它的目的是拿ServletConfig对象，就让父类去实现
//（4）子类进行初始化，在父类定义一个空参数的init()方法，由子类重写，调用带参数的init()方法时，调用空参数的init()方法
//（5）下面的service方法处理的是普通的请求和响应，若想专门处理http的请求和响应，需要强制类型转换，不便
//所以重载service方法，专门处理http的请求和响应,http请求方式主要有GET/POST，辨别请求的类型，再根据不同类型
//的请求方式专门调用新的响应方式
//(6)但若有多个servlet就要写多遍专门处理http的请求和响应的方法，所以把这部分抽取为一个继承于MyGenericServlet的类，
//再让Servlet1和2继承此类
package com._520it._02_extends;

import java.io.IOException;
import java.util.Enumeration;

//import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet01 extends MyHttpServlet{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        // 要覆写父类的方法，否则报空指针,因为下面代码用到父类的ServletConfig对象，但不调用此方法就是null
//        super.init(config);
//    }
//    public void init(){
//        System.out.println("子类初始化");
//    }
//    @Override
//    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//        // 在此拿这个Servlet的初始属性
//        // 由于父类中的service方法是对象的，要调用就先拿父类中ServletConfig的对象，要在父类建能返回此对象的方法
//        //用super关键字
////        String name = super.getInitParameter("encoding");
////        System.out.println(name);
//        HttpServletRequest request = (HttpServletRequest)req;
//        HttpServletResponse response = (HttpServletResponse) res;
//        service(request,response);
//    }
//    //@Override
//    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        // 用getMethod()方法返回请求类型
//        String requestType = req.getMethod();
//        // 用if-else if判断是什么类型，根据不同类型调用不同的处理方法
//        if ("GET".equals(requestType)) {
//            doGet(req,res);
//        } else if("POST".equals(requestType)){
//            doPost(req,res);
//        }
//    }
    public void doGet(HttpServletRequest req, HttpServletResponse res) {
        super.doGet(req,res);
        
    }
    public void doPost(HttpServletRequest req, HttpServletResponse res) {
        super.doPost(req, res);
        
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
/**
 * 小结：在debug时，要追踪错误信息在哪里发生，被谁调用，清楚父类子类之间方法的互相关系
 */
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
    /**
     * 小结：专门处理http请求和响应被抽出来作为一个类，HttpServletRequest有一个对象方法method，返回请求方式的类型的字符串
     * 所以可以用if语句和equals方法区别出是哪一种请求方式，再调用不同的处理方法
     * 同时，经过重构后，以后的代码能变得更简洁
     */
}
