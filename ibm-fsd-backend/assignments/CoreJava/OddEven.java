package com.exmaple.core.java;

public class OddEven {
	public static void main(String args[]) {
		System.out.println("Odd/Even");                  
		int f=10;
		int l=20;
		for(int i=f;i<=l;i++) {
			if(i%2==0) {
				System.out.println(i+" is even");
			}
			else {
				System.out.println(i+" is odd");
			}
		}
	}
}
