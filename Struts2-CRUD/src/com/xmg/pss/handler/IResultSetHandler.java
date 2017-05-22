package com.xmg.pss.handler;

import java.sql.ResultSet;

//定义处理结果集的方法
public interface IResultSetHandler<T> {
	T handler(ResultSet rs) throws Exception;
}
