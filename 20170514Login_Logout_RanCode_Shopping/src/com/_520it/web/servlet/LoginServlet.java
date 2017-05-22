package com._520it.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com._520it.dao.IUserDAO;
import com._520it.dao.impl.UserDAOImpl;
import com._520it.domain.User;
import com._520it.utils.StringUtils;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    IUserDAO userDAO = new UserDAOImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        // 拿用户在页面上输入的用户名和密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //（1）拿用户提交的验证码
        String randomCode = req.getParameter("randomCode");
        //（2）拿session中的保存的正确验证码
        String sessionRandomCode = (String)req.getSession().getAttribute("RANDOMCODE_IN_SESSION");
        // (3)先判断两者是否有值，有值就两者比较，无值就是session过期或用户没输入验证码
        if (StringUtils.hasLength(randomCode)) {
            //上面中，若有值就比较两者是否相同，若不同就是用户的输入值错误，在页面显示错误信息
            if (!randomCode.equals(sessionRandomCode)) {
                req.setAttribute("errorMsg", "请重新输入验证码");
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }
        }else{
            req.setAttribute("errorMsg", "验证码不能为空/验证码已失效");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
        
        // 调用实现类的方法，传入用户名和密码，返回User对象
        User user = userDAO.checkLogin(username, password);
        // 假如User对象为空,显示错误信息，请求转发至原先的登陆页面
        if (user == null) {
            req.setAttribute("errorMsg","账号或密码错误，请重新输入");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }else{
            // 不为空，把用户信息共享到session中，注意现在的值存储在user，而不是userDAO
            req.getSession().setAttribute("USER_IN_SESSION", user);
            // 重定向至productServlet中，显示数据
            resp.sendRedirect("/product");
        }
    }
/**
 * 小结：登陆页面填入用户名和密码后，跳转至这里，拿到用户输入的两个参数，通过参数调用DAO的方法拿到User对象，再把它通过session发送到页面中
 * 同时重定向到productServlet
 */
}
