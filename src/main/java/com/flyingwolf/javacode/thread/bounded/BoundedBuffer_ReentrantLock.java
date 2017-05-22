package com.flyingwolf.javacode.thread.bounded;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/** 
 * @ClassName: BoundedBuffer_ReentrantLock 
 * @Description: 阻塞队列—reentrantLock实现
 * @author: Ma.Chao
 * @date: 2017年5月22日 下午3:33:23  
 */
public class BoundedBuffer_ReentrantLock {
	private Lock lock;
	private Condition notFull;
	private Condition notEmpty;
	private Object[] items ;//阻塞队列
	private int putPtr,takePtr,count;
	
	public BoundedBuffer_ReentrantLock(int length) {
		if(length < 1)
			length = 1;
		if(length > Integer.MAX_VALUE)
			length = Integer.MAX_VALUE;
		items = new Object[length];
		lock = new ReentrantLock();
		notFull = lock.newCondition();
		notEmpty = lock.newCondition();
	}
	
	public void put(Object obj) {
		lock.lock();
		System.out.println("put lock 上锁！");
		try {
			while(count == items.length){// 如果队列满了，notFull就一直等待
				System.out.println("put notFull 等待！");
				notFull.await();
			}
			items[putPtr] = obj;//队列有空余，可以插入队列
			if(++ putPtr == items.length)
				putPtr = 0;// 如果下标到达数组边界，循环下标置为0
			count ++;
			notEmpty.signal();//唤醒notEmpty
			System.out.println("notEmpty 唤醒！");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println("put lock 解锁！");
			lock.unlock();
		}
	}
	
	public Object take(){
		lock.lock();//加锁
		System.out.println("take lock 加锁！");
		try {
			while(count == 0){//如果队列空了，notEmpty就一直等到
				System.out.println("notEmpty 等待！");
				notEmpty.await();
			}
			Object obj = items[takePtr];//队列中有数据,取出队列
			if(++ takePtr == items.length)
				takePtr = 0;
			count --;
			System.out.println("notFull 唤醒！");
			notFull.signal();//notFull唤醒
			return obj;
		} catch (InterruptedException e) {
			e.printStackTrace();
			return null;
		} finally {
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		final BoundedBuffer_ReentrantLock br = new BoundedBuffer_ReentrantLock(2);
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
					br.put("kk");
					br.put("sfs");
					br.put("zz");
					br.put("zz");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		System.out.println(br.take());
	}
}
