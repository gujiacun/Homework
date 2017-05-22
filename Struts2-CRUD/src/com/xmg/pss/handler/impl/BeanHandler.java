package com.xmg.pss.handler.impl;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;

import com.xmg.pss.handler.IResultSetHandler;

public class BeanHandler<T> implements IResultSetHandler<T> {
	private Class<T> type;

	public BeanHandler(Class<T> type) {
		this.type = type;
	}

	@Override
	public T handler(ResultSet rs) throws Exception {
		//将结果集中的数据取出来封装到type类型的对象中,返回
		T obj= null;
		if (rs.next()) {
			obj = type.newInstance();
			BeanInfo info = Introspector.getBeanInfo(type,Object.class);
			PropertyDescriptor[] pds = info.getPropertyDescriptors();
			for (PropertyDescriptor pd : pds) {
				//获取属性名,作为列名去结果集中取数据
				String columnName = pd.getName();
				Object value = rs.getObject(columnName);
				//将取到的数据设置给对象中对应的属性
				pd.getWriteMethod().invoke(obj, value);
			}
		}
		return obj;
	}

}
