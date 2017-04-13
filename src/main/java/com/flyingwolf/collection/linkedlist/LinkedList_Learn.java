package com.flyingwolf.collection.linkedlist;

import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Queue;


/** 
 * LinkedList-列表接口的链表实现
 * 
 * 概述：
 * 	1.实现了所有可选的列表操作,允许操作所有元素(包括null)；
 * 	2.除了实现List接口外,LinkedList类还在列表的开头及结尾 get、remove和insert元素提供了统一命名方法。
 * 	这些操作允许将linkedList用作堆栈，队列或者双端队列；
 * 	3.实现了Deque接口，为add、poll提供先进先出队列操作，以及其他队列和双端队列操作；
 * 	4.所有操作都是按照双重链接列表的需要执行的。在列表中索引的操作将从列表的开头或结尾遍历列表（从靠近指定索引的一端）；
 * 	5.LinkedList是非线程安全的；
 * 
 * 定义：
 * 	1.LinkedList是一个继承于AbstractSequentialList类的双向链表。可以被当作堆栈、队列或双端队列进行操作；
 * 	2.LinkedList实现了List接口，提供了队列操作；
 * 	3.LinkedList实现了Deque接口，能将LinkedList当作双端队列使用；
 *  4.LinkedList实现了Cloneable接口，即覆盖了clone函数，能克隆；
 *  5.LinkedList实现了Serializable接口，可实现序列化；
 * 	6.AbstractSequentialList类提供了List接口的get、set、add和remove这些骨干性函数的实现，降低了List接口的复杂度。
 * 
 * 数据结构：
 * 	LinkedList的底层结构是基于双向循环列表的，且head节点中不存放数据。
 * 
 * 属性：
 * 	1.header是双向链表的头节点,它是双向链表节点所对应的类Entry的实例.Entry中包含成员变量：
 * 	element 该节点所包含的值
 * 	next 该节点的下一节点
 * 	previous 该节点的上一节点
 * 	2.size是双向链表中节点实例的个数
 * 
 * 构造函数：	
 * 	1.LinkedList() 无参构造函数，该函数具体实现是构造一个空列表,里面没有任何元素，将header节点的前后节点(指针)都指向header;
 * 	2.LinkedList(Collecation<? extends E> c) 先调用无参构造函数构造一个空的链表，
 * 	然后调用addAll()方法将接收到的Collecation参数的全部元素添加到链表中，这些元素按照Collecation迭代器返回顺序排列。
 * 
 * 增加元素方法：
 * 	1.addBefore(E e,entry) 在entry之前插入e构造的新节点，此方法为LinkedList的私有方法也是所有插入元素方法的基础方法
 * 	先通过Entry的构造方法创建e的节点newEntry
 * （包含了将其下一个节点设置为entry，上一个节点设置为entry.previous的操作，相当于修改newEntry的“指针”），
 *  之后修改插入位置后newEntry的前一节点的next引用和后一节点的previous引用，
 *  使链表节点间的引用关系保持正确。之后修改和size大小和记录modCount，然后返回新插入的节点。
 *  2.add(E e) 在header节点之前插入由e构造的新节点
 *  3.add(int index,E e) 在此链表的指定位置插入指定元素
 *  如果链表本身为空则在header节点之前插入指定元素，否则在entry的指定节点之前插入e
 *  4.addFirst(E e) 将指定元素插入此列表的开头
 *  5.addLast(E e) 将指定元素插入此列表的尾部
 *  6.addAll(Collection<? extends E> c) 添加指定Collectaion的所有元素添加到此链表的尾部，顺序按照Collecation迭代器返回的顺序添加
 *  7.addAll(int index, Collection<? extends E> c) 将指定Collecation中的所有元素从链表的指定位置开始添加
 *  8.jdk1.6中新增offerFirst(),offerLast()方法代替原来的addFirst(),addLast()方法,
 *  区别在于新方法在向一个有容量限制并且已经满了的队列中添加元素时返回false,而旧方法只会抛出异常
 *  
 * 删除元素方法：
 * 	1.remove(Entry<E> e) 移除并返回指定的节点 ，该方法是LinkedList的私有方法,事LinkedList所有移除方法的基础方法，具体实现如下：
 * 	1).获取被移除的节点，最后返回
 *  2).将该节点的前一节点的next指向该节点的后一节点
 *  3).将该节点的后一节点的previous指向该节点的前一节点
 * 	这两步实现将该节点从链表中剔除
 * 	4).将该节点置空
 * 	5).重新计算size
 * 	6).返回被移除的节点即第1)步获取的节点
 * 	2.removeFirst() 移除并返回此链表的第一个元素
 * 	3.removeLast() 移除并返回此链表的最后一个元素
 * 	4.remove(Object) 移除链表中首次出现的指定元素
 * 	5.1.6中新增的方法pollFirst(),pollLast(),与offerFirst(),offerLast()目标一致
 * 
 * 查找元素方法：
 * 	1.entry<int index> 根据指定的索引位置查找并返回节点,此方法为私有方法,是所有查找方法的基础方法
 * 	2.getFisrt() 查找并返回此链表的第一个节点
 * 	3.getLast() 查找并返回此链表的最后一个节点
 * 	4.get(int index) 查找并返回指定索引位置的节点
 * 	5.1.6新增offerFirst() offerLast()方法
 *  
 * 
 * 
 * 
 */
