package com.exmaple.java.collection;
import java.util.*;
import java.util.Comparator;

import com.exmaple.core.java.EmployeeManage;


public class CollextionHashSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	Comparator EMPLOYEE_SORT_BY_NAME=new Comparator() {
			@Override
			public int compare(Object o1,Objecto2) {
				if(o1 instanceof Employee && o2 instanceof Employee) {
					return ((Employee)o1).getAge-((Employee)o2).getAge();
				}
				return 0;
			}
		}*/
		Comparator EMPLOYEE_SORT_BY_NAME = new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				if (o1 instanceof Employee && o2 instanceof Employee) {
					return ((Employee) o1).getName().compareTo(((Employee) o2).getName());
				}
				return 0;
			}
		};
		
		TreeSet<Object> h=new TreeSet<Object>();
		
		h.add(new EmployeeManage(1,"abc",30000));
		h.add(new EmployeeManage(1,"xyz",50000));
		h.add(new EmployeeManage(1,"mnp",25000));
		
		System.out.println(h);
		
		System.out.println(h.contains("india"));
		
		Iterator i=h.iterator();
		while(i.hasNext()) {
			System.out.print(i.next()+" ");
		}
	}

}
