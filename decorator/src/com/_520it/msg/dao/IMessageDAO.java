package com._520it.msg.dao;

import java.util.List;

import com._520it.msg.domain.Message;


public interface IMessageDAO {
	
	void  add(Message obj);
	
	List<Message> getAll();
	
}
