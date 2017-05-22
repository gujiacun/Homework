package com._520it.crm.dao;

import java.util.List;

import com._520it.crm.domain.Supplier;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.SupplierQueryObject;

public interface ISupplierDAO {
	
	/**
	 * 添加供应商信息
	 * @param supplier
	 */
	public void save(Supplier supplier);
	
	/**
	 * 根据id来修改供应商
	 * @param supplier
	 */
	public void update(Supplier supplier);
	
	/**
	 * 根据id来删除供应商信息
	 * @param id 
	 */
	public void delete(Long id);
	
	/**
	 * 根据id来查找供应商信息
	 * @param id 
	 * @return 如果找到，返回supplier对象，否则返回null
	 */
	public Supplier get(Long id);
	
	
	/**
	 * 直接返回所有的供应商信息
	 * @return
	 */
	public List<Supplier> list();
	
	/**
	 * 分页查询
	 * @return
	 */
	public PageResult  queryByCondition(SupplierQueryObject qo);

}
