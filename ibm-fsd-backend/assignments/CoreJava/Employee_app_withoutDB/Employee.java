package com.java.collection.assessment;

import java.time.LocalDate;
import java.time.LocalTime;

public class Employee<T> implements java.io.Serializable {
	 	/**
	 * 
	 */
	private static final long serialVersionUID = 4446034802603332320L;
	
		String eid;
		String name;
		int salary;
		 LocalDate dob;
		String dept;
		
		public Employee()
		{
			
		}
		
		public Employee(String eid,String name,int salary,LocalDate dob,String dept) {
			this.eid=eid;
			this.name=name;
			this.salary=salary;
			this.dob=dob;
			this.dept=dept;
		}

		public String getDept() {
			return dept;
		}

		public void setDept(String dept) {
			this.dept = dept;
		}

		public String getEid() {
			return eid;
		}
		
		public LocalDate getDob() {
			return dob;
		}

		public void setDob(LocalDate dob) {
			this.dob = dob;
		}

		public void setEid(String eid) {
			this.eid = eid;
		}

		public String getName() {
			return name;
		}

		public void setName(int editkey,String name) {
			this.name = name;
		}
		
		public void setName(String name) {
			this.name = name;
		}		

		public int getSalary() {
			return salary;
		}

		public void setSalary(int editKey,int salary) {
			this.salary = salary;
		}
		
		public void setSalary(int salary) {
			this.salary = salary;
		}
		
		@Override
		public String toString() {
		// TODO Auto-generated method stub
		return this.eid+" "+this.getName()+" "+this.getSalary();
		}
}
