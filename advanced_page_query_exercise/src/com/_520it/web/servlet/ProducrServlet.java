package com._520it.web.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com._520it.dao.IProductDAO;
import com._520it.dao.impl.ProductDAOImpl;
import com._520it.domain.Product;
import com._520it.utils.StringUtils;

@WebServlet("/product")
public class ProducrServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    IProductDAO dao;

    @Override
    public void init() throws ServletException {
        dao = new ProductDAOImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        req.setCharacterEncoding("UTF-8");
        String cmd = req.getParameter("cmd");
        if ("delete".equals(cmd)) {
            delete(req, resp);
        } else if ("edit".equals(cmd)) {
            edit(req, resp);
        } else if ("saveOrUpdate".equals(cmd)) {
            saveOrUpdate(req, resp);
        } else {
            listAll(req, resp);
        }
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String id = req.getParameter("id");
        if (StringUtils.hasLength(id)) {
            dao.delete(Long.valueOf(id));
        }
        resp.sendRedirect("/product");
        //resp.sendRedirect("/product");
    }

    protected void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String id = req.getParameter("id");
        if (StringUtils.hasLength(id)) {
            Product product = dao.get(Long.valueOf(id));
            req.setAttribute("product", product);
        }
        req.getRequestDispatcher("/WEB-INF/views/product/edit.jsp").forward(req, resp);
    }
//localhost/product
    protected void saveOrUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String price = req.getParameter("price");
        String stockNum = req.getParameter("stockNum");
        Product product = new Product();
        product.setName(name);
        product.setPrice(new BigDecimal(price));
        product.setStockNum(new BigDecimal(stockNum));
        if (StringUtils.hasLength(id)) {
            product.setId(Long.valueOf(id));
            dao.update(product);
        }else{
            dao.save(product);
        }
        resp.sendRedirect("/product");
    }

    protected void listAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        List<Product> list = dao.listAll();
        req.setAttribute("list", list);
        req.getRequestDispatcher("/WEB-INF/views/product/list.jsp").forward(req, resp);
    }
}
