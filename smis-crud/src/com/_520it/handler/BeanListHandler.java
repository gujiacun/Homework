package com._520it.handler;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 通用的多行结果集处理器
 * @param <T>
 * 
 * NEW  BeanListHandler<Student>
 */
public class BeanListHandler<T> implements IResultSetHandler<   List<T>   > {
	private Class<T> clz;
	public BeanListHandler(Class<T> clz){
		this.clz = clz;
	}
	
	@Override
	public  List<T>   handle(ResultSet resultSet) throws Exception {
		List<T> list = new ArrayList<>(); 
		while(resultSet.next()){
			//通过反射创建 T 类型的对象
			T t = clz.newInstance();
			BeanInfo beanInfo = Introspector.getBeanInfo(clz, Object.class);
			PropertyDescriptor[] pds= beanInfo.getPropertyDescriptors();
	
			//仅仅给 t 对象赋值
			for (PropertyDescriptor pd : pds) {
				String columnName = pd.getName();
				Object columValue = resultSet.getObject(columnName);
				pd.getWriteMethod().invoke(t, columValue);
			}
			list.add(t);
		}
		return list;
	}

}
