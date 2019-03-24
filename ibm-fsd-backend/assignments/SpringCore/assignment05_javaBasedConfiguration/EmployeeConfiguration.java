package com.example.spring.core;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@ComponentScan
@Configuration
//@Import(AddressConfiguration.class)
public class EmployeeConfiguration {

	@Bean
	public Address address() {
		return new Address("kolkata","India",700150);
	}
	@Bean		
	public LocalDate dob() {
		LocalDate dob=LocalDate.parse("1990-01-01");
		return dob;
		
	}
	@Bean
	public List skills() {
		List<String> skills=new ArrayList<>();
		skills.add("java");
		skills.add("sap");
		skills.add("oracle");
		
		return skills;
		
	}
	@Bean
	public Employee employee() {
		return new Employee(1,"subham",address(),dob(),skills(),32,45000.00,"Engineer");
	}
	

		
}