public class LinkedList_Learn<E>
    extends AbstractSequentialList<E>
    implements List<E>, Deque<E>, Cloneable, java.io.Serializable
{
	
    /**
     * @Field @header : TODO 双向链表的头节点,它是双向链表中Entry的实例
     */
    private transient Entry<E> header = new Entry<E>(null, null, null);
    /**
     * @Field @size : TODO 双向链表中节点数量
     */
    private transient int size = 0;

    /**
     * @Description TODO 无参构造函数
     */
    public LinkedList_Learn() {
    	//头节点的后指针指向头节点前前指针并指向头节点
    	//其实就是构造一个空的链表
        header.next = header.previous = header;
    }

    /**
     * @Description TODO 构造一个包含指定Collection所有元素的双向链表,链表元素的排列顺序为Collecation迭代器返回顺序
     * @param c
     */
    public LinkedList_Learn(Collection<? extends E> c) {
    	//先调用无参构造函数构造一个空链表
		this();
		//然后调用addAll(Collection<? extends E> c) 从链表的尾部开始插入Collection包含的所有元素
		//插入顺序为Collection迭代器返回的元素顺序
		addAll(c);
    }

    /**
     * @Description (TODO 查找并返回此链表的第一个节点,链表为空时抛出异常)
     * @return
     */
    public E getFirst() {
		if (size==0)
		    throw new NoSuchElementException();
	
		return header.next.element;
    }

    /**
     * @Description (TODO 查找并返回此链表的最后一个节点,链表为空时抛出异常)
     * @return
     */
    public E getLast()  {
		if (size==0)
		    throw new NoSuchElementException();
	
		return header.previous.element;
    }

    /**
     * @Description (TODO 移除并返回此链表中的第一个节点,此链表为空时抛出异常)
     * @return
     */
    public E removeFirst() {
    	//移除并返回header后指针指向的节点
    	return remove(header.next);
    }

    /**
     * @Description (TODO 移除并返回此链表的最后一个节点,此链表为空时抛出异常)
     * @return
     */
    public E removeLast() {
    	//移除并返回header前指针指向的节点
    	return remove(header.previous);
    }

    /**
     * @Description (TODO 将指定元素插入到链表的第一个位置)
     * @param e
     */
    public void addFirst(E e) {
    	//将指定元素e添加到header节点的下一个节点的前面
    	addBefore(e, header.next);
    }

    /**
     * @Description (TODO 将指定元素添加到此链表的最后)
     * @param e
     */
    public void addLast(E e) {
    	//将指定元素e添加到header节点的前面
    	addBefore(e, header);
    }

    /**
     * Returns <tt>true</tt> if this list contains the specified element.
     * More formally, returns <tt>true</tt> if and only if this list contains
     * at least one element <tt>e</tt> such that
     * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>.
     *
     * @param o element whose presence in this list is to be tested
     * @return <tt>true</tt> if this list contains the specified element
     */
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    public int size() {
	return size;
    }

    /**
     * @Description (TODO 将指定的元素添加到此链表的最后,并返回true)
     * @param e
     * @return
     */
    public boolean add(E e) {
    	//将指定元素e添加到header节点之前
    	addBefore(e, header);
    	//返回true
        return true;
    }
    
    /**
     * 移除此链表中首次出现的指定元素
     */
    public boolean remove(Object o) {
    	//判断需要移除的元素是否为null
        if (o==null) {
        	//循环链表
            for (Entry<E> e = header.next; e != header; e = e.next) {
            	//找到首次出现的元素为null的节点
                if (e.element==null) {
                	//移除该节点并返回true
                    remove(e);
                    return true;
                }
            }
        } else {
        	//循环链表
            for (Entry<E> e = header.next; e != header; e = e.next) {
            	//通过equals方法查找首次出现的元素值相同的节点
                if (o.equals(e.element)) {
                	//移除该节点并返回true
                    remove(e);
                    return true;
                }
            }
        }
        //如果指定的元素在链表中不存在则返回false
        return false;
    }

    /**
     * @Description (TODO 从此链表的尾部开始插入指定Collection的所有元素,插入顺序为Collection迭代器返回的元素顺序)
     * @param c
     * @return
     */
    public boolean addAll(Collection<? extends E> c) {
    	//从此链表最后一个节点的下一索引位置添加Collection的所有元素
        return addAll(size, c);
    }

    /**
     * @Description (TODO 从此链表的指定位置开始插入指定Collection中的所有元素,插入顺序为Collection迭代器返回的元素顺序)
     * @param index
     * @param c
     * @return
     */
    public boolean addAll(int index, Collection<? extends E> c) {
    	//检查索引是否正确
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: "+index+
                                                ", Size: "+size);
        //Collection转数组
        Object[] a = c.toArray();
        //需要添加的元素数量
        int numNew = a.length;
        //数量验证
        if (numNew==0)
            return false;
        
        //操作次数+1
        modCount++;

        //获取需要添加节点的后指针指向
        Entry<E> successor = (index==size ? header : entry(index));
        //获取需要添加节点的前指针指向
        Entry<E> predecessor = successor.previous;
        //循环Collection的所有元素
        for (int i=0; i<numNew; i++) {
        	//根据Collection的每一个元素构造节点
            Entry<E> e = new Entry<E>((E)a[i], successor, predecessor);
            //修改前指针指向
            predecessor.next = e;
            predecessor = e;
        }
        //修改后指针引用
        successor.previous = predecessor;
        //容量+collection容量
        size += numNew;
        //返回true
        return true;
    }

    /**
     * @Description (TODO 清空链表中的所有节点)
     */
    public void clear() {
    	//循环所有节点置空节点元素
        Entry<E> e = header.next;
        while (e != header) {
            Entry<E> next = e.next;
            e.next = e.previous = null;
            e.element = null;
            e = next;
        }
        //重新修改header前后指针指向header自身
        header.next = header.previous = header;
        //清空容量
        size = 0;
        //操作计数+1
        modCount++;
    }


    // Positional Access Operations

    /**
     * @Description (TODO 查找并返回指定索引位置的节点)
     * @param index
     * @return
     */
    public E get(int index) {
        return entry(index).element;
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
     *
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public E set(int index, E element) {
        Entry<E> e = entry(index);
        E oldVal = e.element;
        e.element = element;
        return oldVal;
    }

    /**
     * @Description (TODO 将指定元素添加到此链表的指定索引位置)
     * @param index
     * @param element
     */
    public void add(int index, E element) {
    	//分为两种情况:
    	//1).链表为空时将指定的元素添加到header节点之前
    	//2).链表非空时将指定元素添加到指定索引位置的节点之前
        addBefore(element, (index==size ? header : entry(index)));
    }

    /**
     * @Description (TODO 移除并返回指定索引位置的节点)
     * @param index
     * @return
     */
    public E remove(int index) {
    	//移除并返回指定索引位置的节点
        return remove(entry(index));
    }

    /**
     * @Description (TODO 查找并返回指定索引位置的节点)
     * @param index
     * @return
     */
    private Entry<E> entry(int index) {
    	//索引检查
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: "+index+
                                                ", Size: "+size);
        //获取header节点
        Entry<E> e = header;
        //将链表分为左右两部分,根据索引循环所在的半个链表
        //这样做的目的是为了提高性能,最多只需循半个链表
        if (index < (size >> 1)) {
            for (int i = 0; i <= index; i++)
                e = e.next;
        } else {
            for (int i = size; i > index; i--)
                e = e.previous;
        }
        return e;
    }


    // Search Operations

    /**
     * Returns the index of the first occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     * More formally, returns the lowest index <tt>i</tt> such that
     * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>,
     * or -1 if there is no such index.
     *
     * @param o element to search for
     * @return the index of the first occurrence of the specified element in
     *         this list, or -1 if this list does not contain the element
     */
    public int indexOf(Object o) {
        int index = 0;
        if (o==null) {
            for (Entry e = header.next; e != header; e = e.next) {
                if (e.element==null)
                    return index;
                index++;
            }
        } else {
            for (Entry e = header.next; e != header; e = e.next) {
                if (o.equals(e.element))
                    return index;
                index++;
            }
        }
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     * More formally, returns the highest index <tt>i</tt> such that
     * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>,
     * or -1 if there is no such index.
     *
     * @param o element to search for
     * @return the index of the last occurrence of the specified element in
     *         this list, or -1 if this list does not contain the element
     */
    public int lastIndexOf(Object o) {
        int index = size;
        if (o==null) {
            for (Entry e = header.previous; e != header; e = e.previous) {
                index--;
                if (e.element==null)
                    return index;
            }
        } else {
            for (Entry e = header.previous; e != header; e = e.previous) {
                index--;
                if (o.equals(e.element))
                    return index;
            }
        }
        return -1;
    }

    // Queue operations.

    /**
     * Retrieves, but does not remove, the head (first element) of this list.
     * @return the head of this list, or <tt>null</tt> if this list is empty
     * @since 1.5
     */
    public E peek() {
        if (size==0)
            return null;
        return getFirst();
    }

    /**
     * Retrieves, but does not remove, the head (first element) of this list.
     * @return the head of this list
     * @throws NoSuchElementException if this list is empty
     * @since 1.5
     */
    public E element() {
        return getFirst();
    }

    /**
     * Retrieves and removes the head (first element) of this list
     * @return the head of this list, or <tt>null</tt> if this list is empty
     * @since 1.5
     */
    public E poll() {
        if (size==0)
            return null;
        return removeFirst();
    }

    /**
     * @Description (TODO 移除并返回此链表的第一个节点)
     * @return
     */
    public E remove() {
        return removeFirst();
    }

    /**
     * Adds the specified element as the tail (last element) of this list.
     *
     * @param e the element to add
     * @return <tt>true</tt> (as specified by {@link Queue#offer})
     * @since 1.5
     */
    public boolean offer(E e) {
        return add(e);
    }

    // Deque operations
    /**
     * @Description (TODO 将指定元素添加到双端队列的最前面,并返回添加状态,
     * 				此方法与addFirst()方法的区别在于向一个容量有限且已满的双端队列中添加元素时前者会返回false,
     * 				后者抛出异常)
     * @param e
     * @return
     */
    public boolean offerFirst(E e) {
        addFirst(e);
        return true;
    }

    /**
     * @Description (TODO 将指定元素添加到双端队列的尾部,并返回添加状态,
     * 				此方法与addLast()方法的区别在于向一个容量有限且已满的双端队列中添加元素时前者会返回false,
     * 				后者抛出异常)
     * @param e
     * @return
     */
    public boolean offerLast(E e) {
        addLast(e);
        return true;
    }

    /**
     * Retrieves, but does not remove, the first element of this list,
     * or returns <tt>null</tt> if this list is empty.
     *
     * @return the first element of this list, or <tt>null</tt>
     *         if this list is empty
     * @since 1.6
     */
    public E peekFirst() {
        if (size==0)
            return null;
        return getFirst();
    }

    /**
     * Retrieves, but does not remove, the last element of this list,
     * or returns <tt>null</tt> if this list is empty.
     *
     * @return the last element of this list, or <tt>null</tt>
     *         if this list is empty
     * @since 1.6
     */
    public E peekLast() {
        if (size==0)
            return null;
        return getLast();
    }

    /**
     * @Description (TODO 移除并返回链表的第一个节点,如果链表为空则返回null)
     * @return
     */
    public E pollFirst() {
        if (size==0)
            return null;
        return removeFirst();
    }

    /**
     * @Description (TODO 移除并返回链表的最后一个节点,如果链表为空则返回null)
     * @return
     */
    public E pollLast() {
        if (size==0)
            return null;
        return removeLast();
    }

    /**
     * Pushes an element onto the stack represented by this list.  In other
     * words, inserts the element at the front of this list.
     *
     * <p>This method is equivalent to {@link #addFirst}.
     *
     * @param e the element to push
     * @since 1.6
     */
    public void push(E e) {
        addFirst(e);
    }

    /**
     * Pops an element from the stack represented by this list.  In other
     * words, removes and returns the first element of this list.
     *
     * <p>This method is equivalent to {@link #removeFirst()}.
     *
     * @return the element at the front of this list (which is the top
     *         of the stack represented by this list)
     * @throws NoSuchElementException if this list is empty
     * @since 1.6
     */
    public E pop() {
        return removeFirst();
    }

    /**
     * Removes the first occurrence of the specified element in this
     * list (when traversing the list from head to tail).  If the list
     * does not contain the element, it is unchanged.
     *
     * @param o element to be removed from this list, if present
     * @return <tt>true</tt> if the list contained the specified element
     * @since 1.6
     */
    public boolean removeFirstOccurrence(Object o) {
        return remove(o);
    }

    /**
     * Removes the last occurrence of the specified element in this
     * list (when traversing the list from head to tail).  If the list
     * does not contain the element, it is unchanged.
     *
     * @param o element to be removed from this list, if present
     * @return <tt>true</tt> if the list contained the specified element
     * @since 1.6
     */
    public boolean removeLastOccurrence(Object o) {
        if (o==null) {
            for (Entry<E> e = header.previous; e != header; e = e.previous) {
                if (e.element==null) {
                    remove(e);
                    return true;
                }
            }
        } else {
            for (Entry<E> e = header.previous; e != header; e = e.previous) {
                if (o.equals(e.element)) {
                    remove(e);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Returns a list-iterator of the elements in this list (in proper
     * sequence), starting at the specified position in the list.
     * Obeys the general contract of <tt>List.listIterator(int)</tt>.<p>
     *
     * The list-iterator is <i>fail-fast</i>: if the list is structurally
     * modified at any time after the Iterator is created, in any way except
     * through the list-iterator's own <tt>remove</tt> or <tt>add</tt>
     * methods, the list-iterator will throw a
     * <tt>ConcurrentModificationException</tt>.  Thus, in the face of
     * concurrent modification, the iterator fails quickly and cleanly, rather
     * than risking arbitrary, non-deterministic behavior at an undetermined
     * time in the future.
     *
     * @param index index of the first element to be returned from the
     *              list-iterator (by a call to <tt>next</tt>)
     * @return a ListIterator of the elements in this list (in proper
     *         sequence), starting at the specified position in the list
     * @throws IndexOutOfBoundsException {@inheritDoc}
     * @see List#listIterator(int)
     */
    public ListIterator<E> listIterator(int index) {
	return new ListItr(index);
    }

    private class ListItr implements ListIterator<E> {
	private Entry<E> lastReturned = header;
	private Entry<E> next;
	private int nextIndex;
	private int expectedModCount = modCount;

	ListItr(int index) {
	    if (index < 0 || index > size)
		throw new IndexOutOfBoundsException("Index: "+index+
						    ", Size: "+size);
	    if (index < (size >> 1)) {
		next = header.next;
		for (nextIndex=0; nextIndex<index; nextIndex++)
		    next = next.next;
	    } else {
		next = header;
		for (nextIndex=size; nextIndex>index; nextIndex--)
		    next = next.previous;
	    }
	}

	public boolean hasNext() {
	    return nextIndex != size;
	}

	public E next() {
	    checkForComodification();
	    if (nextIndex == size)
		throw new NoSuchElementException();

	    lastReturned = next;
	    next = next.next;
	    nextIndex++;
	    return lastReturned.element;
	}

	public boolean hasPrevious() {
	    return nextIndex != 0;
	}

	public E previous() {
	    if (nextIndex == 0)
		throw new NoSuchElementException();

	    lastReturned = next = next.previous;
	    nextIndex--;
	    checkForComodification();
	    return lastReturned.element;
	}

	public int nextIndex() {
	    return nextIndex;
	}

	public int previousIndex() {
	    return nextIndex-1;
	}

	public void remove() {
            checkForComodification();
            Entry<E> lastNext = lastReturned.next;
            try {
                LinkedList_Learn.this.remove(lastReturned);
            } catch (NoSuchElementException e) {
                throw new IllegalStateException();
            }
	    if (next==lastReturned)
                next = lastNext;
            else
		nextIndex--;
	    lastReturned = header;
	    expectedModCount++;
	}

	public void set(E e) {
	    if (lastReturned == header)
		throw new IllegalStateException();
	    checkForComodification();
	    lastReturned.element = e;
	}

	public void add(E e) {
	    checkForComodification();
	    lastReturned = header;
	    addBefore(e, next);
	    nextIndex++;
	    expectedModCount++;
	}

	final void checkForComodification() {
	    if (modCount != expectedModCount)
		throw new ConcurrentModificationException();
	}
    }

    private static class Entry<E> {
	E element;
	Entry<E> next;
	Entry<E> previous;

	Entry(E element, Entry<E> next, Entry<E> previous) {
	    this.element = element;
	    this.next = next;
	    this.previous = previous;
	}
    }

    /**
     * @Description (TODO 在指定节点之前添加指定元素,并返回新增节点)
     * @param e
     * @param entry 
     * @return
     */
    private Entry<E> addBefore(E e, Entry<E> entry) {
    	//根据e构造新的节点newEntry
    	//newEntry的后指针指向entry
    	//newEntry的前指针指向entry的前指针
		Entry<E> newEntry = new Entry<E>(e, entry, entry.previous);
		//修改newEntry的前后指针引用
		//newEntry的前指针指向的节点的后指针指向newEntry
		newEntry.previous.next = newEntry;
		//newEntry的后指针指向的节点的前指针指向newEntry
		newEntry.next.previous = newEntry;
		//容量+1
		size++;
		//操作次数+1
		modCount++;
		//返回新节点
		return newEntry;
    }

    /**
     * @Description (TODO 移除并返回指定的节点)
     * @param e
     * @return
     */
    private E remove(Entry<E> e) {
    	//如果链表为空抛出异常
		if (e == header)
		    throw new NoSuchElementException();
		//得到需要移除的节点
	    E result = e.element;
	    //修改e的前后指针指向
		e.previous.next = e.next;
		e.next.previous = e.previous;
		//置空节点元素
        e.next = e.previous = null;
        e.element = null;
        //容量-1
		size--;
		//操作计数+1
		modCount++;
		//返回被移除的节点
        return result;
    }

    /**
     * @since 1.6
     */
    public Iterator<E> descendingIterator() {
        return new DescendingIterator();
    }

    /** Adapter to provide descending iterators via ListItr.previous */
    private class DescendingIterator implements Iterator {
        final ListItr itr = new ListItr(size());
	public boolean hasNext() {
	    return itr.hasPrevious();
	}
	public E next() {
            return itr.previous();
        }
	public void remove() {
            itr.remove();
        }
    }

    /**
     * Returns a shallow copy of this <tt>LinkedList</tt>. (The elements
     * themselves are not cloned.)
     *
     * @return a shallow copy of this <tt>LinkedList</tt> instance
     */
    public Object clone() {
        LinkedList_Learn<E> clone = null;
	try {
	    clone = (LinkedList_Learn<E>) super.clone();
	} catch (CloneNotSupportedException e) {
	    throw new InternalError();
	}

        // Put clone into "virgin" state
        clone.header = new Entry<E>(null, null, null);
        clone.header.next = clone.header.previous = clone.header;
        clone.size = 0;
        clone.modCount = 0;

        // Initialize clone with our elements
        for (Entry<E> e = header.next; e != header; e = e.next)
            clone.add(e.element);

        return clone;
    }

    /**
     * Returns an array containing all of the elements in this list
     * in proper sequence (from first to last element).
     *
     * <p>The returned array will be "safe" in that no references to it are
     * maintained by this list.  (In other words, this method must allocate
     * a new array).  The caller is thus free to modify the returned array.
     *
     * <p>This method acts as bridge between array-based and collection-based
     * APIs.
     *
     * @return an array containing all of the elements in this list
     *         in proper sequence
     */
    public Object[] toArray() {
	Object[] result = new Object[size];
        int i = 0;
        for (Entry<E> e = header.next; e != header; e = e.next)
            result[i++] = e.element;
	return result;
    }

    /**
     * Returns an array containing all of the elements in this list in
     * proper sequence (from first to last element); the runtime type of
     * the returned array is that of the specified array.  If the list fits
     * in the specified array, it is returned therein.  Otherwise, a new
     * array is allocated with the runtime type of the specified array and
     * the size of this list.
     *
     * <p>If the list fits in the specified array with room to spare (i.e.,
     * the array has more elements than the list), the element in the array
     * immediately following the end of the list is set to <tt>null</tt>.
     * (This is useful in determining the length of the list <i>only</i> if
     * the caller knows that the list does not contain any null elements.)
     *
     * <p>Like the {@link #toArray()} method, this method acts as bridge between
     * array-based and collection-based APIs.  Further, this method allows
     * precise control over the runtime type of the output array, and may,
     * under certain circumstances, be used to save allocation costs.
     *
     * <p>Suppose <tt>x</tt> is a list known to contain only strings.
     * The following code can be used to dump the list into a newly
     * allocated array of <tt>String</tt>:
     *
     * <pre>
     *     String[] y = x.toArray(new String[0]);</pre>
     *
     * Note that <tt>toArray(new Object[0])</tt> is identical in function to
     * <tt>toArray()</tt>.
     *
     * @param a the array into which the elements of the list are to
     *          be stored, if it is big enough; otherwise, a new array of the
     *          same runtime type is allocated for this purpose.
     * @return an array containing the elements of the list
     * @throws ArrayStoreException if the runtime type of the specified array
     *         is not a supertype of the runtime type of every element in
     *         this list
     * @throws NullPointerException if the specified array is null
     */
    public <T> T[] toArray(T[] a) {
        if (a.length < size)
            a = (T[])java.lang.reflect.Array.newInstance(
                                a.getClass().getComponentType(), size);
        int i = 0;
	Object[] result = a;
        for (Entry<E> e = header.next; e != header; e = e.next)
            result[i++] = e.element;

        if (a.length > size)
            a[size] = null;

        return a;
    }

    private static final long serialVersionUID = 876323262645176354L;

    /**
     * Save the state of this <tt>LinkedList</tt> instance to a stream (that
     * is, serialize it).
     *
     * @serialData The size of the list (the number of elements it
     *             contains) is emitted (int), followed by all of its
     *             elements (each an Object) in the proper order.
     */
    private void writeObject(java.io.ObjectOutputStream s)
        throws java.io.IOException {
	// Write out any hidden serialization magic
	s.defaultWriteObject();

        // Write out size
        s.writeInt(size);

	// Write out all elements in the proper order.
        for (Entry e = header.next; e != header; e = e.next)
            s.writeObject(e.element);
    }

    /**
     * Reconstitute this <tt>LinkedList</tt> instance from a stream (that is
     * deserialize it).
     */
    private void readObject(java.io.ObjectInputStream s)
        throws java.io.IOException, ClassNotFoundException {
	// Read in any hidden serialization magic
	s.defaultReadObject();

        // Read in size
        int size = s.readInt();

        // Initialize header
        header = new Entry<E>(null, null, null);
        header.next = header.previous = header;

	// Read in all elements in the proper order.
	for (int i=0; i<size; i++)
            addBefore((E)s.readObject(), header);
    }
}
