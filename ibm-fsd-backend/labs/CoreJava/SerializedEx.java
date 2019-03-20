package com.java.example.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class SerializedEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee e = new Employee();
		e.name = "Reyan Ali";
		e.address = "Phokka Kuan, Ambehta Peer";
		e.SSN = 11122333;
		e.id = 101;
		e.skill=Arrays.asList("java","html");
		

		try {
			FileOutputStream fileOut = new FileOutputStream("C:\\Users\\BrajaGopalMaity\\Desktop\\employee.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(e);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in C:\\Users\\BrajaGopalMaity\\Desktop\\employee.ser");
		} catch (IOException i) {
			i.printStackTrace();
		}
	}

}
