// 需求：研究HttpServletRequest中的与获取网页表单请求参数常用方法
//（1）先创建一个网页表单html，模拟用户注册，放在webapp/下面
//（2）建RegisterServlet类，由于是处理来自服务器的请求和响应，所以继承HttpServletRequest类，重写service方法
//（3）由于是在注册页面点击注册按钮就跳转到servlet的页面，同时获取表单的参数，所以在html文件的action属性填
//能跳到servlet页面的路径，/pss/regist。
//（4）在servlet程序中写方法获取表单请求参数，注意这些参数要在html文件的"name"的值中选择
//(5)在浏览器的注册页面填入用户名和密码，按下按钮，页面跳转到/pss/regist，然后观察java中的servlet页面的输出
package com._520it._04_register;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
//  获取表单请求参数(重要)
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//  01.String getParameter(String name):返回指定名字参数的值。
        //System.out.println("too young,too simple");
        //System.out.println(req.getParameter("password"));
//  02.String[] getParameterValues(String name):返回指定名字参数的多个参数值。
        String[] parameterValues = req.getParameterValues("hobby");
        //System.out.println(Arrays.toString(parameterValues));
//  03.Enumeration<String> getParameterNames():返回所有参数名的Enumeration对象。
        Enumeration<String> parameterNames = req.getParameterNames();
//        while (parameterNames.hasMoreElements()) {
//            String parameter = (String) parameterNames.nextElement();
//            System.out.println(parameter);
//        }
//  04.Map<String,String[]> getParameterMap():返回所有的参数和值所组成的Map对象。
        Map<String,String[]> parameterMap = req.getParameterMap();
        //迭代Map集合，先把Map集合的对象用entrySet方法返回Set集合,注意Set<>的指定泛型是Entry<X,Y>,因为它返回的是内部类
        Set<Entry<String, String[]>> entrySet = parameterMap.entrySet();
        //用Set集合对象for-e循环，在每个元素用getKey，getValue方法，再输出
        for (Entry<String, String[]> entry : entrySet) {
            String key = entry.getKey();
            String[] value = entry.getValue();
            System.out.println(key+"------"+Arrays.toString(value));
        }
    }
/**
 * 小结：//（1）由于是在注册页面点击注册按钮就跳转到servlet的页面，同时获取表单的参数，所以在html文件的action属性填
//能跳到servlet页面的路径，/pss/regist。
//（2）在servlet程序中写方法获取表单请求参数，注意这些参数要在html文件的"name"的值中选择
 */
}
