package com._520it.crm.handler;

import java.sql.ResultSet;

/**
 
 * @author bunny
 */
public interface IResultSetHandler<T> {
	/**
 
	 * @throws Exception
	 */
	T handle(ResultSet rs) throws Exception; 
}
