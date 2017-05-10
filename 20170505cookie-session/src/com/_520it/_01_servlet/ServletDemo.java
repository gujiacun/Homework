//需求：1.同一个servlet可配置多个url-pattern,在<servlet-name>里,设置多个<url-pattern>
//2.同一个servlet可配置多个<servlet-mapping>，这些<servlet-mapping>的servlet-name要相同，
//但url-pattern不同
//3.在web.xml中用占位符配置servlet的映射路径
//(1)在<url-pattern>/*</url-pattern>什么路径都能访问这个servlet,中间可以再加东西，表权限控制
//(2)<url-pattern>*.文件格式</url-pattern>表访问路径要以指定的文件格式结尾
//4.注解映射：(1)用注解配置多个映射路径,源码显式是value=string数组
//(2)配置初始化参数,initParams={@WebInitParam(name="encoding",value="UTF-8"),
        //@WebInitParam(name="name",value="risa")}
//5.servlet初始化，在web.xml文件中,<load-on-startup>数字,在类中重写init方法,建公共无参构造器
//运行，可看到在浏览器没有发送请求到服务器时，公共无参构造器和init方法已经运行
package com._520it._01_servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(value={"*.fuckme","*.fuck"},
initParams={@WebInitParam(name="encoding",value="UTF-8"),
        @WebInitParam(name="name",value="risa")})
//继承HttpServlet类
public class ServletDemo extends HttpServlet{
   
    private static final long serialVersionUID = 1L;
    @Override
    public void init() throws ServletException {
        System.out.println("初始化");
    }
    //公共无参构造器
    public ServletDemo() {
        System.out.println("公共无参构造器");
    }
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 程序正常运行会输出这句话
        System.out.println("模拟试验servlet的映射细节");
    }
/**
 * 小结：使用注解的前提：(放在类的上面，不是方法上)
 * 注意：当注解被修改,相当于配置被修改，tomcat也要重启,记住用注解配置初始化参数的格式
 */
}
