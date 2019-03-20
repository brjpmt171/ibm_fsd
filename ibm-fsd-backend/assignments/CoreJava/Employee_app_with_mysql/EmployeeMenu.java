package com.java.collection.assessment;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.java.collection.assessment.Employee;
import com.java.collection.assessment.EmployeeManage;

public class EmployeeMenu {

	public static void main(String[] args) throws CustomException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		EmployeeManage empManage=new EmployeeManage();
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
			System.out.println("Press '11' - Insert into database");
			System.out.println("Press '12' - display from database");
			System.out.println("Press '13' - delete from database");
			System.out.println("Press '14' - update from database");
			System.out.println("Press '15' - Employee Statistics from database");
			
			System.out.println("Press '6' -  Exit");
			System.out.println("\n");
			System.out.println("Enter Your Option : ");
			int	type=sc.nextInt();
		 switch(type){
	/*	case 1:
			empManage.addEmployee();
			break;
			
		case 2:
			empManage.editEmployee();
			break;
			
		case 3:
			empManage.deleteEmployee();
			break;
			
		case 4:
			empManage.searchEmployee();
			break;
			
		case 5:
			empManage.showEmp();
			break;
			
		case 7:
			empManage.employeeStatistic();
			break;
			
		case 8:
			empManage.employeeExport();
			break;
			
		case 9:
			empManage.employeeImport();
			break;
			
		case 10:
			empManage.importUsingThread();
			
			Callable<Boolean> importEmployee=new Callable() {

				@Override
				public Boolean call() throws Exception {
					// TODO Auto-generated method stub
					System.out.println(Thread.currentThread()+"Waiting 5 sec for import employee.....");
					Thread.sleep(5000);
					empManage.importUsingThread();
					return true;
				}
				
			};
			
			ExecutorService executor=Executors.newFixedThreadPool(1);
			Future<Boolean> importFuture=executor.submit(importEmployee);
			System.out.println(Thread.currentThread().getName()+"Import done .");
			break;*/
			
		case 11:
			try {
				empManage.insertIntoDatabase();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case 12:
			empManage.showFromDatabase();
			break;
			
		case 13:
			empManage.deleteFromDatabase();
			break;
			
		case 14:
			empManage.updateFromDatabase();
			break;
			
		case 15:
			empManage.employeeStatisticsFromDatabase();
			break;
			
		case 6:
			System.exit(0);
			
		
		}
		}
	}

}
