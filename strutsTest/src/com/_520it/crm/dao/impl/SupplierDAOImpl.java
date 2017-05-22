package com._520it.crm.dao.impl;

import java.sql.ResultSet;
import java.util.List;

import com._520it.crm.dao.ISupplierDAO;
import com._520it.crm.domain.Supplier;
import com._520it.crm.handler.IResultSetHandler;
import com._520it.crm.handler.impl.BeanHandler;
import com._520it.crm.handler.impl.BeanListHandler;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.SupplierQueryObject;
import com._520it.crm.util.JdbcTemplate;

public class SupplierDAOImpl implements ISupplierDAO {
//id
// number
//  name
//     credit
//     city
    @Override
    public void save(Supplier supplier) {
        // TODO Auto-generated method stub
        String sql = "INSERT INTO t_supplier VALUES(?,?,?,?,?)";
        Object[] args = {supplier.getId(),supplier.getNumber(),supplier.getName(),supplier.getCredit(),supplier.getCity()};
        JdbcTemplate.update(sql, args);
    }

    @Override
    public void update(Supplier supplier) {
        // TODO Auto-generated method stub
        String sql = "UPDATE t_supplier SET number=?,name=?,credit=?,city=? WHERE id=? ";
        Object[] args = {supplier.getNumber(),supplier.getName(),supplier.getCredit(),supplier.getCity(),supplier.getId()};
        JdbcTemplate.update(sql, args);
        
        
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        String sql = "DELETE FROM t_supplier WHERE id = ? ";
        Object[] args = {id};
        JdbcTemplate.update(sql, args);
    }
//-----------------------------------------------------------------------------
    @Override
    public Supplier get(Long id) {
        // TODO Auto-generated method stub
        String sql = "SELECT * FROM t_supplier WHERE id = ? ";
        return JdbcTemplate.query(sql,new BeanHandler<Supplier>(Supplier.class), id);
        //return null;
    }

    @Override
    public List<Supplier> list() {
        // TODO Auto-generated method stub
        String sql = "SELECT * FROM t_supplier ";
        return JdbcTemplate.query(sql,new BeanListHandler<Supplier>(Supplier.class));
    }

    @Override
    public PageResult queryByCondition(SupplierQueryObject qo) {
        // 总条数
        List<Object> params = qo.getParams();
        String conditions = qo.getConditions();
        String sql = "SELECT COUNT(*) FROM t_supplier "+conditions;
        int totalcount = JdbcTemplate.query(sql, new IResultSetHandler<Long>() {
            @Override
            public Long handle(ResultSet rs) throws Exception {
                // TODO Auto-generated method stub
                if (rs.next()) {
                    return rs.getLong(1);
                }
                return null;
            }
        }, params.toArray()).intValue();
        // 结果集
        String sql02 = "SELECT * FROM t_supplier "+conditions+" LIMIT ?,? ";
        Integer beginIndex = (qo.getCurrentPage() - 1 )*qo.getPageSize();
        params.add(beginIndex);
        params.add(qo.getPageSize());
        
        List<Supplier> listData = JdbcTemplate.query(sql02,new BeanListHandler<Supplier>(Supplier.class),params.toArray());
        
        
        return new PageResult(listData, totalcount, qo.getPageSize(), qo.getCurrentPage());
    }

}
