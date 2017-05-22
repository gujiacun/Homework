package com._520it.handler;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.ResultSet;

public class BeanHandler<T> implements IResultSetHandler<T> {
    Class<T> clz;

    public BeanHandler(Class<T> clz){
        this.clz = clz;
    }
    public T handle(ResultSet rs) throws Exception {
        
        if (rs.next()) {
            T t = clz.newInstance();
            BeanInfo beanInfo = Introspector.getBeanInfo(clz, Object.class);
            PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor pd : pds) {
                Object columnName = pd.getName();
                Object value = rs.getObject(columnName.toString());

                Method setMethod = pd.getWriteMethod();
                setMethod.invoke(t, value);
            }
            return t;
        }
        return null;
    }

}
