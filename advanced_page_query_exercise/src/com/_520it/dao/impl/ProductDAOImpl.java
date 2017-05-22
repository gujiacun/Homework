package com._520it.dao.impl;

import java.util.List;

import com._520it.dao.IProductDAO;
import com._520it.domain.Product;
import com._520it.handler.BeanHandler;
import com._520it.handler.BeanListHandler;
import com._520it.page.PageResult;
import com._520it.query.ProductQueryObject;
import com._520it.utils.JdbcTempate;

public class ProductDAOImpl implements IProductDAO{

    @Override
    public void save(Product product) {
        // TODO Auto-generated method stub
        String sql="INSERT INTO t_item(name,price,stockNum) VALUES(?,?,?)";
        Object[] params = {product.getName(),product.getPrice(),product.getStockNum()};
        JdbcTempate.update(sql,params);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        String sql="DELETE FROM t_item WHERE id=?";
        Object[] params = {id};
        JdbcTempate.update(sql,params);
    }

    @Override
    public void update(Product product) {
        // TODO Auto-generated method stub
        String sql="UPDATE t_item SET name=?,price=?,stockNum=? WHERE id=?";
        Object[] params = {product.getName(),product.getPrice(),product.getStockNum(),product.getId()};
        JdbcTempate.update(sql,params);
    }

    @Override
    public Product get(Long id) {
        // TODO Auto-generated method stub
        String sql="SELECT id,name,price,stockNum FROM t_item WHERE id=?";
        Object[] params = {id};
        return JdbcTempate.query(sql,new BeanHandler<Product>(Product.class),params);
    }

    @Override
    public List<Product> listAll() {
        // TODO Auto-generated method stub
        String sql="SELECT id,name,price,stockNum FROM t_item";
        Object[] params = {};
        JdbcTempate.query(sql,new BeanListHandler<Product>(Product.class),params);
        return JdbcTempate.query(sql,new BeanListHandler<Product>(Product.class),params);
    }

    
  //高级查询+分页查询
    @Override
    public PageResult pageQuery(ProductQueryObject qo) {
        // TODO Auto-generated method stub
        return null;
    }

}
