package com.example.spring.core;

//import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClassPathEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext context=new ClassPathXmlApplicationContext("bean-config.xml");
		
		Greetings obj=(Greetings) context.getBean("greetings");
		obj.setMessage("hi... this is example of classPath");
		obj.getMessage();
		
context.close();
		
		//graceful shutdown of container
		//context.registerShutdownHook();

	}

}
