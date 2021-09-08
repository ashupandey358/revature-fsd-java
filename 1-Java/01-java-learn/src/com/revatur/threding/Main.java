package com.revatur.threding;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TheradingDemo thread=new TheradingDemo();
		Thread mainThread=thread.currentThread();
		thread.start();
		System.out.println("Main thread");
		ThreadDemoRunaable tdr=new ThreadDemoRunaable();
		Thread threadrunnable=new Thread(tdr);
		threadrunnable.start();
		System.out.println("thread (" + mainThread.getName() +"is running)");
		

	}

}
