package com.core.java.caseStudy;

public class varArgsDemo {
	/*public static int sum(int a,int b) {
		return a+b;
	}*/
	
	public static int sum(int... args) {
		int total=0;
		for(int arg:args) {
			total+=arg;
		}
		return total;
	}
	public static void main(String args[]) {
		System.out.println(sum(10,20,30));
	}
}
