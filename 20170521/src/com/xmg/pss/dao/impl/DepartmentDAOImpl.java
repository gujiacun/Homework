package com.xmg.pss.dao.impl;

import com.xmg.pss.dao.IDepartmentDAO;
import com.xmg.pss.dao.IEmployeeDAO;

import lombok.Setter;

public class DepartmentDAOImpl implements IDepartmentDAO {
    @Setter
    private IEmployeeDAO employeeDAO;
}
