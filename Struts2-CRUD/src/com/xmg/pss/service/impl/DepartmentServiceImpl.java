package com.xmg.pss.service.impl;

import lombok.Setter;

import com.xmg.pss.dao.IEmployeeDAO;
import com.xmg.pss.service.IDepartmentService;

public class DepartmentServiceImpl implements IDepartmentService {
	@Setter
	private IEmployeeDAO empDAO;
}
