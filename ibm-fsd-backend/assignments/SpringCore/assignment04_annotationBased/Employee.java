package com.example.spring.core;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee {
	@Value(value="1")
	int id;
	@Value(value="Rose")
	String name;
	@Value(value="21")
	int age;
	LocalDate dob;
	@Value(value="Engineer")
	String designation;
	@Value(value="22000.00")
	double salary;
	//@Value(value="java,spring")
	List<String> skills;
	
	@Autowired
	Address address;
	@Value(value="true")
	boolean fulltime;
	

	
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

	
//	
//	public String toString() {
//		// TODO Auto-generated method stub
//		return this.address.getCity()+" , "+this.address.getCountry()+" , "+this.address.getPin();
//		}
}
