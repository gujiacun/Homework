package com._520it.handler;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.util.List;

public class BeanHandler<T> implements IResultSetHandler<T> {
    Class<T> clz;

    public BeanHandler(Class<T> clz){
        this.clz = clz;
    }
    public T handle(ResultSet rs) throws Exception {
        T t = clz.newInstance();
        if (rs.next()) {
            BeanInfo beanInfo = Introspector.getBeanInfo(clz, Object.class);
            PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor pd : pds) {
                Object columnName = pd.getName();
                Object value = rs.getObject(columnName.toString());

                Method setMethod = pd.getWriteMethod();
                setMethod.invoke(t, value);
            }
        }
        return t;
    }

}
