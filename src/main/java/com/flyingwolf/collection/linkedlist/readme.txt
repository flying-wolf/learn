LinkedList学习笔记

非线程安全
继承AbstractSequentialList类
实现了List、Deque、Coneable、Serializable接口


1.数据结构
	LinkedList底层为Entry<E> header链表,写的效率较高,允许null值。
	
2.构造函数
	提供两个构造函数
	