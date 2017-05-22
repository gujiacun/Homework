package com._520it.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.tag.common.core.RedirectSupport;

import com._520it.shoppingcart.CartItem;
import com._520it.shoppingcart.Shoppingcart;
import com._520it.utils.StringUtils;

//在service方法里请求分发（拿cmd，根据页面传进来不同的cmd的值去不同方法）
//请求分发后，建list/addItem/deleteItem方法，在addItem方法中拿页面的商品名和数量，封装至商品类的对象里，
//假如商品名与拿到的值对应，手动设置id和价格。通过session拿购物车对象，若没有就新建并放到session中
//把商品添加进购物车，重定向至list.jsp
@WebServlet("/cart")
public class ShoppingcartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 一定要设置请求和相应的编码格式，否则在下面方法中获取由页面输入的值时，会出现乱码，而无法赋值
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String cmd = req.getParameter("cmd");
        if ("deleteItem".equals(cmd)) {
            deleteItem(req, resp);
        }else if ("addItem".equals(cmd)) {
            addItem(req, resp);
        }else {
            list(req, resp);
        }
    }
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        //在addItem方法中拿页面的商品名和数量，封装至商品类的对象里，
        String name = req.getParameter("name");
        String number = req.getParameter("number");
        CartItem newItem = new CartItem();
        if (StringUtils.hasLength(name)) {
            newItem.setName(name);
        }
        if (StringUtils.hasLength(number)) {
            newItem.setNumber(Integer.valueOf(number));
        }else{
            newItem.setNumber(1);
        }
        //假如商品名与拿到的值对应，手动设置id和价格。通过session拿购物车对象，若没有就新建并放到session中
        if ("锤子".equals(name)) {
            newItem.setId(1L);
            newItem.setPrice(2000D);
        }else if ("魅族".equals(name)) {
            newItem.setId(2L);
            newItem.setPrice(3000D);
        }else if ("小米".equals(name)) {
            newItem.setId(3L);
            newItem.setPrice(4000D);
        }
        //通过session拿购物车对象，若没有就新建并放到session中
        Shoppingcart shoppingcart = (Shoppingcart)req.getSession().getAttribute("SHOPPINGCART_IN_SESSION");
        if (shoppingcart == null) {
            shoppingcart = new Shoppingcart();
            req.getSession().setAttribute("SHOPPINGCART_IN_SESSION", shoppingcart);
        }
        //把商品添加进购物车，重定向至list.jsp
        shoppingcart.addItem(newItem);
        resp.sendRedirect("/shoppingCart/list.jsp");
    }
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //拿购物车对象，id，调用Shoppingcart中的deleteItem方法，重定向至list.jsp
        Shoppingcart shoppingcart = (Shoppingcart)req.getSession().getAttribute("SHOPPINGCART_IN_SESSION");
        String id = req.getParameter("id");
        shoppingcart.deleteItem(Long.valueOf(id));
        resp.sendRedirect("/shoppingCart/list.jsp");
    }
/**
 * 小结：     一定要设置请求和相应的编码格式，否则在下面方法中获取由页面输入的值时，会出现乱码，而无法赋值
 */
}
