package com.java.example.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.java.collection.assessment.CustomException;

public class CopyFileWithByteStreamEx {

		public static void main(String[] args) throws CustomException,IOException{
			FileInputStream in=null;
			FileOutputStream out=null;
			
			try {
				in=new FileInputStream("C:\\Users\\BrajaGopalMaity\\Desktop\\link.txt");
				//out=new FileOutputStream("C:\\Users\\BrajaGopalMaity\\Desktop\\link.txt");
				
				int c;
		         while ((c = in.read()) != -1) {
		        	 System.out.print((char)c);
		           // out.write(c);
		         }         
		         System.out.println("successfully copied");
			}
			catch(FileNotFoundException e) {
				//throw new CustomException("Error occured - file not found - " + e.getMessage());
				System.out.println(e);
			}
			
			 finally {
		    	  System.out.println("Finally called...");
		         if (in != null) {
		            in.close();
		         }
		         if (out != null) {
		            out.close();
		         }
		      }
		}
}
