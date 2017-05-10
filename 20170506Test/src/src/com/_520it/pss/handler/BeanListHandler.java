// 需求：由于一张表对应一个DAO对象，若有多张表则有多个DAO对象/实体类，每次处理结果集都要定义n个IResultSetHandler
//接口的实现类，不够通用，把搜索语句的结果集处理部分新建类，使用泛型来处理

package src.com._520it.pss.handler;

import static org.junit.Assert.*;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
//import java.util.logging.Handler;

//import org.omg.CORBA.PUBLIC_MEMBER;
//由于是所有信息，所以用List<T>
public class BeanListHandler<T> implements IResultSetHandler<List<T>> {
    Class<T> clz;

    public BeanListHandler(Class<T> clz) {
        this.clz = clz;
    }

    // 对表中所有信息的搜索结果的集合的处理
    @Override
    public List<T> handle(ResultSet rs) throws Exception {
        // 先把结果集的信息封装进对象，再把对象添加进list集合
        List<T> list = new ArrayList<>();
        // 通过反射，把从表中得到的结果集的数据赋给对象
        while (rs.next()) {
            // 先获取要处理的表/DAO对象里的所有属性
            T t = clz.newInstance();
            // 拿DAO对象的所有属性
            BeanInfo beanInfo = Introspector.getBeanInfo(clz, Object.class);
            // 拿所有的属性描述器
            PropertyDescriptor[] array = beanInfo.getPropertyDescriptors();
            // 拿每一个属性描述器
            for (PropertyDescriptor propertyDescriptor : array) {
                // 拿每一个属性描述器的名字。即表中的列名
                String name = propertyDescriptor.getName();
                // 根据列名拿结果集中对应的值
                Object value = rs.getObject(name);
                // 获取每个属性的set方法
                Method setWay = propertyDescriptor.getWriteMethod();
                // 调用set方法把值设置
                setWay.invoke(t, value);
            }
            // 把对象加进list集合
            list.add(t);
        }
        return list;
    }
    /**
     * 小结：当无法确定返回/输出值的类型时，或想让此方法通用性更高，用泛型，由此方法的掉用者指定具体类型
     */
}
