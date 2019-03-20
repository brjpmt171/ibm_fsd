package com.java.example.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
	private AtomicInteger count=new AtomicInteger(0);
	
	public synchronized void increment() { //synchronizedly execute each thread, no other thread interrupt
		count.incrementAndGet();
	}
	// count=1
	//decrement access count=1
	public synchronized void decrement() {
		count.incrementAndGet();
	}
	public int getValue() {
		return count.intValue();
	}
}
