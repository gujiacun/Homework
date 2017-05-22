package com._520it.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import com._520it.dao.IProductDAO;
import com._520it.dao.impl.ProductDAOImpl;
import com._520it.domain.Product;
import com._520it.query.ProductQueryObject;

public class ProductDAOTest {
    IProductDAO productDAO = new ProductDAOImpl();
    Product product = new Product();

    @Test
    public void testSave() throws Exception {
        product.setName("无敌鼠标");
        product.setPrice(new BigDecimal(666));
        product.setStockNum(new BigDecimal(20));
        productDAO.save(product);
    }

    @Test
    public void testDelete() throws Exception {
        productDAO.delete(11L);
    }

    @Test
    public void testUpdate() throws Exception {
        product.setName("键盘");
        product.setPrice(new BigDecimal(666));
        product.setStockNum(new BigDecimal(20));
        product.setId(8L);
        productDAO.update(product);
    }

    @Test
    public void testGet() throws Exception {
        Product pro = productDAO.get(9L);
        System.out.println(pro);
    }

    @Test
    public void testListAll() throws Exception {
        List<Product> employees = productDAO.listAll();
        System.out.println(employees);
    }
    // 
    @Test
    public void testQuery() throws Exception {
        ProductQueryObject qo = new ProductQueryObject();
        qo.setName("键盘");
        //qo.setMinPrice(new BigDecimal(20));
        //qo.setMaxPrice(new BigDecimal(1000));
        qo.setKeywords("雷蛇");
        List<Product> list = productDAO.query(qo);
        for (Product product : list) {
            System.out.println(product);
        }
    }
}
