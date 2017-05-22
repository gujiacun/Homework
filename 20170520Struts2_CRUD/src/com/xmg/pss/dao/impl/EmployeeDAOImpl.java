package com.xmg.pss.dao.impl;

import java.sql.ResultSet;
import java.util.List;

import com.xmg.pss.dao.IEmployeeDAO;
import com.xmg.pss.domain.Employee;
import com.xmg.pss.handler.BeanHandler;
import com.xmg.pss.handler.BeanListHandler;
import com.xmg.pss.handler.IResultSetHandler;
import com.xmg.pss.page.PageResult;
import com.xmg.pss.page.PageResult02;
import com.xmg.pss.query.EmployeeQueryObject02;
import com.xmg.pss.query.EmployeeQueryOnject;
import com.xmg.pss.util.JDBCTemplate;

public class EmployeeDAOImpl implements IEmployeeDAO{
//    IEmployeeDAO dao = new EmployeeDAOImpl();
//    Employee employee = new Employee();
    @Override
    public void save(Employee employee) throws Exception {
        // id
//        username
//        password
//        email
//        salary
//        hiredate
//        headImg
        String sql = "INSERT INTO table_employee VALUES(?,?,?,?,?,?,?)";
        Object[] params = {employee.getId(),employee.getUsername(),employee.getPassword(),employee.getEmail(),employee.getSalary(),employee.getHiredate(),employee.getHeadImg()};
        JDBCTemplate.update(sql,params); 
    }

    @Override
    public void delete(Employee employee) throws Exception {
        // TODO Auto-generated method stub
        String sql = "DELETE FROM table_employee WHERE id=?";
        JDBCTemplate.update(sql,employee.getId()); 
    }

    @Override
    public void update(Employee employee) throws Exception {
        // TODO Auto-generated method stub
        String sql = "UPDATE table_employee SET username=?,password=?,email=?,salary=?,hiredate=?,headImg=? WHERE id=?";
        Object[] params = {employee.getUsername(),employee.getPassword(),employee.getEmail(),employee.getSalary(),employee.getHiredate(),employee.getHeadImg(),employee.getId()};
        JDBCTemplate.update(sql,params); 
        
    }

    @Override
    public Employee get(Long id) throws Exception {
        // TODO Auto-generated method stub
        String sql = "SELECT * FROM table_employee WHERE id=?";
        Object[] params = {id};
        return JDBCTemplate.query(sql,new BeanHandler<Employee>(Employee.class),params);
    }

    @Override
    public List<Employee> list() throws Exception {
        // TODO Auto-generated method stub
        String sql = "SELECT * FROM table_employee";
        //Object[] params = {id};
        //Object[] params = {};
        return JDBCTemplate.query(sql,new BeanListHandler<Employee>(Employee.class));
    }

    @Override
    public PageResult02 pageQuery(EmployeeQueryObject02 qo) throws Exception {
        //EmployeeQueryObject02 qo = new EmployeeQueryObject02();
        // 结果总条数
        //Integer totalcount = null;
        String sql = "SELECT COUNT(*) FROM table_employee "+qo.getConditions();
        List<Object> params = qo.getParams();
        int totalcount = JDBCTemplate.query(sql,new IResultSetHandler<Long>(){
            @Override
            public Long handle(ResultSet rs) throws Exception {
                // TODO Auto-generated method stub
                if (rs.next()) {
                    return rs.getLong(1);
                }
                return null;
            }
        },params.toArray()).intValue();
        //totalcount = query.intValue();
        if (totalcount == 0) {
            return PageResult02.emptyResult;
        }
        //结果集
        String sql02 = "SELECT * FROM table_employee "+qo.getConditions()+" LIMIT ?,? ";
        Integer beginIndex = (qo.getCurrentPage() - 1 )*qo.getPageSize();
        params.add(beginIndex);
        params.add(qo.getPageSize());
        
        List<Employee> listData = JDBCTemplate.query(sql02,new BeanListHandler<Employee>(Employee.class),params.toArray());
        return new PageResult02(listData, totalcount, qo.getCurrentPage(), qo.getPageSize());
    }

    
   
    
//    @Override
//    public PageResult pageQuery(EmployeeQueryOnject qo) throws Exception {
//        String sql = "SELECT COUNT(*) FROM table_employee "+qo.getConditions();
//        //查总计录数
//        List<Object> params = qo.getParams();
//        int totalCount = JDBCTemplate.query(sql, new IResultSetHandler<Long>() {
//            @Override
//            public Long handle(ResultSet rs) throws Exception {
//                // 什么意思
//                if (rs.next()) {
//                    return rs.getLong(1);
//                }
//                return null;
//            }
//            
//        }, params.toArray()).intValue();
//        
//        if (totalCount == 0) {
//            return PageResult.emptyResult;
//        }
//        
//        //查结果集
//        String sql02 = "SELECT * FROM table_employee "+qo.getConditions()+" limit ?,? ";
//        Integer beginIndex = (qo.getCurrentPage() - 1 )*qo.getPageSize();
//        params.add(beginIndex);
//        params.add(qo.getPageSize());
//        List<Employee> listData = JDBCTemplate.query(sql02,new BeanListHandler<Employee>(Employee.class),params.toArray());
//        return new PageResult(listData,totalCount,qo.getPageSize(),qo.getCurrentPage());
//    }
    
    
    

}
