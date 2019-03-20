package com.exmaple.java.collection;

//import java.util.Arrays;
import java.util.Vector;

public class CollectionList {
	public static void main(String args[]) {
		Vector<String> countries=new Vector<>();
		countries.add("india");
		countries.add("usa");
		
		for(int i=0;i<10;i++) {
			countries.add("india"+i);
		}
		
		System.out.println(countries.size());
		System.out.println(countries.get(1));
		
		for(Object item:countries) {
			System.out.println(item);
		}
		
		countries.remove(0);
		for(Object item:countries) {
			System.out.println(item);
		}
		
		Object[] countryArray=countries.toArray();
		System.out.println(countryArray.length);
		
		//List<Object> countriesFromArray=Arrays.asList(countryArray);
	}
}
