package com._520it._03_characterEncoding;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//需求：请求编码过滤器，把servlet中的编码部分放到Filter中
//建登陆页面，先不设置编码格式，在页面中输入中文，在servlet中拿并直接输出看到乱码;设置格式，重复操作
//把设置编码格式的部分放到过滤器，再输出
//上一步不够方便，把设置编码格式的部分放到web.xml中，在过滤器中获取并设置编码格式
@WebServlet("/my")
public class MyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置编码格式
        //req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        System.out.println(name);
    }
/**
 * 小结：以后要解决硬编码问题/某些参数在日后要改动，放在配置文件中
 */
}
