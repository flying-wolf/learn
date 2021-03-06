一、线程的状态
1.新建状态(New):创建了线程的实例
2.就绪状态(Runnable):线程对象创建后，其他线程调用该对象的start()方法。该状态的线程位于可运行线程池中，变得可运行，等待获取CPU的使用权
3.运行状态(Running):就绪状态的线程获取了CPU资源，执行程序代码。
4.阻塞状态(Blocked):阻塞状态是线程因为某种原因放弃了CPU使用权，暂时停止运行。直到线程进入就绪状态,才有机会再次进入运行状态。
	阻塞状态的三种情况：
	1).等待阻塞：运行的线程执行wait()方法，JVM会把该线程放入等待池中。
	2).同步阻塞：执行的线程在获取对象的同步锁时，若该同步锁已被其他线程所占用，JVM会把该线程放入锁池中。
	3).其他阻塞：运行的线程执行sleep()或join()方法，或者发出了I/O请求时，JVM会把该线程置为阻塞状态。
	直到sleep()状态超时、join()等待的线程终止或超时,或者I/O请求处理完成时，该线程会重新转为就绪状态。
5.死亡状态(Dead):线程执行完成或因异常导致退出run()方法，该线程生命周期结束。


二、线程方法
	1.调整线程优先级:setPriority()和getPriority()方法分别用于设置和获取线程的优先级，线程的优先级具有继承关系；
	2.睡眠线程：Thread.sleep(long millis)方法，使线程进入阻塞状态，millis参数设定睡眠时间，以毫秒为单位，当睡眠结束后就转入就绪状态；
	3.线程等待：Object类的wait()方法，导致当前线程等待，直到其他线程调用此对象的notify()或notifyAll()方法唤醒该线程。
	4.线程让步：Thread.yield()方法，是当前线程进入就绪状态，给其他相同或更高优先级的线程一个执行的机会。
	5.线程加入：join()方法，等待其他线程终止；当前线程中调用另一个线程的join()方法，则当前线程进入阻塞状态，直到另一个线程执行结束，当前线程再由阻塞转为就绪状态。
	6.线程唤醒：Object类的notify()或notifyAll()方法，notify()唤醒在此线程监视器上等待的单个线程，如果所有线程都在次对象上等待，则会选择其中一个线程，选择是任意性的。
			notifyAll()唤醒在此线程监视器上等待的所有线程。
	
	sleep与yield方法的区别：
		1.sleep()方法会给其他线程一个运行的机会,而不会考虑其他线程的优先级,因此会给较低优先级的线程一个运行的机会;yield()方法只会给相同或更高优先级的线程一个运行的机会。
		2.sleep()方法会使线程转入阻塞状态,yield()方法会将线程转入就绪状态。
		3.sleep()方法声明抛出InterruptedException异常，而yield()方法没有声明抛出任何异常。

	如果希望明确的让一个线程给另一个线程运行机会，可以使用以下方法之一
		1.让处于运行状态的线程调用Thread.sleep()方法
		2.让处于运行状态的线程调用Thread.yield()方法
		3.让处于运行状态的线程调用另一个线程的join()方法
		
三、volatile语义
	确保volatile变量更新时以可预见的方式告知其他线程。
	1.java储存模型不会对volatile指令的操作进行指令重排，这个保证了对volatile变量操作时是按照指令顺序执行的。
	2.volatile变量不会被缓存在寄存器中或者其他对cpu不可见的地方，每次从主存中读取volatile变量的结果。
	  volatile并不能保证线程安全，也就是说volatile变量操作不是原子性操作。

四、Synchronized
	Synchronized的作用主要有三个：
		1.确保线程互斥的访问同步代码。
		2.保证共享变量的修改能够及时可见。
		3.有效的解决重排序问题。
		
	Synchronized语法共有三种用法：
		1.修饰普通方法
		2.修饰静态方法
		3.修饰代码块
		
	Synchronized实现原理：
		Synchronized编译后会生成两条指令monitorenter和monitorexit
		monitorenter:每个对象拥有一个监视器锁（monitor），当monitor被占用时就会处于锁定状态。
					  线程执行monitorenter命令是尝试获取monitor所有权过程如下
					 1).如果monitor进入数为0，则该线程进入monitor，然后将进入数设置为1，该线程即为monitor的持有者。
					 2).如果该线程已经占有了monitor，只是重新进入，则进入数+1.
					 3).如果其他线程已经占用了monitor，则该线程进入阻塞状态，知道monitor的进入数为0时在尝试获取monitor的所有权。
		
		monitorexit:指令执行时，monitor的进入数-1，当monitor的进入数为0，那么线程退出monitor，不再是这个monitor的持有者。
					其他被这个monitor阻塞的线程可以尝试获取这个monitor的所有权。

五、ReentrantLock
	ReentrantLock是基于AbstractQueuedSynchronizer实现的,AbstractQueuedSynchronizer可以实现独占锁也可以实现共享锁,
	ReentrantLock只是使用了其中的独占锁模式。

	类结构：
		ReentrantLock-->Lock
		NonfairSync/FairSync-->Sync-->AbstractQueuedSynchronizer-->AbstractOwnableSynchronizer
		NonfairSync/FairSync-->Sync是ReentrantLock的三个内部类
		Node是AbstractQueuedSynchronizer的内部类
		
	公平锁与非公平锁(默认使用非公平锁)：
		state:锁数量 volatile类型
		非公平锁(后进来的线程也能先执行)——new ReentrantLock() || new ReentrantLock(false);
			lock()方法的核心步骤：基于CAS尝试将state(锁数量)从0设置为1
				A.如果设置成功，设置当前线程为独占锁线程。
				B.如果设置失败，在重新获取一次锁数量。
				B1.如果锁数量为0，在基于CAS将state(锁数量)从0设置为1一次，如果成功则设置当前线程为独占锁线程。
				B2.如果锁数量不为0或者B1操作又失败了，检查当前线程是否已经是独占锁线程，如果是，则将当前锁数量+1；
					如果不是，则将当前线程封装到一个Node内，并加入等待队列中去，等待被其前一个线程节点唤醒。
	
		公平锁(先进来的线程先执行)——new ReentrantLock(true);
			lock()方法的核心步骤：获取一次state(锁数量)
				B1.如果锁数量为0并且当前线程是等待队列中的头节点，基于CAS将state(锁数量)从0设置为1，如果设置成功，设置当前线程为独占锁线程。
				B2.如果锁数量不为0或当前线程不是等待队列中的头节点或者B1操作失败，检查当前线程是否为独占锁线程，如果是，则将当前锁数量+1；
					如果不是，则将当前线程封装到一个Node内，并加入到等待队列中去，等待被其前一个线程节点唤醒。
	
	
	