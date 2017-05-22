package com._520it._02_interceptor;

import org.apache.commons.lang3.ObjectUtils.Null;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import lombok.Setter;
//（1）在interceptor包中建类CheckLoginInterceptor，继承AbstractInterceptor类，重写intecept方法
//由于在LoginAction中已经把符合条件的用户名共享到session，所以在CheckLoginInterceptor中，获取改session中的数据（用object收），
//假如他为空，则返回"login"（送回配置文件中，再送到登陆页面）;不空就放行

//解决硬编码问题，由于这个方法不一定要返回"login"，所以给拦截器传参数
//（1）在struts.xml中为拦截器设值，在<Interceptor>中<param name="loginName">login</param>
//（2）上一步要求为指定的Interceptor中的某属性设置值，而该属性就是loginName，所以在拦截器里写字段，提供set方法
//（3）改intercept方法的返回值为loginName
public class CheckLoginInterceptor extends AbstractInterceptor {
    private static final long serialVersionUID = 1L;
    //在拦截器里写字段，提供set方法,让框架来调用，把拦截其中的参数设置进来
    @Setter
    private String loginName;
    
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        // TODO Auto-generated method stub
        Object user = invocation.getInvocationContext().getSession().get("USER_IN_SESSION");
        //判断session中是否有USER_IN_SESSION
        if (user == null) {
            return loginName;
        } 
        //不是空，表明用户已注册，放行
        return invocation.invoke();
    }

}
