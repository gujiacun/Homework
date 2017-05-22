package com._520it.dao;

import java.util.List;

import com._520it.domain.Product;
import com._520it.page.PageResult;
import com._520it.query.ProductQueryObject;

public interface IProductDAO {
    public void save(Product product);

    public void delete(Long id);

    public void update(Product product);

    public Product get(Long id);

    public List<Product> listAll();
    //高级查询+分页查询
    public PageResult pageQuery(ProductQueryObject qo);
}
