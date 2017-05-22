package com._520it._03_servlet_api;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

//需求：在action中访问servlet的API，调用其方法
//建一个类，继承ActionSupport类，根据需求实现与servlet相关的接口
public class ServletAPI01 extends ActionSupport implements ServletRequestAware, ServletResponseAware, SessionAware {

    private static final long serialVersionUID = 1L;

    @Override
    public String execute() throws Exception {
        // 根据servlet中的请求对象获取参数
        return request.getParameter("name");
    }

    
    @Override
    public void setSession(Map<String, Object> arg0) {

    }
    @Override
    public void setServletResponse(HttpServletResponse arg0) {

    }
//建字段
    private HttpServletRequest request ;

    @Override
    public void setServletRequest(HttpServletRequest req ){
        this.request = req;
    }
/**
 * 小结：这种方法令action和servlet耦合，仅作了解
 */
}
