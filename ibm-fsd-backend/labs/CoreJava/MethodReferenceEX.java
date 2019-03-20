package com.core.java.caseStudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;

public class MethodReferenceEX {
	public static void main(String[] args) {
		String[] countriesArr= {"India","China"};
		Collection<String> countries=Arrays.asList(countriesArr);
	
		for(String country:countries) 
		{
			System.out.println(country);
		}
		
		Iterator<String> itr=countries.iterator();
		while(itr.hasNext()) 
		{
			System.out.println(itr.next());
		}
		
		//foreach method with lamda expression
		//countries.forEach((String item)->System.out.println(item));
		MethodReferenceEX ob=new MethodReferenceEX();
		countries.forEach((String item)->ob.displayItem(item));
		
		System.out.println("foreach with method reference");
		countries.forEach(MethodReferenceEX::displayItem);
		
		//lambda expression to create arraylist
		Supplier<List<String>> cities=()->{return new ArrayList<String>();};
			List<String> list=cities.get();	
			System.out.println(list);
			
		//method reference example to create arraylist(invoking constructor)
			Supplier<List<String>> cities1=ArrayList::new;
			List<String> list1=cities1.get();	
			System.out.println(list1);
			
		}
	
	
	public static void displayItem(String item) {
		System.out.println(item);
	}
	
	
	
	
}
