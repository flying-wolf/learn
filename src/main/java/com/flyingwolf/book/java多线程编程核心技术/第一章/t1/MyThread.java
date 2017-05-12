package com.flyingwolf.book.java多线程编程核心技术.第一章.t1;

public class MyThread extends Thread {
	@Override
	public void run(){
		super.run();
		System.out.println("MyThread");
	}
}
