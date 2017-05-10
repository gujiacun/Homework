// 需求：定义一个专门处理结果集（JdbcTemplate）的接口，实现通用性
package src.com._520it.pss.handler;

import java.sql.ResultSet;

//接口方法是抽象方法，没有方法体，那个对象处理结果集，那就创建实现这个接口的结果集处理（在实现类里）
public interface IResultSetHandler<T> {
    //由于要处理从jdbc模板类传来的结果集，传入参数为ResultSet
    /**
     * @param rs 处理传进来的结果集
     * @return T 返回值类型，将结果集包装后得到对象集合
     * @throws Exception
     */
    T handle(ResultSet rs) throws Exception;
    
    
}
