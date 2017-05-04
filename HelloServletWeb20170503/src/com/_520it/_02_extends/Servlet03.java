//需求：在实际开发中，由于已经有了现成的HttpServlet类，只需要定义一个继承于它的类装各个servlet公共代码，
//再定义各个servlet继承于它。现在此类模拟实际开发中，专门处理http的请求和响应
//方法一：（1）继承HttpServlet类，重写HttpServlet中的方法
//方法二：同时创建doGet和doPost方法，使用doGet方法时在里面调用doPost方法
//方法三：与上一种反转
package com._520it._02_extends;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet03 extends HttpServlet {
   
    private static final long serialVersionUID = 1L;
    //方法一，重写HttpServlet的
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 这时要把super语句删去，否则报错
        //HTTP Status 405 - HTTP method GET is not supported by this URL
        //super.service(req, resp);
    }
   // 方法二：同时创建doGet和doPost方法，使用doGet方法时在里面调用doPost方法
//    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doPost(req,resp);
//    }
//    public void doPost(HttpServletRequest req, HttpServletResponse resp){
//        
//    }
    // 方法三：同时创建doGet和doPost方法，使用doPost方法时在里面调用doGet方法
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        doGet(req,resp);
    }
/**
 * 小结：servlet就是一种内置web服务器的java程序，可以对来自网络的的请求接收和回应。
 */
}
