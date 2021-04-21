package com.te.springmvc2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class EmployeeConfig {
	
	@Bean
	public LocalEntityManagerFactoryBean getFactoryBean() {
		
		LocalEntityManagerFactoryBean bean = new LocalEntityManagerFactoryBean();
		bean.setPersistenceUnitName("emp");
		return bean;
		
	}

}
