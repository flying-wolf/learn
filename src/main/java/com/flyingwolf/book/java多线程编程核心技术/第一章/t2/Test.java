package com.flyingwolf.book.java多线程编程核心技术.第一章.t2;


public class Test {
	public static void main(String[] args) {
		MyRunnable myRunnable = new MyRunnable();
		Thread thread = new Thread(myRunnable,"myRunable");
		thread.start();
		System.out.println("运行结束！");
	}
}
