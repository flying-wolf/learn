package com.flyingwolf.book.java多线程编程核心技术.第一章.z;

public class MyThread extends Thread {
	private int i;

	public MyThread(int i) {
		super();
		this.i = i;
	}
	
	@Override
	public void run(){
		System.out.println(i);
	}
}
