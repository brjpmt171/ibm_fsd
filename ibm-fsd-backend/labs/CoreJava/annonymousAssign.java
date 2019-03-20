package com.core.java.caseStudy;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import com.java.collection.assessment.Employee;

public class annonymousAssign {
	TreeMap<Integer, Employee> empObj = new TreeMap<>();

	/*public interface ValidateEmployee {
		public boolean check(Employee emp);
		// public boolean check(TreeMap<Integer, Employee> empObj);
	}

	boolean validate(ValidateEmployee validator, Employee emp) {
		return validator.check(emp);
	}
	public void printErrorMessage(String errorMassage,Consumer consumer) {
		consumer.accept(errorMassage);
	}
	
	Employee emp = new Employee();
	static int key;
	 public void showEmp() {
		 System.out.println("\t Emp ID \t Emp Name \t Emp salary \t Emp Age");
		 if(key==0) {
			 System.out.println("No data available");
		 }
		 else {
		 
		for(Object emp:empObj.keySet()) {
			//System.out.println(empObj.get(emp));
			System.out.format("\t      %s \t      %s \t      %d \t      %d ",empObj.get(emp).eid,empObj.get(emp).name,empObj.get(emp).salary);
			System.out.println("\n");
		}
		 }
	 }
	
	public void addEmployee() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int key = 0;

		

		System.out.println("enter employee ID: ");
		String eid = sc.next();
		emp.setEid(eid);

		System.out.println("enter employee name: ");
		String name = sc.next();
		emp.setName(name);

		System.out.println("enter employee salary: ");
		int salary = sc.nextInt();
		emp.setSalary(salary);

		System.out.println("enter employee age: ");
		int age = sc.nextInt();
	//	emp.setAge(age);

//		ValidateEmployee validator = new ValidateEmployee() {
//
//			@Override
//			public boolean check(Employee emp) {
//				return emp.getAge() > 0;
//
//			}
//		};
		
		//ValidateEmployee validator = e -> e.getAge() > 0;

	//	boolean valStatus = validate(e -> { return e.getAge() > 0 && e.getSalary()<20000;}, emp);

//		if (valStatus) {
//
//			//empObj.put(++key, new Employee<Number>(eid, name, salary, age));
//			System.out.println("Employee successfully added");
//		} else {
//			//System.out.println("Validation failed");
//			printErrorMessage("Invalid age or salary",msg->System.out.println(msg));
//		}
//	}
	public void statistics() {
		// TODO Auto-generated method stub
		Collection<Employee> values=empObj.values();
		
		//List<Integer> ages = Arrays.asList(empObj.get(emp));
//		long counts = values.stream()
//						.filter(e->e.getAge()>30)
//						.count();
//		
//		System.out.println("No of employee age>30 : " + counts);

		
	}*/

}
