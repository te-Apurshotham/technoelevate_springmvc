package com.te.springmvc2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.springmvc2.bean.EmployeeBean;
import com.te.springmvc2.dao.EmployeeDAO;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO dao;

	@Override
	public EmployeeBean authenticate(int id, String password) {
		return dao.authenticate(id, password);
	}

	@Override
	public EmployeeBean getEmployee(int id) {

		return dao.getEmployee(id);
	}

	@Override
	public boolean deleteEmp(int id) {
		return dao.deleteEmp(id);
	}

	@Override
	public List<EmployeeBean> getAllEmployees() {
		return dao.getAllEmployees();
	}

	@Override
	public boolean getAddEmpForm(EmployeeBean bean) {
		
		return dao.getAddEmpForm(bean);
	}

	@Override
	public boolean updateEmp(EmployeeBean bean) {
		return dao.updateEmp(bean);
	}

	

}//end of class
