package com.java.example.concurrency;

import java.util.Scanner;

public class ThreadEx {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Thread example");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
		}
		
		System.out.println("Thread woke up...");
		
		Scanner in=new Scanner(System.in);
		System.out.println(in.nextLine());
		
		ThreadEx threadex=new ThreadEx();
		threadex.wait(4000);
		
		System.out.println(Thread.currentThread().getName());
	}
}
