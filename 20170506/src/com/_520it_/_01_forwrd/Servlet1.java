//需求：从Servlet1跳转到Servlet2，观察跳转时浏览器的现象。运用请求转发，在两个servlet间传输数据
//(1)建两个servlet，在控制台/浏览器分别打印before/after并观察不同的输出结果
//在s1建请求转发，观察控制台/浏览器的输出结果，与上面对比
//（2）在浏览器页面url中拼接name，在s1和s2中获取并syso输出，
//（3）在2个servlet中打印req，观察是否是同一个同一个请求对象
//（4）在请求转发的方法中输入XXXX和/xxx  观察页面跳转结果
//（5）把路径改为外域网址，回车
//（6）访问WEB-INF
package com._520it_._01_forwrd;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forward/s1")
public class Servlet1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设请求/响应格式
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        //通过响应对象拿打印流
        PrintWriter writer = resp.getWriter();
        writer.write("s1before<br>");
        System.out.println("s1before");
        
        //通过请求对象拿请求的分发器，包装要发到的地址，把请求送达,
        //可看出在http://localhost/forward/s1这页面中,输出的是s2中的语句
        //而在控制台中，是s1before，s2before，s2after，s1after
        //req.getRequestDispatcher("/forward/s2").forward(req, resp);
        //访问WEB-INF下面的资源文件
        //req.getRequestDispatcher("/WEB-INF/login.html").forward(req, resp);
        req.getRequestDispatcher("/XXXX").forward(req, resp);
        //req.getRequestDispatcher("XXXX").forward(req, resp);
        //通过请求对象获取浏览页面传入的值
        String name = req.getParameter("name");
        System.out.println("s1的"+name);
        //-----------------------------------------------
        writer.write("s1after<br>");
        System.out.println("s1after");
        //打印请求对象
        System.out.println(req);
    }
/**
 * 小结：当两个servlet间要进行数据交换/servlet1要跳转到2时,通过请求转发可达到
 * 
 */
}
