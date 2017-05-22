package com.xmg.pss.handler;

import java.sql.ResultSet;

public interface IResultSetHandler<T> {
    public T handle(ResultSet rs) throws Exception;
}
