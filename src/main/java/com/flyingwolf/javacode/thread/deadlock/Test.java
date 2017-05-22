package com.flyingwolf.javacode.thread.deadlock;

/** 
 * @ClassName: Test 
 * @Description: 死锁Demo
 * @author: Ma.Chao
 * @date: 2017年5月22日 上午11:36:06  
 */
public class Test {
	public static void main(String[] args) {
		/*Thread t9 = new Thread(  
                new DeadLock(true));  
        Thread t10 = new Thread(  
                new DeadLock(false));  
        t9.start();  
        t10.start();  */
		Object o1 = new Object();
		Object o2 = new Object();
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					synchronized (o1) {
						Thread.sleep(500);
						synchronized (o2){
							System.out.println("T1");
						}
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					synchronized (o2){
						Thread.sleep(500);
						synchronized (o1) {
							System.out.println("T2");
						}
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}).start();
	}
}



class DeadLock implements Runnable{  
	  
    boolean lockFormer;  
    static Object o1 = new Object();  
    static Object o2 = new Object();  
    DeadLock(boolean lockFormer){  
        this.lockFormer = lockFormer;  
    }  
      
    @Override  
    public void run() {  
        if(this.lockFormer){  
            synchronized (o1) {  
                try {  
                    Thread.sleep(500);  
                } catch (InterruptedException e) {  
                    e.printStackTrace();  
                }  
                synchronized (o2) {  
                    System.out.println("1ok");  
                }  
            }  
        }else{  
            synchronized (o2) {  
                try {  
                    Thread.sleep(500);  
                } catch (InterruptedException e) {  
                    e.printStackTrace();  
                }  
                synchronized (o1) {  
                    System.out.println("1ok");  
                }  
            }  
        }  
          
    }  
}
