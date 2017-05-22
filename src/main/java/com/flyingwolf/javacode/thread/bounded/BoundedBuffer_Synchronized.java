package com.flyingwolf.javacode.thread.bounded;

/** 
 * @ClassName: BoundedBuffer_Synchronized 
 * @Description: 阻塞队列—synchronized实现
 * @author: Ma.Chao
 * @date: 2017年5月22日 下午3:32:50  
 */
public class BoundedBuffer_Synchronized {
	private Object[] items;
	private Object notFull;
	private Object notEmpty;
	private int putPtr,takePtr,count;
	
	public BoundedBuffer_Synchronized(int length) {
		if(length < 1)
			length = 1;
		if(length > Integer.MAX_VALUE)
			length = Integer.MAX_VALUE;
		items = new Object[length];
		notFull = new Object();
		notEmpty = new Object();
	}
	
	public void put(Object obj) {
		try {
			//如果队列已满，notEmpty一直等待
			synchronized (notFull){
				while(count == items.length){
					notFull.wait();
				}
			}
			items[putPtr] = obj;//队列有空位,向队列插入数据
			if(++ putPtr == items.length)
				putPtr = 0;
			count ++;
			//释放notEmpty
			synchronized (notEmpty){
				notEmpty.notify();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public Object take() {
		try {
			//如果队列空了，notEmpty一直等待
			synchronized (notEmpty){
				while(count == 0){
					notEmpty.wait();
				}
			}
			Object obj = items[takePtr];
			if(++ takePtr == items.length)
				takePtr = 0;
			count --;
			//释放notFull
			synchronized(notFull){
				notFull.notify();
			}
			return obj;
		} catch (InterruptedException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) {
		final BoundedBuffer_Synchronized bs = new BoundedBuffer_Synchronized(2);
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
					bs.put("a");
					bs.put("b");
					bs.put("c");
					bs.put("c");
					bs.put("d");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		System.out.println("take:"+bs.take());
		System.out.println("take:"+bs.take());
	}
}
