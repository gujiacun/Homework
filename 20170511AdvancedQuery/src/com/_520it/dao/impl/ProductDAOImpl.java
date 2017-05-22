package com._520it.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com._520it.dao.IProductDAO;
import com._520it.domain.Product;
import com._520it.handler.BeanHandler;
import com._520it.handler.BeanListHandler;
import com._520it.query.ProductQueryObject;
import com._520it.utils.JdbcTempate;
import com._520it.utils.StringUtils;

public class ProductDAOImpl implements IProductDAO {

    @Override
    public void save(Product product) {
        // TODO Auto-generated method stub
        String sql = "INSERT INTO t_item(name,price,stockNum) VALUES(?,?,?)";
        Object[] params = { product.getName(), product.getPrice(), product.getStockNum() };
        JdbcTempate.update(sql, params);
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        String sql = "DELETE FROM t_item WHERE id=?";
        Object[] params = { id };
        JdbcTempate.update(sql, params);
    }

    @Override
    public void update(Product product) {
        // TODO Auto-generated method stub
        String sql = "UPDATE t_item SET name=?,price=?,stockNum=? WHERE id=?";
        Object[] params = { product.getName(), product.getPrice(), product.getStockNum(), product.getId() };
        JdbcTempate.update(sql, params);
    }

    @Override
    public Product get(Long id) {
        // TODO Auto-generated method stub
        String sql = "SELECT id,name,price,stockNum FROM t_item WHERE id=?";
        Object[] params = { id };
        return JdbcTempate.query(sql, new BeanHandler<Product>(Product.class), params);
    }

    @Override
    public List<Product> listAll() {
        // TODO Auto-generated method stub
//        String sql = "SELECT id,name,price,stockNum,type,brand FROM t_item";
        String sql = "SELECT * FROM t_item";
        Object[] params = {};
        JdbcTempate.query(sql, new BeanListHandler<Product>(Product.class), params);
        return JdbcTempate.query(sql, new BeanListHandler<Product>(Product.class), params);
    }

    // 需求：在页面根据商品名称，价格范围进行高级查询
    // （1）在IProductDAO设计高级查询方法
    // （2）在其实现类中重写该方法，实现高级查询操作
    // （3）在测试类中测试方法，拿结果并打印
    // 由于参数可能会过多，所以把参数封装为一个对象，IProductDAO和其实现类做相应改变
    // 由于实现类中的其他方法都没有拼接sql语句的内容，所以这里的这部分移到上步的参数类里面，即在参数类里面提供一个返回sql语句的方法。
    // 而在实现类的query方法里只需调用这个方法即可得到sql语句,注意由于在参数类里,所以直接使用里面的参数
    // 由于现在的参数集合已经与参数类捆绑在一起，所以在参数里里也建方法返回参数集合
    public List<Product> query(ProductQueryObject qo){
    String sql = "SELECT * FROM t_item "+qo.getCondition();
    
        // 调用模板类的query方法
        return JdbcTempate.query(sql.toString(), new BeanListHandler<Product>(Product.class), qo.getParams().toArray());
    }

    @Override
    public List<Product> query(String name, BigDecimal minPrice, BigDecimal maxPrice) {
        // TODO Auto-generated method stub
        return null;
    }

}
