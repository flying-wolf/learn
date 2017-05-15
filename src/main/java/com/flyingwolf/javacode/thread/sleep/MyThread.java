package com.flyingwolf.javacode.thread.sleep;

public class MyThread extends Thread {
	
	public void run(){
		for (int i = 0; i < 100; i++) {
			if(i % 10 == 0){
				System.out.println("----------------:"+i);
			}
			System.out.println(i);
			try {
				Thread.yield();
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		MyThread mt = new MyThread();
		MyThread mmt = new MyThread();
		mt.setPriority(MAX_PRIORITY);
		mmt.setPriority(MIN_PRIORITY);
		mt.start();
		mmt.start();
	}
	
}
