package com.xmg.pss.handler;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.ResultSet;

import com.xmg.pss.domain.Employee;

public class BeanHandler<T> implements IResultSetHandler<T> {
    private Class<T> type;

    public BeanHandler(Class<T> type) {
        // TODO Auto-generated constructor stub
        this.type = type;
    }

    @Override
    public T handle(ResultSet rs) throws Exception {
        // TODO Auto-generated method stub
        T t = type.newInstance();
        if (rs.next()) {
            BeanInfo beanInfo = Introspector.getBeanInfo(type, Object.class);
            PropertyDescriptor[] properties = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor propertyDescriptor : properties) {
                String columnName = propertyDescriptor.getName();
                Object value = rs.getObject(columnName);
                Method setWay = propertyDescriptor.getWriteMethod();
                setWay.invoke(t, value);
            }
        }
        return t;
    }

}
