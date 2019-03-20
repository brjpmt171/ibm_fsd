package com.java.example.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeSerializeEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Employee e = null;
	      try {
	         FileInputStream fileIn = new FileInputStream("C:\\Users\\BrajaGopalMaity\\Desktop\\employee.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         e = (Employee) in.readObject();
	         in.close();
	         fileIn.close();
	      } catch (IOException i) {
	         i.printStackTrace();
	         return;
	      } catch (ClassNotFoundException c) {
	         System.out.println("Employee class not found");
	         c.printStackTrace();
	         return;
	      }
	      
	      System.out.println("Deserialized Employee...");
	      System.out.println("Name: " + e.name);
	      System.out.println("Address: " + e.address);
	      System.out.println("SSN: " + e.SSN);
	      System.out.println("Id: " + e.id);
	      System.out.println("Skills: " + e.skill);
	}

}
