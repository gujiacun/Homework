package com._520it.handler;

import java.sql.ResultSet;

/**
 * 定义处理ResultSet 结果集的规范
 *  T 表示泛指的类型, 跟 handle方法返回值一样, 是同种类型
 * @param <T>
 */
public interface IResultSetHandler<T>{
	/**
	 * 处理传进来的结果集
	 * @param resultSet   	执行查询语句之后,返回的结果集
	 * @return	T			将结果集包装之后得到对象集合
	 * 
	 * @throws Exception
	 */
	T  handle(ResultSet resultSet) throws Exception;
}
