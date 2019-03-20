package com.core.java.caseStudy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflextionCalculator {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		try {
			Class<?> c=Class.forName("com.core.java.caseStudy.Calculator");
			//Class<?> c=Calculator.class;
			System.out.println(c);
			Constructor<?> cnstrtor=c.getConstructor();
			System.out.println(cnstrtor);
			
			Object cal=c.newInstance();
			Method add=c.getMethod("add", Integer.class,Integer.class);
			Integer r=(Integer) add.invoke(cal,5,2);
			System.out.println(r);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
