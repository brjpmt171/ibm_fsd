package com.example.spring.core;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


public class Employee {
	
	int id;
	String name;
	int age;
	LocalDate dob;
	String designation;
	double salary;
	List<String> skills;
	Address address;
	boolean fulltime;
	
	public Employee() {
			
		}

	public Employee(int id,String name,Address address,LocalDate dob,List skills,int age,double salary,String designation) {
		this.id=id;
		this.name=name;
		//this.salary=salary;
		this.address=address;
		this.dob=dob;
		this.skills=skills;
		this.age=age;
		this.salary=salary;
		this.designation=designation;
		//this.fulltime=fulltime;
	}
	
	public void printDetails() {
		System.out.println("id : "+id );
		System.out.println("name : "+name );
		System.out.println("age : "+age );
		System.out.println("dob : "+ dob );
		System.out.println("designation : "+designation );
		System.out.println("salary : "+salary );
		System.out.println("skills : "+skills );
		System.out.println("address : "+this.address.getCity()+" , "+this.address.getCountry()+" , "+this.address.getPin() );
		System.out.println("fulltime : "+fulltime );
	}

	public Address getAddress() {
		return address;
	}
	
	//@Autowired
	public void setAddress(Address address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public boolean isFulltime() {
		return fulltime;
	}

	public void setFulltime(boolean fulltime) {
		this.fulltime = fulltime;
	}
	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
//	
//	public String toString() {
//		// TODO Auto-generated method stub
//		return this.address.getCity()+" , "+this.address.getCountry()+" , "+this.address.getPin();
//		}
}
