package com.te.springboot.bean;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Data
@JsonRootName("employee_response")
@JsonPropertyOrder({ "statusCode", "msg" })
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeResponse implements Serializable {
	private int statusCode;

	private String msg;

	private String description;

	@JsonProperty("employee_info")
	private EmployeeBean bean;
	
	@JsonProperty("employee_details")
	private List<EmployeeBean>  employeeBeans;

}
