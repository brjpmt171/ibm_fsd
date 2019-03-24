package com.examples.spring.employeeApp;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.examples.spring.employeeApp.Employee;
import com.examples.spring.employeeApp.EmployeeManage;

public class EmployeeMenu {

	public static void main(String[] args) throws CustomException, ClassNotFoundException {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		//EmployeeManage empManage=new EmployeeManage();
		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("employeeApp-config.xml");

		EmployeeManage empManage = (EmployeeManage) context.getBean("service");
		while(true) {
			//System.out.println("\n Press '1' -  Add Employee \n Press '2' -  Edit Employee \n Press '3' -  delete Employee \n Press '4' -  Search Employee \n Press '5' -  Display all employee \n Press '7' -  Statistic of employee \n Press '8' - Import \n Press '9' - Export \n Press '10' - Import from file \n Press '11' - Insert into database \n Press '12' - display from database \n Press '13' - delete from database \n Press '14' - update from database \n Press '6' -  Exit");
			/*System.out.println("----- Operations without Database -----");
			System.out.println("Press '1' -  Add Employee");
			System.out.println("Press '2' -  Edit Employee");
			System.out.println("Press '3' -  delete Employee");
			System.out.println("Press '4' -  Search Employee");
			System.out.println("Press '5' -  Display all employee");
			System.out.println("Press '7' -  Statistic of employee");
			System.out.println("Press '8' - Export as Binary Format");
			System.out.println("Press '9' - Import from Binary Format");
			System.out.println("Press '10' - Import from Text file");*/
			
			
			System.out.println("\n");
			System.out.println("---- Operations with MySql Database ----");
			System.out.println("Press '1' - Insert into database");
			System.out.println("Press '2' - display from database");
			System.out.println("Press '3' - delete from database");
			System.out.println("Press '4' - update from database");
			System.out.println("Press '5' - Searching from database");
			System.out.println("Press '6' - Employee Statistics from database");
			
			System.out.println("Press '7' -  Exit");
			System.out.println("\n");
			System.out.println("Enter Your Option : ");
			int	type=sc.nextInt();
		 switch(type){
		 case 1:
			 empManage.addEmp();
			 break;
			 
		 case 2:
			 empManage.viewEmp();
			 break;
			 
		 case 3:
			 empManage.deleteEmp();
			 break;
			 
		 case 4:
			 empManage.editEmp();
			 break;
			 
		 case 5:
			 empManage.serchEmp();
			 break;
			 
		 case 6:
			 empManage.statisticsEmp();
			 break;
			
		case 7:
			System.exit(0);
			
		
		}
		}
	}

}
