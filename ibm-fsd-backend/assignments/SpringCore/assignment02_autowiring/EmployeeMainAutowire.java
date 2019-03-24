package com.examples.spring.core.autowire;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class EmployeeMainAutowire {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("autowiring byname");
		//System.out.println("autowiring byType");
		//System.out.println("autowiring by Constructor");
		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("bean-config.xml");
		
		Employee obj =  (Employee) context.getBean("employee");
		obj.printDetails();
		
		context.registerShutdownHook();
	}
	

}
