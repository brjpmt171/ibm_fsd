package com.core.java.caseStudy;

public class AbstractTest {
	int a=10;
	public interface InterfaceTest{
		//void AbstractTest();
	}
	public class InnerClass implements InterfaceTest{
		public class Innerclass1{
			public void sayhello() {
				int b=11;
				System.out.println("hello inner inner "+a);
			}
		}
		public InnerClass(){
			
		}
		public void sayhello() {
			System.out.println("hello inner");
			
		}
	}
	public static void main(String[] args) {
		AbstractTest test=new AbstractTest();
		AbstractTest.InnerClass inner=test.new InnerClass();
		inner.sayhello();
		
		AbstractTest test1=new AbstractTest();
		AbstractTest.InnerClass inner1=test1.new InnerClass();
		AbstractTest.InnerClass.Innerclass1 inner2=inner1.new Innerclass1();
		inner2.sayhello();
	}
	

	
}
