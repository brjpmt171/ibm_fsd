package com.exmaple.core.java;

public class PrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int f=10;
		int l=20;
		
		System.out.println("prime number");      
		for(int i=f;i<=l;i++) {
			int c=0;
			 for(int j=2;j<i;j++) {
				 if(i%j==0) {
					 c=0;
					 break;
				 }
				 else {
					 c=1;
				 }
			 }
			 if(c==1) {
				 System.out.println(i+" is prime number");
			 }
			 
		}
	}

}
