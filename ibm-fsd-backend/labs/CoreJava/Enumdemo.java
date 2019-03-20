package com.core.java.caseStudy;

@SuppressWarnings("unused")
public class Enumdemo {
	//ENUM DEFINATION
	//public enum weekDays { MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATUREDAY,SUNDAY };
	
	//enum as method
	public enum weekDays {
		MONDAY{
			public String getDisplay() {
				return "Monday";
			}
			
		},
		TUESDAY,
		WEDNESDAY,
		THURSDAY,
		FRIDAY,
		SATUREDAY,
		SUNDAY ;
		
		private int dayIndex;
		
		private weekDays() {
			System.out.println("default enum constractor");
		}
		
		private weekDays(Integer dayIndex) {
			System.out.println("overloaded enum constractor");
		}
		
		public String getDisplay() {
			
			return "enum methos test";
		}
		
		public int getIndex() {
			return this.getIndex();
		}
	};
	
	public static void main(String[] args) {
		String day="MONDAY";
		
		//string comparison
		if(weekDays.MONDAY.toString()==day) {
		//if(day.equals("MONDAY")) {
			System.out.println("given day is "+ day);
		}
		
		//enum comparison
		if(weekDays.MONDAY==weekDays.valueOf(day)) {
			System.out.println("given day is "+ day);
		}
		
		
		//get all Enum value
		for(Object weekDay:weekDays.values()) {
			System.out.println(weekDay);
		}
		
		weekDays[] weekDaysArr=weekDays.values();
		System.out.println(weekDaysArr[0]);
	}
}
