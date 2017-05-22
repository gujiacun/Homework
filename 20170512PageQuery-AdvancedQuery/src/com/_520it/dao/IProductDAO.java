package com._520it.dao;

import java.math.BigDecimal;
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
    
    /**
     * @name 商品名称，用模糊查询
     * @minPrice 商品最低价
     * @maxPrice 商品最高价
     * @return 结果集合
     */
    public List<Product> query(String name,BigDecimal minPrice,BigDecimal maxPrice);
    
    public List<Product> query(ProductQueryObject qo);
    //在DAO接口里建page方法，返回PageResult对象
    public PageResult page(Integer currentPage, Integer pageSize) ;
    
    //执行分页+高级查询的方法:
    public PageResult  pageQuery(ProductQueryObject qo);
}
