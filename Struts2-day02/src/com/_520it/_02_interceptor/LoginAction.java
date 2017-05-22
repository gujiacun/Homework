package com._520it._02_interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import lombok.Setter;

//需求：利用拦截器进行登录校验，
//（1）在WebContext文件夹建login.jsp,用Struts2标签写登陆页面，其中表单的action填login
//（2）建LogicAction类，先在struts.xml中配置相关数据，写action 中name=login  而 class填LogicAction类的全限定名
//（3）在LogicAction类中，建用户名和密码这两个与jsp对应的字段，提供set方法，由于要验证登陆身份，所以在execute方法中判断用户名和密码
//是否与设定值相同，若相同就返回SUCCESS（跳到欢迎页面welcome.jsp），否则返回LOGIN（然后返回到登陆页面）
//问题：但是现在如果直接访问http://localhost/main也可以看到，我要让用户在未登陆时访问这个页面能自动跳转回登陆页面
//解决：（1）在interceptor包中建类CheckLoginInterceptor，继承AbstractInterceptor类，重写intecept方法
//由于在LoginAction中已经把符合条件的用户名共享到session，所以在CheckLoginInterceptor中，获取改session中的数据（用object收），
//假如他为空，则返回"login"（送回配置文件中，再送到登陆页面）;不空就放行
//（2）在struts.xml的<package>中注册自定义拦截器，在<action>中引用拦截器，由于我们只禁止用户登陆前访问http://localhost/main
//所以只在那个action'中加
//问题：如果有多个action,就要重复配置，而且为了防止无法接收参数（即影响默认的拦截器栈）所以
//在struts.xml中定义自己的拦截器栈，包含自己写的和默认的；在package中引用，在不使用自定义的拦截器的action中，引用默认拦截器覆盖自己的拦截器栈
@Setter
public class LoginAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private String username;
    private String password;

    @Override
    public String execute() throws Exception {
        // TODO Auto-generated method stub
        if ("hirate".equals(username)&&"center".equals(password)) {
            ActionContext.getContext().getSession().put("USER_IN_SESSION", username);
            return SUCCESS;
        }
        return LOGIN;
    }
    /**
     * 小结：注意，以后的页面跳转都由配置文件struts.xml来做，其它类或jsp给他返回一个String，然后在struts.xml中定义result
     * 流程：用户在jsp页面中输入数据后按登录按钮，然后带着数据和login跳去struts.xml中，在配置文件中找到叫login的action并到那里去，
     * 由于在action中提供了与登陆页面jsp相同的数据的名字和set方法，在execute方法中根据是否与身份验证相同而返回不同的值
     * 若登陆成功返回SUCCESS，并在struts.xml的叫login的action中定义一个没有name的<result>，跳到main这个action中
     * 直接在配置文件中定义一个叫main的action，跳转到welcome.jsp；
     * 若登录失败，返回LOGIN，在struts.xml中写result,它的name为login，跳回登陆页面
     * 由于要在欢迎页面显示登录后的名字，所以在LoginAction中要把username放进session中，而在欢迎页面中从session中取出
     */
}
