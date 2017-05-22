package com._520it.handler;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.ResultSet;


/**
 * 
 * 通用的单行结果集处理器
 * @param <T>   T 跟 IResultSetHandler 一样, 同样的类型
 * 
 * new BeanHandler<Student>
 * 
 */
public class BeanHandler<T> implements IResultSetHandler<T> {
	 //T 的具体类型
	private Class<T> clz;  
	public BeanHandler(Class<T> clz){
		this. clz = clz;
	}
	//将结果集封装成一个  T 类型对象
	@Override
	public T handle(ResultSet resultSet) throws Exception {
		//通过反射创建 T 类型的对象
	    T t = clz.newInstance();
	    if(resultSet.next()){
			//获取到t的javabean 信息描述
			BeanInfo beanInfo = Introspector.getBeanInfo(clz, Object.class);
			//获取t的属性描述器
			PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor pd : pds) {
				//属性名:也是 列名
				Object columnName = pd.getName();
				//通过列名获取结果集里面某个一个列的值
				Object value = resultSet.getObject(columnName.toString()); 
				
				//获取t类型的对象的set 方法
				Method setMethod = pd.getWriteMethod();
				//执行set 方法, 给对象 t 设置 属性(columnName)值
				setMethod.invoke(t, value);
			}
		}
		return t;
	}
}
