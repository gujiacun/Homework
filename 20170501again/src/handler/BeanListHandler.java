package handler;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BeanListHandler<T> implements IResultSetHandler<List<T>> {
    private Class<T> clz;

    public BeanListHandler(Class<T> clz) {
        // 在创建对象时，传入DAO的字节码对象
        this.clz = clz;
    }

    // 本质是把从表中的搜索结果集的数据赋值给domain类的一个对象,再把所有对象塞到list集合里面，返回集合
    @Override
    public List<T> handle(ResultSet rs) throws Exception {
        List<T> list = new ArrayList<>();
        // 通过反射建T类型的对象
        T t = clz.newInstance();
        // if判断结果集对象.next(),里面用Introspector拿clz的beaninfo对象，再拿所有属性数组
        if (rs.next()) {
            BeanInfo beanInfo = Introspector.getBeanInfo(clz, Object.class);
            PropertyDescriptor[] array = beanInfo.getPropertyDescriptors();
            // 用for-e循环(所有属性数组)，用object和getName拿列名，
            for (PropertyDescriptor propertyDescriptor : array) {
                Object columnName = propertyDescriptor.getName();
                // 通过列名拿结果集里某列的值rs.getObject(columnName.toString)，
                Object value = rs.getObject(columnName.toString());
                // 拿属性的set方法对象，以方法对象invoke
                Method setWay = propertyDescriptor.getWriteMethod();
                setWay.invoke(t, value);
            }
            list.add(t);
        }
        // 在if语句外返回list集合
        return list;
        //return null;
    }

}
