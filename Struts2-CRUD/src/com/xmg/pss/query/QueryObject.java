package com.xmg.pss.query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.lang3.StringUtils;
@Getter
@Setter
public class QueryObject {

	private List<String> conditions = new ArrayList<>();
	@Getter
	private List<Object> parameters = new ArrayList<>();
	@Getter
	@Setter
	private Integer currentPage = 1;
	@Getter
	@Setter
	private Integer pageSize =5;

	//获取拼接好的SQL条件
	public String getQueryConditions() {
		StringBuilder sb = new StringBuilder(50);
		customizedQuery();
		if (conditions.size() > 0) {
			sb.append(" WHERE ");
			String join = StringUtils.join(conditions, " AND ");
			sb.append(join);
		}
		return sb.toString();
	}
	
	public List<Object> getParameters(){
	    return parameters;
	}

	//供子类覆写:将条件和参数存放到集合中
	protected void customizedQuery() {

	}

	//将子类中的参数和条件传递进来
	protected void addQuery(String condition, Object... param) {
		this.conditions.add(condition);
		this.parameters.addAll(Arrays.asList(param));
	}
}
