package com.xmg.pss.handler;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class BeanListHandler<T> implements IResultSetHandler<List<T>> {
private Class<T> type;
    public BeanListHandler(Class<T> type) {
        // TODO Auto-generated constructor stub
        this.type = type;
    }

    @Override
    public List<T> handle(ResultSet rs) throws Exception {
        T t = null;
        List<T> list = new ArrayList<>();
        while (rs.next()) {
            t= type.newInstance();
            BeanInfo beanInfo = Introspector.getBeanInfo(type, Object.class);
            PropertyDescriptor[] properties = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor propertyDescriptor : properties) {
                String columnName = propertyDescriptor.getName();
                Object value = rs.getObject(columnName);
                Method setWay = propertyDescriptor.getWriteMethod();
                setWay.invoke(t, value);
            }
            list.add(t);
            
        }
        return list;
    }

}
