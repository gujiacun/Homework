package com._520it._03_servlet_api;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

//需求：在action中访问servlet的API，调用其方法
//建一个类，继承ActionSupport类，重写execute方法，在方法中通过ActionContext类中的静态方法，得到Servlet相关的Api
public class ServeltAPI03 extends ActionSupport {

    private static final long serialVersionUID = 1L;

    @Override
    public String execute() throws Exception {
        // ActionContext类中的静态方法，得到Servlet相关的Api
        // 拿ActionContext对象
        ActionContext context = ActionContext.getContext();
        // ):获取请求参数.
        // 现在:Map<String,String[]> params = ctx.getParameters();
        Map<String, Object> parameters = context.getParameters();
        // 2):从request中获得某个特定参数的值
        // 现在:ctx.put(String key,Object value); Object val = ctx.get(String
        // name);
        context.get("name");
        // 3):操作session作用域:
        // 现在:Map<String,Object> session = ctx.getSession(); 接下来就是操作Map对象
        Map<String, Object> session = context.getSession();
        // 4):操作servletContext(application)作用域:
        // 现在:Map<String,Object> app = ctx.getApplication();
        Map<String, Object> application = context.getApplication();
        return super.execute();
    }
}
