package com.flyingwolf.book.java多线程编程核心技术.第一章.z;

public class Test {

	public static void main(String[] args) {
		for (int i = 1; i <= 15; i++) {
			MyThread t = new MyThread(i);
			t.start();
		}
	}

}
