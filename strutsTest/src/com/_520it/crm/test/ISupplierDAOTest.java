package com._520it.crm.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com._520it.crm.dao.ISupplierDAO;
import com._520it.crm.dao.impl.SupplierDAOImpl;
import com._520it.crm.domain.Supplier;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.SupplierQueryObject;

public class ISupplierDAOTest {
    Supplier s = new Supplier();
    ISupplierDAO dao = new SupplierDAOImpl();
    //Long id, String number, String name, Integer credit, String city
    @Test
    public void testSave() throws Exception {
        Supplier supplier = new Supplier(1013L,"01000","测试01000",69,"东京");
        dao.save(supplier);
    }

    @Test
    public void testDelete() throws Exception {
        dao.delete(1013L);
    }
    @Test
    public void testUpdate() throws Exception {
        s.setId(22L);
        s.setNumber("009");
        s.setName("测试009");
        s.setCredit(19);
        s.setCity("广州");
        dao.update(s);
    }


    @Test
    public void testGet() throws Exception {
        Supplier supplier02 = dao.get(22L);
        System.out.println(supplier02);
    }

    @Test
    public void testList() throws Exception {
        List<Supplier> list = dao.list();
        for (Supplier supplier : list) {
            System.out.println(supplier);
        }
    }

    @Test
    public void testQueryByCondition() throws Exception {
        SupplierQueryObject qo = new SupplierQueryObject();
        qo.setMinCredit(90);
        qo.setCurrentPage(2);
        qo.setPageSize(2);
        PageResult queryByCondition = dao.queryByCondition(qo);
        System.out.println(queryByCondition);
    }
}
