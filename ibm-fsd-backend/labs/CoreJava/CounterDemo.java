package com.java.example.concurrency;

public class CounterDemo {
	private static Counter counter;
	
	public static class CounterThread implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			synchronized(counter) {
				counter.increment();
				//System.out.println(counter.getValue());
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				counter.decrement();
				System.out.println(counter.getValue());
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		counter=new Counter();
		Thread t1=new Thread(new CounterThread());
		t1.start();
		//System.out.println(counter.getValue());
		
		Thread t2=new Thread(new CounterThread());
		t2.start();
		//System.out.println(counter.getValue());
//		counter.increment();
//		counter.decrement();
//		counter.increment();
//		counter.increment();
		
		System.out.println(counter.getValue());
	}

}
