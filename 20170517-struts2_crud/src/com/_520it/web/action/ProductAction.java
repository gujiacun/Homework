package com._520it.web.action;

import java.util.ArrayList;
import java.util.List;

import com._520it.dao.IProductDAO;
import com._520it.dao.impl.ProductDAOImpl;
import com._520it.domain.Product;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import lombok.Getter;

public class ProductAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    @Getter
    private Product item = new Product();
    IProductDAO dao = new ProductDAOImpl();

    @Override
    public String execute() throws Exception {
        // TODO Auto-generated method stub
        List<Product> list = dao.listAll();
        // 添加到值域的context中
        ActionContext.getContext().put("list", list);

        return "list";
    }

    @Override
    public String input() throws Exception {
        if (item.getId() != null) {
            item = dao.get(item.getId());
        }
        return INPUT;
    }

    public String saveOrUpdate() {
        dao.save(item);
        if (item.getId() != null) {
            dao.update(item);
        } else {
            dao.save(item);
        }
        return SUCCESS;
    }
    public String delete(){
        dao.delete(item.getId());
        return SUCCESS;
    }
}
