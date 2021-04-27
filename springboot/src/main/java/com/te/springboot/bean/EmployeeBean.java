package com.te.springboot.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Data
@Entity
@Table(name = "employee_info")
@JsonRootName("employee-info")
@JsonPropertyOrder({ "id", "name" })
@XmlRootElement(name = "employee-info")
public class EmployeeBean implements Serializable {

	@Id
	@JsonProperty("emp_id")
	private int id;

	private String name;

	private Date dob;

	private String password;

}// end of class
