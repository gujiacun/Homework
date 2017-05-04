//需求：建一个在线四则运算计算器，输入两个数字和选择运算符后得到结果
//（1）建html文件，第一个和第三个框表示输入的数字，第二个框表示运算符，是单选下拉框，第四个框表示结果,等于按钮点击后会出现结果，会跳转到CalcServlet
//（2）建类（本类），继承HttpServlet类，重写service方法，设置请求的编码格式，响应的编码格式和内容类型
//（3）用HttpServletRequest的对象获取第一/二个参数和运算符，新建方法判断两个参数是否为空，否就把它们转换为double类型，在判断运算符是哪一个（if），再进行运算，得到结果
//（4）用响应流把html文件中的<form>标签里面的所有语句都用write方法输出，并拼接上上一步得出的结果和两个参数
package com._520it._06_calc;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//继承HttpServlet类
public class CalcServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    // 重写service方法，由于是网页的请求和响应，选择处理HttpServletRequest和HttpServletResponse的那个
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求的编码格式，
        req.setCharacterEncoding("UTF-8");
        // 响应的编码格式和内容类型,由于这里已经设置响应类型为html文件，所以下面输出时只需要输出<form>标签内的语句即可
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        // 用HttpServletRequest的对象获取第一/二个参数和运算符
        String num01 = req.getParameter("number01");
        String num02 = req.getParameter("number02");
        String operator = req.getParameter("operator");
        // 定义结果
        String result = "";
        // 判断两个数值是否为空，非空再进行下一步的转化格式，判断运算符类型及算术运算
        if (hasLength(num01) && hasLength(num02)) {
            // 把两个参数转为double类型
            double number01 = Double.valueOf(num01);
            double number02 = Double.valueOf(num02);
            // 由于这里只涉及四种运算符，判断它们用if-else if
            if ("+".equals(operator)) {
                result = number01 + number02 + "";
            } else if ("-".equals(operator)) {
                result = number01 - number02 + "";
            } else if ("*".equals(operator)) {
                result = number01 * number02 + "";
            } else if ("/".equals(operator)) {
                result = number01 / number02 + "";
            }
            // 如果有其中一个为空，把三个数字框都设为""
        } else {
            num01 = "";
            num02 = "";
            result = "";
        }
        // 拿响应流
        PrintWriter writer = resp.getWriter();
        // 用响应流把html文件中的<form>标签里面的所有语句都用write方法输出
        writer.write(" <form action='/pss/calc' method='post'>");
        writer.write(" <input type='text' name='number01' value='" + num01 + "'/> ");
        writer.write(" <select name='operator'>");
        writer.write("<option>+</option>");
        writer.write("<option>-</option>");
        writer.write("<option>*</option>");
        writer.write(" <option>/</option>");
        writer.write("</select> ");
        writer.write("<input type='text' name='number02' value='" + num02 + "'/> ");
        writer.write(" <input type='submit' name='button' /> ");
        writer.write("<input type='text' name='result' value='" + result + "'/> ");
        writer.write("</form>");
        //注意:<option>+</option>之间不能加value=
    }
    //判断字符串是否为空，不等于null，里面内容也不是""
    public boolean hasLength(String string) {
        return string != null && !"".equals(string);
    }
/**
 * 小结：最重要的内容是创建一个servlet程序和servlet的执行流程，一定要弄清楚
 * 
 */
}
