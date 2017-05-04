package com._520it._01_hello;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//需求：在创建完第一个servlet程序后，打开tomcat，在浏览器输入http://localhost/pss/hello，并刷新，观察此类的输出结果
//通过程序动态去获取 encoding的值,步骤：(1)在项目的web.xml中设置初始化参数，在<servlet>标签内,在<servlet-class>后
//设置格式为<init-param><param-name>XXX</param-name><param-value>YYY</param-value>
//</init-param>
//(2)利用ServletConfig类把初始化参数包装成对象，用里面方法输出
//首先把init方法内的ServletConfig扩大作用域，把它定义为全局变量
//通过参数名拿当前servlet配置的初始化参数值
//public class HelloServlet implements Servlet {
//    public HelloServlet() {
//        // 公共无参构造器，方便调用
//        System.out.println("构造器");
//    }
//
//    // 由于ServletConfig是接口，不能直接建对象
//    ServletConfig config;
//
//    // 由服务器调用，初始化servlet需要的相关参数
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        this.config = config;
//        System.out.println("初始化方法，初始化servlet需要的相关参数");
//        // 根据参数名获取当前servlet的配置文件中的初始属性值
//        String result = config.getInitParameter("encoding");
//        System.out.println(result);
//        // 拿当前servlet所有的初始属性的名字（不包含值）
//        Enumeration<String> parameterNames = config.getInitParameterNames();
//        // 返回特殊的类，用while循环，hasMoreElements()测试此枚举是否包含更多的元素
//        while (parameterNames.hasMoreElements()) {
//            // 返回此枚举的下一个元素
//            String string = (String) parameterNames.nextElement();
//            // 通过属性名拿属性值,即用上一种拿单个初始属性值的方法，只是在外面多加了循环
//            System.out.println(config.getInitParameter(string));
//        }
//    }
//
//    // 销毁这个servlet，tomcat正常关闭时自动执行
//    @Override
//    public void destroy() {
//        // TODO Auto-generated method stub
//        System.out.println("销毁方法");
//
//    }
//
//    // 获取当前servlet的初始化参数对象，返回ServletConfig对象
//    @Override
//    public ServletConfig getServletConfig() {
//        System.out.println("获取当前servlet的初始化参数对象");
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    /// 获取当前servlet的相关信息
//    @Override
//    public String getServletInfo() {
//        System.out.println("获取当前servlet的相关信息");
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    // 专门处理请求和响应逻辑
//    @Override
//    public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
//        // 模拟需求，假如编码是UTF-8/GBK，显示UTF-8/GBK
//        String encoding = "UTF-8";
//        if ("UTF-8".equals(encoding)) {
//            System.out.println("UTF-8");
//        } else if ("GBK".equals(encoding)) {
//            System.out.println("GBK");
//        }
//        System.out.println("处理请求和响应逻辑");
//        // 但由于这是硬编码，要通过程序动态获取encoding的值
//
//    }
//    /**
//     * 小结：当客户端和服务器建立连接时，启用Servlet接口的实现类的构造器，初始化方法和service方法
//     * 其中构造器，初始化方法只在开始时执行一次，service方法在每次刷新页面都执行
//     */
//}
