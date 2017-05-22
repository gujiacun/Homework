package com._520it._03_servlet_api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

//需求：在action中访问servlet的API，调用其方法
//建一个类，继承ActionSupport类，重写execute方法，在方法中通过ServletActionContext类中的静态方法，得到Servlet相关的Api
public class ServletAPI02 extends ActionSupport {
    private static final long serialVersionUID = 1L;

    @Override
    public String execute() throws Exception {
        // 通过ServletActionContext类中的静态方法，得到Servlet相关的Api
        //那请求对象
        HttpServletRequest request = ServletActionContext.getRequest();
        //拿响应对象
        HttpServletResponse response = ServletActionContext.getResponse();
        //拿session
        HttpSession session = ServletActionContext.getRequest().getSession();
        Object attribute = session.getAttribute("name");
        return super.execute();
    }
/**
 * 小结：依然Action与ServletAPI有耦合
 */
}
