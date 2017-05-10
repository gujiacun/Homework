// 需求：由于一张表对应一个DAO对象，若有多张表则有多个DAO对象/实体类，每次处理结果集都要定义n个IResultSetHandler
//接口的实现类，不够通用，把搜索语句的结果集处理部分新建类，使用泛型来处理

package src.com._520it.pss.handler;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.ResultSet;

// 单行搜索结果的处理（表中的单行）
//这里的泛型，表示由实现类的方法传入需要处理的表/DAO对象，可以处理多张表，增加通用性
public class BeanHandler<T> implements IResultSetHandler<T> {

    // 由于不知道需要处理的DAO对象，所以用泛型，要把结果集中的数据传入到对象中，用反射/内省
    Class<T> clz;

    // 在创建单行结果集处理器时传入DAO对象的类型
    public BeanHandler(Class<T> clz) {
        this.clz = clz;
    }

    // 实现IResultSetHandler接口，重写handle方法
    // 搜索单行信息，返回DAO对象,要从结果集中返回对象，从结果集中拿信息
    @Override
    public T handle(ResultSet rs) throws Exception {
        // 建DAO对象的新实例
        T t = clz.newInstance();
        // 通过内省，拿DAO对象的属性
        BeanInfo beanInfo = Introspector.getBeanInfo(clz, Object.class);
        // 返回所有属性组成的数组
        PropertyDescriptor[] array = beanInfo.getPropertyDescriptors();

        // 通过反射，把从表中得到的结果集的数据赋给对象
        if (rs.next()) {
            for (PropertyDescriptor propertyDescriptor : array) {
                // 拿属性名，即表中的列名
                String name = propertyDescriptor.getName();
                // 通过列名拿值
                Object value = rs.getObject(name);
                // 获取对象的属性的set方法
                Method setWay = propertyDescriptor.getWriteMethod();
                // 调用set方法（invoke）把值传进对象里
                setWay.invoke(t, value);
            }
        }
        // 返回对象
        return t;
    }
    /**
     * 小结：当无法确定返回/输出值的类型时，或想让此方法通用性更高，用泛型，由此方法的掉用者指定具体类型
     */
}
