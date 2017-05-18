package com.flyingwolf.javacode.thread.pool.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test_1 {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 10; i++) {
			Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName());
				}
			});
			executor.submit(t);
		}
		executor.shutdown();
	}
	
	
	
}
