package com.te.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.springboot.bean.EmployeeBean;
import com.te.springboot.bean.EmployeeResponse;
import com.te.springboot.service.EmployeeService;

@RestController
public class EmployeeRestController {
	
	@Autowired
	 private EmployeeService service;
	
	@GetMapping(path = "/getEmp", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public EmployeeResponse getEmp(int id) {
		EmployeeResponse response = new EmployeeResponse();
		EmployeeBean bean=service.getEmployee(id);
		if (bean != null) {
			response.setStatusCode(100);
			response.setMsg("success");
			response.setDescription("Employee data found for id:"+id);
			response.setBean(bean);
			
		}else {
			response.setStatusCode(400);
			response.setMsg("failure");
			response.setDescription("Employee data not found for id:"+id);
			
		}
		return response;
		
		
		
	}
	@GetMapping(path = "/getAllEmp", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public EmployeeResponse getAllEmp() {
		EmployeeResponse response = new EmployeeResponse();
		List<EmployeeBean> bean=service.getAllEmployees();
		if (bean != null) {
			response.setStatusCode(100);
			response.setMsg("success");
			response.setDescription("Employee data found"); 
			response.setEmployeeBeans(bean);
			
		}else {
			response.setStatusCode(400);
			response.setMsg("failure");
			response.setDescription("Employee data not found");
			
		}
		return response;
	}

	@PostMapping(path = "/add", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public EmployeeResponse addEmp(@RequestBody EmployeeBean employeeBean) {
		EmployeeResponse response = new EmployeeResponse();
		if (service.getAddEmpForm(employeeBean)) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setDescription("Added Successfully");
		} else {
			response.setStatusCode(400);
			response.setMsg("failure");
			response.setDescription("Something Went Wrong");
		}
		return response;
	}//
	@DeleteMapping(path = "/delete/{emp_id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public EmployeeResponse deleteEmp(@PathVariable(name = "emp_id") int id) {
		EmployeeResponse employeeResponse = new EmployeeResponse();
		if (service.deleteEmp(id)) {
			employeeResponse.setStatusCode(200);
			employeeResponse.setMsg("success");
			employeeResponse.setDescription(" Data Deleted for id : " + id);
		} else {
			employeeResponse.setStatusCode(400);
			employeeResponse.setMsg("failure");
			employeeResponse.setDescription("something went wrong");
		}

		return employeeResponse;
	}//
	@PutMapping(path = "/update", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public EmployeeResponse updateEmp(@RequestBody EmployeeBean bean) {
		System.out.println(bean);
		EmployeeResponse response = new EmployeeResponse();
		if (service.updateEmp(bean)) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setDescription("Added Successfully");
		} else {
			response.setStatusCode(400);
			response.setMsg("failure");
			response.setDescription("Something Went Wrong");
		}
		return response;
	}
	

}
