package com._520it._03_valueStack;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com._520it._02_parameter.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import com.sun.jndi.toolkit.url.GenericURLContext;

//需求：一。拿值栈对象
//建类，继承ActionSupport,重写execute方法,在execute方法中有两方法能获取值栈对象
//二。ValueStack内部结构
//1).把数据放入root中
//2).把数据放入context中:
//三。从JSP中取出ValueStack中的数据:
//1).获取root中数据:
//2).把context中数据:
//3).在jsp页面中调试,Struts2的调试标签:<s:debug/> :主要用来观察数据在哪一个空间(root,context).
public class ValueStackAction extends ActionSupport {
    private static final long serialVersionUID = 1L;


    // 方式4.在Action中提供一个可访问的属性(getter方法).
    private String job="idol";
    public String getJob() {
        return job;
    }

    private List list = new ArrayList<>();
    
    
    @Override
    public String execute() throws Exception {
        // 方法一：因为ValueStack在请求中,属性名为:struts.valueStack
        ValueStack valueStack = (ValueStack) ServletActionContext.getRequest().getAttribute("struts.valueStack");
        // 方法二：通过ActionContext对象获取
        ValueStack valueStack2 = ActionContext.getContext().getValueStack();
        // 直接打印两个对象
         System.out.println(valueStack);
         System.out.println(valueStack2);
        // 方式3:ValueStack对象.set(String propertyName,Object value);
        valueStack.set("center", "hirate");
        // 方式1:ValueStack对象.getRoot().add(0, Obejct val);//把数据压入栈顶
        String name = "林则徐诗篇朗诵者";
        valueStack.getRoot().add(0, name);
        // 方式2:ValueStack对象.getRoot().push(Object
        // val):等价于valueStack对象.getRoot().add(0, Obejct val);
        // valueStack.getRoot()valueStack.push();

        list.add(0);
        list.add(1);
        //获取context作用域,然后将集合存到context作用域中
        valueStack.getContext().put("list", list);
        
        System.out.println(list);
        return "SUCCESS";
    }
 
        
      
      
    /*
     * 小结：valueStack值栈，是框架进行共享数据的方法，同过获取值栈的对象，然后进行条用方法将数据存储到作用域中
     * 值栈的存储位置有两个位置，第一个位置是root,它底层是一个栈机制，后进先出的方式,也就是一个arraylist集合
     * ，context作用域是一个map集合，根据两个人的特性选择使用,一般如果是单个对象数据的就直接使用root，
     * 如果是有集合类型的多数量数据封装的就使用context作用域 获取值栈对象 valueStack =
     * ActionContext.getContext().getValueStack();
     * 获取root调用方法valueStack.getrRoot().add();
     * 获取context调用方法valueStack.getContext().put(String key,Object object);
     */
}
