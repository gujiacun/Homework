package com.xmg.pss.query;

import java.util.Date;

import com.alibaba.druid.util.StringUtils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeQueryObject extends QueryObject {

	private String username;
	private String email;
	private Date beginHireDate;
	private Date endHireDate;

	@Override
	protected void customizedQuery() {
		if (!StringUtils.isEmpty(username)) {
			super.addQuery(" username LIKE ?", "%" + username + "%");
		}
		if (!StringUtils.isEmpty(email)) {
			super.addQuery(" email LIKE ?", "%" + email + "%");
		}
		if (beginHireDate != null) {
			super.addQuery(" hiredate >= ?", beginHireDate);
		}
		if (endHireDate != null) {
			super.addQuery(" hiredate <= ?", endHireDate);
		}
		
	}
}
