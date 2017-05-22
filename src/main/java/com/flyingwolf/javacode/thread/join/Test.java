package com.flyingwolf.javacode.thread.join;

/** 
 * @ClassName: Test 
 * @Description: 现在有T1、T2、T3三个线程，你怎样保证T2在T1执行完后执行，T3在T2执行完后执行
 * @author: Ma.Chao
 * @date: 2017年5月22日 上午11:00:02  
 */
public class Test {
	
	

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(100);
					System.out.println("t1");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					t1.join();
					Thread.sleep(60);
					System.out.println("t2");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					t2.join();
					Thread.sleep(20);
					System.out.println("t3");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
		t3.start();
	}

}
