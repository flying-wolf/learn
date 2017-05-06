package com.flyingwolf.thread.threadpool.threadlocal;

/**
 * @ClassName Person
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author Flying-Wolf
 * @Date 2017年5月7日 上午1:12:33
 * @version 1.0.0
 * 
 * 
 * ThreadLocal类用来提供线程内部的局部变量。这些变量在多线程环境下访问(通过get或set方法访问)时能保证各个线程里的变量相对独立于其他线程内的变量，ThreadLocal实例通常来说都是private static类型。 
 * 总结：ThreadLocal不是为了解决多线程访问共享变量，而是为每个线程创建一个单独的变量副本，提供了保持对象的方法和避免参数传递的复杂性。
 * 
 * ThreadLocal的主要应用场景为按线程多实例（每个线程对应一个实例）的对象的访问，并且这个对象很多地方都要用到。例如：同一个网站登录用户，每个用户服务器会为其开一个线程，每个线程中创建一个ThreadLocal，里面存用户基本信息等，在很多页面跳转时，会显示用户信息或者得到用户的一些信息等频繁操作，这样多线程之间并没有联系而且当前线程也可以及时获取想要的数据。
 * 
 * 
 * 
 */
public class Person {
	private String name;
	ThreadLocal<String> threadLocal = new ThreadLocal<String>(); 
	
	public void print() {
		System.out.println("线程："+Thread.currentThread().getName()+"-1person 当前的名字为: "+name +"--可能会存在问题");
		System.out.println("线程："+Thread.currentThread().getName()+"-2Person 当前的名字为: "+getName() +"--正确");
	}
	
	public void setName(String name) {
		this.name = name;
		Thread t = Thread.currentThread();
		if(threadLocal.get() == null) {
			threadLocal.set(this.name);
		}
		//模拟耗时操作
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	};
	
	public String getName() {
		String name = threadLocal.get();
		return name;
	}
}
