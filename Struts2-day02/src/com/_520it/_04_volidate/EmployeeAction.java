package com._520it._04_volidate;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Validateable;

//在struts2中做登陆校验，在这个类里直接重写validate方法，在方法内编写代码。
public class EmployeeAction extends ActionSupport  {

    private static final long serialVersionUID = 1L;
    // 重写execute方法并提供其他方法，并在struts.xml文件中配置相关action和方法，访问localhost/validate,观察打印结果

    @Override
    public String execute() throws Exception {
        // TODO Auto-generated method stub
        System.out.println("execute");
        return NONE;
    }

    public String update() throws Exception {
        // TODO Auto-generated method stub
        System.out.println("update");
        return NONE;
    }

    public String input() throws Exception {
        // TODO Auto-generated method stub
        System.out.println("input");
        return NONE;
    }

    @Override
    public void validate() {
        // 数据校验
        System.out.println("数据校验");
        //super.validate();
    }
    
    //当只有某个方法需要进行校验时，直接把validate方法拷贝，去掉 @Override标签，在validate名后面加上方法名，首字母改为大写
    public void validateUpdate() {
        // 数据校验
        System.out.println("数据校验");
        //super.validate();
    }
    
    //进行登陆数据校验
    String username;
    String password;
    public void validateLogin() {
        // 数据校验
        if (username == null && password == null) {
            super.addFieldError("username","请重新登录");
        }
        //System.out.println("数据校验");
        //super.validate();
    }
/**
 * 小结：由于在action中执行每个方法之前都会先执行validate方法，可以用它来做登陆校验
 * 
 */
}
