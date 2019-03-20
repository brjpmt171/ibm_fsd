package com.core.java.caseStudy;

public class Calculator {
	int a,b;
    public	Calculator(){
		
	}
	public Calculator(Integer a,Integer b){
		this.a=a;
		this.b=b;
	}
	
	public int add(Integer a,Integer b) {
		return a+b;
	}
	public int sub(Integer a,Integer b) {
		return a-b;
	}
	public int mul(Integer a,Integer b) {
		return a*b;
	}
	public int div(Integer a,Integer b) {
		return a/b;
	}
}
