package com.example.java.time;

import java.util.Calendar;
import java.util.Date;

public class LegacydateTimeEx {
	public static void main(String[] args) {
		Date today=new Date();
		System.out.println(today);
		
		Date yesterday=new Date("2019/02/13 11:30:00");
		System.out.println(yesterday);
		
		long timeInMillis=Date.parse("2019/03/04 14:00:00");
		Date date=new Date(timeInMillis);
		
		Calendar todayc=Calendar.getInstance();
		System.out.println(todayc.getTimeInMillis());
		System.out.println(todayc.getTime());
		System.out.println(todayc.getWeekYear());
		
		
	}
}
