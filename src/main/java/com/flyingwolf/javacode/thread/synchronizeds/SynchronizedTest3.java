package com.flyingwolf.javacode.thread.synchronizeds;

public class SynchronizedTest3 {
	
	public static synchronized void method1(){
		System.out.println("Method 1 start");
		try {
			System.out.println("Method 1 execute");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Method 1 end");
	}
	
	public static synchronized void method2(){
		System.out.println("Method 2 start");
		try {
			System.out.println("Method 2 execute");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Method 2 end");
	}
	
	public static void main(String[] args) {
		final SynchronizedTest3 st1 = new SynchronizedTest3();
		final SynchronizedTest3 st2 = new SynchronizedTest3();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				st1.method1();
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				st2.method2();
			}
		}).start();
	}

}
