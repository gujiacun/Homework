package com._520it.dao;

import java.util.List;

import com._520it.domain.Product;

public interface IProductDAO {
    public void save(Product product);

    public void delete(Long id);

    public void update(Product product);

    public Product get(Long id);

    public List<Product> listAll();
}
