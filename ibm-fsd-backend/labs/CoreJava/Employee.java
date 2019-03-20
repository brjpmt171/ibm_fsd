package com.java.example.io;

import java.util.List;

public class Employee implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4796956328148968838L;
	
	public String name;
	public String address;
	public transient int SSN;  // transient does not serialized
	public int id;
	public List<String> skill;
}
