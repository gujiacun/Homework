package com._520it._02_parameter;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

//需求：在Action中拿参数
//方法一：Action本身作为Model对象，通过setter方法封装(属性注入).
//把action当作model对象，把jsp页面中的数据及其set方法都放在里面
//方法二：创建独立Model对象，页面通过ognl表达式语法来封装对象.
//新建User类，里面放jsp页面中的数据及其方法；在action中声明该类的对象并提供对应的set/get方法，直接打印对象，在jsp中属性改为对象.属性
//方法三：使用ModelDriven接口，对请求数据进行封装.
//在action实现ModelDriven接口，泛型指定为User类，JSP:表单和方式1一样；action新建User类对象，重写getModel方法，返回User类对象

public class UserAction extends ActionSupport implements ModelDriven<User>{
    private static final long serialVersionUID = 1L;
    //private String username;
    //private Integer age;
//方法一
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
  //方法二
//    private User user;
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
    //方法三
    User user = new User();
    @Override
    public User getModel() {
        // TODO Auto-generated method stub
        return user;
    }
    @Override
    public String execute() throws Exception {
        // TODO Auto-generated method stub
//        System.out.println(username);
//        System.out.println(age);
        System.out.println(user);
        return NONE;
    }
/**
 * 小结：方法一相当于servlet中的req.getParamter(),只是这里要提供set方法，而且属性名要和jsp页面中的属性名称一致
 * 方法二中，注意register.jsp的 
 * 账号：<input type="text" name="user.username">   中的  user 要与   UserAction  中的private User user一致
 */

}
