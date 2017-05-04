//需求：模拟用户登录，用户输入信息，分别输入一个英文和中文，发生乱码问题时用用三种方法解决
//（1）新建html，把上一作业拷贝并简化
//（2）把此类继承HttpServlet，重写service方法，分别在浏览器的网页上的用户名一栏输入英文和中文
//（3）方法一：通过请求对象先拿用户名的参数值，再把它通过ISO-8859-1转换为字节串数组（二进制流）
//（4）把二进制流转换为UTF-8的字符串，输出
//（5）方法二：POST方式，通过请求对象调用setCharacterEncoding(XXX)方法，指定请求参数统一使用某种编码格式处理
//（6）方法三：GET方式，tomcat配置文件的11行<Connector>增加输入URIEncoding=XXX,指定用哪种编码格式
package com._520it._05_encoding;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EncodingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 在浏览器的登陆页面输入英文和中文，分别通过请求对象先拿用户名的参数值
        //System.out.println(req.getParameter("username"));
        // 方法一:通过请求对象先拿用户名的参数值，再把它通过ISO-8859-1转换为字节数组/二进制流(用getBytes(字符集)方法)
        //String name = req.getParameter("username");
        //byte[] array = name.getBytes("ISO-8859-1");
        // 把二进制流转换为UTF-8的字符串，用调用字符串构造器并传入字节数组和字符集的方法
        //name = new String(array,"UTF-8");
        //输出
        //System.out.println(name);
        // 方法二：POST方式，通过请求对象调用setCharacterEncoding(XXX)方法，指定请求参数统一使用某种编码格式处理
        //req.setCharacterEncoding("UTF-8");
        //String name = req.getParameter("username");
        //System.out.println(name);
        // 方法三：GET方式，tomcat根目录下的conf文件夹的server.xml文件的71行<Connector>增加输入URIEncoding=XXX,指定用哪种编码格式
        String name = req.getParameter("username");
        System.out.println(name);
    }
    /**
     * 小结：执行流程为： （1）在浏览器访问http://localhost/pss/login.html，填入用户名和密码
     * （2）在login.html文件中，在action填入要跳转到的页面，这里是/pss/login，点击登录按钮，跳转到该页面
     * （3）在server.xml中的context的path填/pss，docBase路径填webapp文件夹（web项目的根目录）
     * （4）程序在跳转到新页面时，找到server.xml，解析，检测path的值是否等于新页面的/pss，若等于就去docBase的路径
     * （5）程序找到位于上面的文件夹里的web.xml，解析，找到<servlet-mapping>的<url-pattern>，检验是否等于新页面的/login，等于就找<servlet-name>
     * 再找上面一个同名的<servlet-name>，在其下面的<servlet-class>中创建新Class实例，再调用类里面的方法
     */
}
