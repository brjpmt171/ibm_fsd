package com.example.spring.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeMainUsingAnnotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("using java based configuration");
		
		//AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans-config1.xml");
		
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(EmployeeConfiguration.class);
		Employee obj=(Employee) context.getBean("employee");
		
		
		obj.printDetails();
		
		context.close();
	}

}
