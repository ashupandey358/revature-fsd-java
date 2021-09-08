package com.revatur.threding;

public class MultipleThread {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		TheradingDemo thread=new TheradingDemo();
		Thread mainThread=thread.currentThread();
		TheradingDemo thread1=new TheradingDemo();
		TheradingDemo thread2=new TheradingDemo();
		TheradingDemo thread3=new TheradingDemo();
		TheradingDemo thread4=new TheradingDemo();
		TheradingDemo thread5=new TheradingDemo();
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		
		
		thread1.join();
		thread2.join();
		thread3.join();
		thread4.join();
		thread5.join();
		System.out.println("thread (" + mainThread.getName() +"is running)");
		
	}

}
