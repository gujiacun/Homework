package com._520it.crm.handler.impl;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;

import com._520it.crm.handler.IResultSetHandler;

 
public class BeanHandler<T> implements IResultSetHandler<T> {
	private Class<T> clz; 

	public BeanHandler(Class<T> clz) {
		super();
		this.clz = clz;
	}

	public T handle(ResultSet rs) throws Exception {
		T obj = null;
		if (rs.next()) {
			obj = clz.newInstance();
			PropertyDescriptor[] pds = Introspector
					.getBeanInfo(clz, Object.class).getPropertyDescriptors();
			for (PropertyDescriptor pd : pds) {
				String name = pd.getName(); 
				Object value = rs.getObject(name);
				pd.getWriteMethod().invoke(obj, value);
			}
		}
		return obj;
	}
}
