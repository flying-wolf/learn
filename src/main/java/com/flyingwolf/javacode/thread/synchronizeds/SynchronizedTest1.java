package com.flyingwolf.javacode.thread.synchronizeds;

public class SynchronizedTest1 {
	
	public void method1(){
		System.out.println("Method 1 start");
		try {
			System.out.println("Method 1 execute");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Method 1 end");
	}
	
	public void method2(){
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
		final SynchronizedTest1 st = new SynchronizedTest1();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				st.method1();
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				st.method2();
			}
		}).start();
	}

}
