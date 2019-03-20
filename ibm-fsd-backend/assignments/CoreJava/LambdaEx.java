package com.core.java.caseStudy;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class LambdaEx {
	 public static void main(String args[]) {
		   LambdaEx lamExp = new LambdaEx();
			
	      //with type declaration
	     // BiFunction<Integer,Integer,Integer> addition = (Integer a, Integer b) -> a + b;
			
	      //with out type declaration
	      BiFunction<Integer,Integer,Integer> subtraction = (a, b) -> a - b;
			
	      //with return statement along with curly braces
	      BiFunction<Integer,Integer,Integer> multiplication = (a, b) -> { return a * b; };
			
	      //without return statement and without curly braces
	      BiFunction<Integer,Integer,Integer> division = (a,b) -> a / b;
			
	      System.out.println("10 + 5 = " + lamExp.operate(10, 5, (Integer a, Integer b) -> a + b));
	      System.out.println("10 - 5 = " + lamExp.operate(10, 5, subtraction));
	      System.out.println("10 x 5 = " + lamExp.operate(10, 5, multiplication));
	      System.out.println("10 / 5 = " + lamExp.operate(10, 5, division));
	      
	  
	      //without parenthesis and using Consumer functional interface
	      Consumer<String> greetService1 = message ->
	      System.out.println("Hello1 " + message);
			
	      //with parenthesis and using custom functional interface
	      Consumer<String> greetService2 = (message) ->
	      System.out.println("Hello2 " + message);
			
	      greetService1.accept("Mahesh");
	      greetService2.accept("Mahesh");
	     // greetService2.sayMessage("Suresh");      
	      
	   }
	 
		//using custom functional interface
//	   interface MathOperation {
//	      int operation(int a, int b);
//	   }
		
	   
//	   interface GreetingService {
//	      void sayMessage(String message);
//	   }
		
	   
	   private int operate(int a, int b, BiFunction<Integer,Integer,Integer> mathOperation) {
	      return mathOperation.apply(a, b);
	   }

}
