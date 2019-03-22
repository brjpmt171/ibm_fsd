package com.example.spring.core;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("bean-config.xml");
		
		Employee obj =  (Employee) context.getBean("employeeInject");
		obj.printDetails();
		
		context.registerShutdownHook();
	}

}
