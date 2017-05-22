package com._520it.dao.impl;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com._520it.dao.IProductDAO;
import com._520it.domain.Product;
import com._520it.handler.BeanHandler;
import com._520it.handler.BeanListHandler;
import com._520it.handler.IResultSetHandler;
import com._520it.page.PageResult;
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
        // String sql = "SELECT id,name,price,stockNum,type,brand FROM t_item";
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
    public List<Product> query(ProductQueryObject qo) {
        String sql = "SELECT * FROM t_item " + qo.getCondition();

        // 调用模板类的query方法
        return JdbcTempate.query(sql.toString(), new BeanListHandler<Product>(Product.class), qo.getParams().toArray());
    }

    @Override
    public List<Product> query(String name, BigDecimal minPrice, BigDecimal maxPrice) {
        // TODO Auto-generated method stub
        return null;
    }

    // 在实现类重写方法，返回PageResult对象
    @Override
    public PageResult page(Integer currentPage, Integer pageSize) {
        // 由于PageResult的构造方法中，参数listData, totalCount是空缺的，所以下面要得到这两个数据
        // 都是查询，所以分页查询方法调用模板类中的query方法
        // listData，结果集数据,先写sql语句
        // 第一个问号:当前页中的第一条数据的索引beginIndex=(currentPage-1)*pageSize
        // 第二个问号:pageSize,指定一次查询多少数据

        String sql = "SELECT * FROM t_item LIMIT ?,?";
        // sql语句有两个空缺，开始索引和每页条数，补
        Integer beginIndex = (currentPage - 1) * pageSize;
        List<Product> listData = JdbcTempate.query(sql, new BeanListHandler<>(Product.class), beginIndex, pageSize);
        // totalCount，总条数
        String sql02 = "SELECT COUNT(*) FROM t_item";
        int totalCount = JdbcTempate.query(sql02, new IResultSetHandler<Long>() {

            @Override
            public Long handle(ResultSet rs) throws Exception {
                if (rs.next()) {
                    return rs.getLong(1);
                }
                return null;
            }
        }).intValue();
        // 需要的参数为List listData, Integer totalCount, Integer currentPage, Integer
        // pageSize
        // 当前页和页面大小有用户传，不管;上面补前面那两个需要查询得到的
        return new PageResult(listData, totalCount, currentPage, pageSize);
    }

    @Override
    public PageResult pageQuery(ProductQueryObject qo) {
        // 先拿高级查询的条件(通过ItemQueryObject qo的getCondition方法)
        String conditions = qo.getCondition();
        // <2>查询总记录数，拼接sql语句，调用模板类的query方法时传入高级查询的参数，toArray + intValue
        String sql = "SELECT COUNT(*) FROM t_item " + conditions;
        List<Object> params = qo.getParams();
        int totalCount = JdbcTempate.query(sql, new IResultSetHandler<Long>() {
            @Override
            public Long handle(ResultSet rs) throws Exception {
                if (rs.next()) {
                    return rs.getLong(1);
                }
                return null;
            }
        }, params.toArray()).intValue();

        if (totalCount == 0) {
            return PageResult.emptyResult;
        }

        // <1>查询对应的结果集数据，拼接sql语句，计算开始索引，合并高级查询和分页的参数（先把高级查询的参数装到list集合，再把分页的参数加到list集合中，调用模板类的query方法返回listData），
        String sql02 = "SELECT * FROM t_item " + conditions + " LIMIT ?,?";
        Integer beginIndex = (qo.getCurrentPage() - 1) * qo.getPageSize();
        params.add(beginIndex);
        params.add(qo.getPageSize());
        System.out.println(sql02);
        List<Product> listData = JdbcTempate.query(sql02, new BeanListHandler<>(Product.class), params.toArray());

        // 由于currentPage,pageSize已经被封装到QueryObject中，所以通过其对象拿
        return new PageResult(listData, totalCount, qo.getCurrentPage(), qo.getPageSize());
    }

}
