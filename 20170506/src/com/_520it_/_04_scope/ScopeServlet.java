//需求：研究request,session,servletContext 它们共享数据作用范围
//在ScopeServlet中新建三个Integer变量,分别把它们用request,session,servletContext存放
//建if语句,通过页面拿NUM_IN_REQUEST的值，若它为空则把请求对象的值设为1，不空则把请求对象的值加1
//ScopeServlet把这三个发送到Servlet2，在那里输出到页面
//用两个浏览器不停地刷新，然后重启，验证它们各自的作用域
package com._520it_._04_scope;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/scope/s1")
public class ScopeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求/响应格式
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        // 新建三个Integer变量，读取
        Integer numInRequest = (Integer) req.getAttribute("NUM_IN_REQUEST");
        // if判断条件，除rquest外，每次刷新浏览器都会给请求对象增加值
        if (numInRequest == null) {
            req.setAttribute("NUM_IN_REQUEST", 1);
        } else {
            req.setAttribute("NUM_IN_REQUEST", numInRequest + 1);
        }
        
        
        
        
        //从请求对象拿值
        Integer numInSession = (Integer) req.getSession().getAttribute("NUM_IN_REQUEST");
        //建session对象
        HttpSession session = req.getSession();
        // if判断条件，除rquest外，每次刷新浏览器都会给请求对象增加值
        if (numInSession == null) {
            session.setAttribute("NUM_IN_REQUEST", 1);
        } else {
            session.setAttribute("NUM_IN_REQUEST", numInSession + 1);
        }

        

        
        Integer numInServletContext = (Integer) req.getServletContext().getAttribute("NUM_IN_REQUEST");
        // 建ServletContext对象,设置数据
        ServletContext servletContext = super.getServletContext();
        // if判断条件，除rquest外，每次刷新浏览器都会给请求对象增加值
        if (servletContext == null) {
            servletContext.setAttribute("NUM_IN_REQUEST", 1);
        } else {
            servletContext.setAttribute("NUM_IN_REQUEST", numInServletContext + 1);
        }

        // 要进行web组件跳转，还要把请求对象中的数据发送给另一个servlet，用请求转发
        req.getRequestDispatcher("/scope/s2").forward(req, resp);
 
    }
}
/**
 * 小结：这三者共同的作用是在复数个servlet中进行数据共享，所以要建两个servlet
 * 在进行请求转发时，把该语句放在最后，否则报错
 * equest: 每请求一次创建一个新的request对象,值在上述例子中不更新
   session：   一次会话，创建一个新的session对象，在同一个浏览器中值会更新
   servletContext(application)： 在tomcat启动，加载了项目之后，会创建一个新的servletContext对象
   即使在不同浏览器之间都会更新数据
 */
