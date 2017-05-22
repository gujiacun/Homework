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
import com._520it.page.PageResult;
import com._520it.query.ProductQueryObject;
import com._520it.query.QueryObject;
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
        req.setCharacterEncoding("UTF-8");
        String cmd = req.getParameter("cmd");
        if ("delete".equals(cmd)) {
            delete(req, resp);
        } else if ("edit".equals(cmd)) {
            edit(req, resp);
        } else if ("saveOrUpdate".equals(cmd)) {
            saveOrUpdate(req, resp);
        } else if ("query".equals(cmd)) {
            query(req, resp);
        } else {
            list(req, resp);
        }
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String id = req.getParameter("id");
        if (StringUtils.hasLength(id)) {
            dao.delete(Long.valueOf(id));
        }
        resp.sendRedirect("/product");
        // resp.sendRedirect("/product");
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

    // localhost/product
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
        } else {
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

    // 在list.jsp页面里实现高级查询(按条件过滤查询)
    // (1)先写后端，建高级查询的方法，用户在界面输入条件参数，通过请求对象获取
    protected void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String minPrice = req.getParameter("minPrice");
        String maxPrice = req.getParameter("maxPrice");
        String type = req.getParameter("type");
        String keywords = req.getParameter("keywords");
        ProductQueryObject qo = new ProductQueryObject();
        // （1.1）把得到的参数封装在参数类的对象中，但要先判断是否为空
        // if (StringUtils.hasLength(name)) {
        // qo.setName(name);
        // }
        qo.setName(name);
        if (StringUtils.hasLength(minPrice)) {
            qo.setMinPrice(new BigDecimal(minPrice));
        }
        if (StringUtils.hasLength(maxPrice)) {
            qo.setMaxPrice(new BigDecimal(maxPrice));
        }
        if (StringUtils.hasLength(type)) {
            qo.setType(Integer.valueOf(type));
        }
        if (StringUtils.hasLength(keywords)) {
            qo.setType(Integer.valueOf(keywords));
        }

        // （2）通过调用IProductDAO的对象，调用高级查询的方法
        List<Product> list = dao.query(qo);
        // （3）由于在按条件查询显示结果时，也要同时显示用户输入的条件，把查询结果(List集合)放到共享作用域，让页面显示相关数据
        // 注意，在高级查询前，查询全部也会产生list集合并在jsp中显示结果，但此时经过高级查询（条件过滤后）,
        // 显示的是高级查询后的list集合结果，把它放在共享作用域并发到jsp页面，显示高级查询后的结果
        req.setAttribute("list", list);
        // 把参数类的对象放在共享作用域并发到jsp页面，用户在输入搜索条件后显示输入过的条件
        req.setAttribute("qo", qo);
        req.getRequestDispatcher("WEB-INF/views/product/list.jsp").forward(req, resp);
    }
        //
       // -----------------------------------------------------------------------
        //建分页查询的方法，用户在页面传入当前页/页面大小，先获取
        protected void list_page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String currentPage = req.getParameter("currentPage");
        String pageSize = req.getParameter("pageSize");
        //由于用户可能不传值，所以先指定默认值，再判断用户是否有传入新值，有就改变默认值
        Integer iCurrentPage = 1;
        Integer iPageSize = 3;
        if (StringUtils.hasLength(currentPage)) {
            iCurrentPage = Integer.valueOf(currentPage);
        }
        if (StringUtils.hasLength(pageSize)) {
            iPageSize = Integer.valueOf(pageSize);
        }
        
        //调用DAO实现类的方法page，把以上两个参数的值传入方法，返回对象
        PageResult result = dao.page(iCurrentPage, iPageSize);
        System.out.println(result);
        //把对象放到作用域
        req.setAttribute("result",result);
        //请求转发
        req.getRequestDispatcher("/WEB-INF/views/product/list.jsp").forward(req, resp);
    }
        
        
        //分页+高级查询
        protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            ProductQueryObject qo = new ProductQueryObject();
            //新建方法,为 qo设置分页+高级查询的参数
            req2object(req, qo);
            //调用分页+高级查询的方法，返回对象
            PageResult result = dao.pageQuery(qo);
            //System.out.println(result);
            //把对象放到作用域
            req.setAttribute("result",result);
            req.setAttribute("qo",qo);
            //请求转发
            req.getRequestDispatcher("/WEB-INF/views/product/list.jsp").forward(req, resp);
        }
        
        private void  req2object(HttpServletRequest req,ProductQueryObject qo) {
            //拿到高级查询的参数
            String name = req.getParameter("name");
            String minPrice = req.getParameter("minPrice");
            String maxPrice = req.getParameter("maxPrice");
            String type = req.getParameter("type");
            String keywords = req.getParameter("keywords");
            // 判断数据是否为空,不空就把数据添加到ProductQueryObject的对象中
            qo.setName(name);
            if (StringUtils.hasLength(minPrice)) {
                qo.setMinPrice(new BigDecimal(minPrice));
            }
            if (StringUtils.hasLength(maxPrice)) {
                qo.setMaxPrice(new BigDecimal(maxPrice));
            }
            if (StringUtils.hasLength(type)) {
                qo.setType(Integer.valueOf(type));
            }
            if (StringUtils.hasLength(keywords)) {
                qo.setType(Integer.valueOf(keywords));
            }
          //分页查询的参数
            String currentPage = req.getParameter("currentPage");
            String pageSize = req.getParameter("pageSize");
            //由于用户可能不传值，所以先指定默认值，再判断用户是否有传入新值，有就改变默认值
            Integer iCurrentPage = 1;
            Integer iPageSize = 3;
            if (StringUtils.hasLength(currentPage)) {
                iCurrentPage = Integer.valueOf(currentPage);
            }
            if (StringUtils.hasLength(pageSize)) {
                iPageSize = Integer.valueOf(pageSize);
            }
            
            //调用DAO实现类的方法page，把以上两个参数的值传入方法，返回对象
            //把数据封装到qo中
            qo.setCurrentPage(iCurrentPage);
            qo.setPageSize(iPageSize);
        }
}
