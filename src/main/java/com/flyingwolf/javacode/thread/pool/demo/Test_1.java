package com.flyingwolf.javacode.thread.pool.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test_1 {

	public static void main(String[] args) {
		ThreadPoolExecutor tpe = new ThreadPoolExecutor(10, 10, 0L, 
				TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
		ExecutorService executor = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 10; i++) {
			Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName());
				}
			});
			//executor.submit(t);
			tpe.submit(t);
		}
		//executor.shutdown();
		tpe.shutdown();
	}
	
	
	
}
