package com._520it._04_checkLogin;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//此时出现问题,localhost 将您重定向的次数过多。解决方案：设置一些东西不需要被检测
//在web.xml中设置初始化参数，参数名/以及其值,设置的是不受检查的URI地址
//在过滤器里获取这些不受检查的URI地址，包装为数组，再转为list集合；拿请求的资源名称，比较，若请求的资源名称不包含在数组里，执行下一步部
public class CheckLoginServlet implements Filter {
    String[] uncheckedURI;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 在过滤器里获取这些不受检查的URI地址,用逗号分隔并塞进数组
        uncheckedURI = filterConfig.getInitParameter("uncheckedURI").split(",");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // 转换请求对象的类型
        HttpServletRequest req = (HttpServletRequest) request;
        // 转换响应对象的类型
        HttpServletResponse resp = (HttpServletResponse) response;
        // 数组转为list集合
        List list = Arrays.asList(uncheckedURI);
        // 拿请求的资源名称
        String requestURI = req.getRequestURI();
        // 若请求的资源名称不包含在数组里，执行下一步部
        if (!list.contains(requestURI)) {
            // 从session中拿USER_IN_SESSION的值
            User user = (User) req.getSession().getAttribute("USER_IN_SESSION");
            if (user == null) {
                resp.sendRedirect("/login.jsp");
                return;
            }
        }
        // 放行
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

}
