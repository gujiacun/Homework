package com._520it._03_characterEncoding;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.sun.xml.internal.ws.util.StringUtils;

public class CharacterEncodingFilter implements Filter {
    // 把设置编码格式的部分放到web.xml中，在过滤器中获取并设置编码格式
    // 在init方法中通过filterConfig调用getInitParameter拿到在web.xml中设置的编码格式
    // 由于要在doFilter方法中用，扩大作用域，在doFilter方法中设置格式
    // 应该让用户控制参数的试用情况,所以在web.xml中的参数设置为强制性/可选择性使用,在那里设置force,值为false
    // 在init方法中拿force的值,在doFilter方法中做判断：
    // （1）当配置了编码，然后是强制性使用,设置编码
    // （2）当配置了编码，不是强制性使用,但是在之前的过滤器中没有设置编码,设置编码
    String encodingType;
    Boolean force;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub
        encodingType = filterConfig.getInitParameter("encoding");
        force = Boolean.valueOf(filterConfig.getInitParameter("force"));
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // 转换请求对象的类型
        HttpServletRequest req = (HttpServletRequest) request;
        // 注意这里是通过请求对象拿当前正在使用的编码格式的名称，不是在web.xml中设置的编码格式
        // 因为可能在web.xml中设置了编码格式，但是在之前的过滤器没有被设置使用，而web.xml中设置的编码格式肯定是有值的
        if (hasLength(encodingType) && (force || req.getCharacterEncoding() == null)) {
            // 设置编码格式
            req.setCharacterEncoding(encodingType);
        }

        // 放行
        chain.doFilter(req, response);

    }

    private boolean hasLength(String encodingType2) {
        // TODO Auto-generated method stub
        return encodingType2 != null && !"".equals(encodingType2.trim());
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

}
