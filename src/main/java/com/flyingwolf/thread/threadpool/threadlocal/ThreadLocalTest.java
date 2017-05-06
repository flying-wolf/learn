package com.flyingwolf.thread.threadpool.threadlocal;

public class ThreadLocalTest {
	/**
	 * ThreadLocal 维护变量时，会为每个线程单独保存一份变量副本，使线程在操作变量的时候互不影响。
	 * 理解: ThreadLocal 可以解决多线程共用一个实例，而不引发并发冲突。
	 * 
	 * 使用场景思考:有一个变量在线程之间不需要共享，但在多线程情况下，该变量又存在并发问题，按并发加锁的机制
	 * 又限制了并发。
	 * 
	 *  如：有一个类A有个类变量name，类A有get、set name方法。
	 *  多线程情况下变量name存在并发问题。name又不需要线程之间共享。
	 *  这时候可以使用ThreadLocal
	 */
	
	public static void main(String[] args) {
		Person person = new Person();
		for (int i = 0; i < 10; i++) {
			Worker work = new Worker(person, "name+"+i);
			work.setName("线程"+i);
			work.start();
		}
	}
	
	/**
	 * 从执行结果上来看，Person中的name 变量存在了并发问题，使用ThreadLocal可以解决这种并发问题 
	 * 
	 * ThreadLocal 与 同步机制的区别
	 * 1.在同步机制中，通过对象的锁机制保证同一时间只有一个线程访问变量。如果变量是线程间共享的，使用同步机制需要程序
	 * 缜密分析什么时候对变量进行读写，什么时候锁定对象，什么时候释放锁，这个操作是比较复杂的
	 * 
	 * 2.ThreadLocal 使用了另外一种解决方案，对每个访问变量的线程都会保存一份变量的副本，这样每个线程访问的都是自己
	 * 线程内的变量，隔绝了线程之间对变量的并发问题。ThreadLocal 提供了线程安全的对象封装，在开发过程中，可以讲线程不
	 * 安全的变量存放在ThreadLocal 中
	 * 
	 * 
	 * 
	 */
}
