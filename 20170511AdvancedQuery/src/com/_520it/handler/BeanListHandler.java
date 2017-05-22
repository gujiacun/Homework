package com._520it.handler;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BeanListHandler<T> implements IResultSetHandler<List<T>>{
    Class<T> clz;
    public BeanListHandler(Class<T> clz){
        this.clz=clz;
    }
    @Override
    public List<T> handle(ResultSet rs) throws Exception {
        List<T> list = new ArrayList<>();
        BeanInfo beanInfo = Introspector.getBeanInfo(clz, Object.class);
        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
        while (rs.next()) {
            T t = clz.newInstance();
            //beanInfo = Introspector.getBeanInfo(clz, Object.class);
            for (PropertyDescriptor pd : pds) {
                Object columnName = pd.getName();
                Object value = rs.getObject(columnName.toString());
                Method setMethod = pd.getWriteMethod();
                setMethod.invoke(t, value);
            }
            list.add(t);
        }
        return list;
        
    }
}
