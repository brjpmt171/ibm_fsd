package com.example.spring.core;

//import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class FilePathEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext context=new FileSystemXmlApplicationContext("C:\\Users\\BrajaGopalMaity\\Desktop\\java_program\\ibm-fsd-backend\\Spring\\src\\bean-config.xml");
		
		//Greetings obj=(Greetings) context.getBean("greetings");
		
		Greetings obj=context.getBean("greetings", Greetings.class);
		
		
		obj.setMessage("hi... this is example of filePath");
		obj.getMessage();
		
		context.close();
		
		//graceful shutdown of container
		//context.registerShutdownHook();
	}

}
