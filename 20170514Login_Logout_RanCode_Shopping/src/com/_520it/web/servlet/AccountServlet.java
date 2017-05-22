package com._520it.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/account")
public class AccountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        //为防止重复提交，在第一次请求表单页面时，生成一份随机数，放在表单和session中
        //在account.jsp中生成随机数，放进session中
        //拿表单中的/session中的随机数
        String code = req.getParameter("code");
        String sessionCode = (String) req.getSession().getAttribute("CODE_IN_SESSION");
        //如果两个相同，把共享数据从session删除，不同就不管
        if (code.equals(sessionCode)) {
            req.getSession().removeAttribute("CODE_IN_SESSION");
            //拿转账金额
            String account = req.getParameter("account");
            //打印转账金额
            System.out.println("转账金额为："+account);
            //重新返回原页面
            req.getRequestDispatcher("/account.jsp").forward(req, resp);
        }else{
            System.out.println("请不要重复提交表单");
        }
    }
/**
 * 小结：<input type="hidden" value="${CODE_IN_SESSION}" name="code">
 * value="${CODE_IN_SESSION}"，否则在AccountServlet中无法拿到code的值
 */
}
